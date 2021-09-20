package com.ruoyi.project.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.SplitFile;
import com.ruoyi.project.mqtt.MqttUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.HzOrderAdvertisingMapper;
import com.ruoyi.project.domain.HzOrderAdvertising;
import com.ruoyi.project.service.IHzOrderAdvertisingService;
import com.ruoyi.common.core.text.Convert;

/**
 * 广告订单 服务层实现
 *
 * @author ruoyi
 * @date 2021-06-25
 */
@Service
public class HzOrderAdvertisingServiceImpl implements IHzOrderAdvertisingService {
    @Autowired
    private HzOrderAdvertisingMapper orderAdvertisingMapper;

    @Autowired
    private MqttUtil mqttUtil;


    /**
     * 查询广告订单信息
     *
     * @param id 广告订单ID
     * @return 广告订单信息
     */
    @Override
    public HzOrderAdvertising selectOrderAdvertisingById(Long id) {
        return orderAdvertisingMapper.selectHzOrderAdvertisingById(id);
    }

    /**
     * 查询广告订单列表
     *
     * @param orderAdvertising 广告订单信息
     * @return 广告订单集合
     */
    @Override
    public List<HzOrderAdvertising> selectOrderAdvertisingList(HzOrderAdvertising orderAdvertising) {
        return orderAdvertisingMapper.selectHzOrderAdvertisingList(orderAdvertising);
    }

    /**
     * 新增广告订单
     *
     * @param orderAdvertising 广告订单信息
     * @return 结果
     */
    @Override
    public int insertOrderAdvertising(HzOrderAdvertising orderAdvertising) {
        return orderAdvertisingMapper.insertHzOrderAdvertising(orderAdvertising);
    }

    /**
     * 修改广告订单
     *
     * @param orderAdvertising 广告订单信息
     * @return 结果
     */
    @Override
    public int updateOrderAdvertising(HzOrderAdvertising orderAdvertising) {
        return orderAdvertisingMapper.updateHzOrderAdvertising(orderAdvertising);
    }

    /**
     * 删除广告订单对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOrderAdvertisingByIds(String ids) {
        return orderAdvertisingMapper.deleteHzOrderAdvertisingByIds(Convert.toStrArray(ids));
    }

    @Override
    public int submitOrder(HzOrderAdvertising orderAdvertising) {
        //订单编号
        String code = System.currentTimeMillis() + "000" + (orderAdvertising.getUserId() == null ? 1 : orderAdvertising.getUserId());
        orderAdvertising.setOrderCode(code);
        orderAdvertising.setOrderTime(new Date());
        int i = orderAdvertisingMapper.insertHzOrderAdvertising(orderAdvertising);
        if (i > 0) {
			Map<String,Object> data = new HashMap<>();
			data.put("openId",orderAdvertising.getOpenId());
			data.put("content",orderAdvertising.getAdvertisingContent());
			data.put("imgUrl",orderAdvertising.getAdvertisingImg());
			mqttUtil.testPublishMessage("test_queue",data);
        }
        if (!StringUtils.isEmpty(orderAdvertising.getAdvertisingImg())){
            String[] split = orderAdvertising.getAdvertisingImg().split(",");
            for (String str:split){
                SplitFile.getShardFile(str);
            }
        }
        return i;
    }

}
