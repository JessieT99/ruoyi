package com.ruoyi.common.utils.file;

import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SplitFile {

    public static void main(String[] args) throws IOException {
//        getSplitFile();
        String file = SplitFileParam.file; //文件的路径
        RandomAccessFile raf = null;
        raf = new RandomAccessFile(new File(file), "r");
        long length = raf.length();//文件的总长度
        long maxSize = SplitFileParam.maxSize;//文件切片后的长度
        long count = length / maxSize; //文件分割的份数
        merge(SplitFileParam.outfile, SplitFileParam.file, count);
    }

    /**
     * 文件分割方法
     * @return
     */
    public static long getSplitFile(String file) {
//        String file = SplitFileParam.file; //文件的路径
        long result = 0L;
        RandomAccessFile raf = null;
        try {
            //获取目标文件 预分配文件所占的空间 在磁盘中创建一个指定大小的文件   r 是只读
            raf = new RandomAccessFile(new File(file), "r");
            long length = raf.length();//文件的总长度
            long maxSize = SplitFileParam.maxSize;//文件切片后的长度
//            long count = length/maxSize; //文件分割的份数
            long count = length / maxSize; //文件分割的份数
            long offSet = 0L;//初始化偏移量
            for (long i = 0; i < count; i++) { //最后一片单独处理  我这样计算出来的 count  本身  就是 吧 最后一片 除掉的
                long begin = offSet;
                long end = (i + 1) * maxSize;
//                offSet = writeFile(file, begin, end, i);
                offSet = getWrite(file, i, begin, end);
            }
            if (length - offSet > 0) {
                getWrite(file, count, offSet, length);
                count++;
            }
            result = count;

        } catch (FileNotFoundException e) {
            System.out.println("没有找到文件");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 指定文件每一份的边界，写入不同文件中
     *
     * @param file  源文件
     * @param i     源文件的顺序标识
     * @param begin 开始指针的位置
     * @param end   结束指针的位置
     * @return long
     */
    public static long getWrite(String file, long i, long begin, long end) {
        String a = file.split(".mp3")[0];
        long endPointer = 0L;
        byte[] data = null;
        try {
            //申明文件切割后的文件磁盘
            RandomAccessFile in = new RandomAccessFile(new File(file), "r");
            //定义一个可读，可写的文件并且后缀名为.tmp的二进制文件
            RandomAccessFile out = new RandomAccessFile(new File(a + "_" + i + ".bmp"), "rw");

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            //申明具体每一文件的字节数组
            byte[] b = new byte[1024];
            int n = 0;
            //从指定位置读取文件字节流
            in.seek(begin);
            //判断文件流读取的边界
            while (in.getFilePointer() < end && (n = in.read(b)) != -1) {
                if (in.getFilePointer() > end && in.getFilePointer() < 615420) {
                    System.out.println(in.getFilePointer());
                }
                //从指定每一份文件的范围，写入不同的文件
//                baos.write(b, 0, n);
                out.write(b, 0, n);

            }
            data = baos.toByteArray();
            String str = new String(data, "UTF-8");
            //定义当前读取文件的指针
            endPointer = in.getFilePointer();
            //关闭输入流
            in.close();
            //关闭输出流
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endPointer;
    }

    /**
     * 文件合并
     *
     * @param file     指定合并文件
     * @param tempFile 分割前的文件名
     * @param count    文件个数
     */
    public static void merge(String file, String tempFile, long count) {
        String a = tempFile.split(".mp3")[0];
        RandomAccessFile raf = null;
        try {
            //申明随机读取文件RandomAccessFile
            raf = new RandomAccessFile(new File(file), "rw");
            //开始合并文件，对应切片的二进制文件
            for (int i = 0; i < count + 1; i++) {
                //读取切片文件
                RandomAccessFile reader = new RandomAccessFile(new File(a + "_" + i + ".tmp"), "r");
                byte[] b = new byte[1024];
                int n = 0;
                //先读后写
                while ((n = reader.read(b)) != -1) {//读
                    raf.write(b, 0, n);//写
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}