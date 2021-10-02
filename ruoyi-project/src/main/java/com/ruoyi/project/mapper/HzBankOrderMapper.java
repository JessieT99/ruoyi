package com.ruoyi.project.mapper;

import com.ruoyi.project.domain.HzBankOrder;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 充电宝订单 数据层
 * 
 * @author ruoyi
 * @date 2021-09-16
 */
public interface HzBankOrderMapper 
{
	/**
     * 查询充电宝订单信息
     * 
     * @param id 充电宝订单ID
     * @return 充电宝订单信息
     */
	public HzBankOrder selectHzBankOrderById(Long id);
	
	/**
     * 查询充电宝订单列表
     * 
     * @param hzBankOrder 充电宝订单信息
     * @return 充电宝订单集合
     */
	public List<HzBankOrder> selectHzBankOrderList(HzBankOrder hzBankOrder);
	
	/**
     * 新增充电宝订单
     * 
     * @param hzBankOrder 充电宝订单信息
     * @return 结果
     */
	public int insertHzBankOrder(HzBankOrder hzBankOrder);
	
	/**
     * 修改充电宝订单
     * 
     * @param hzBankOrder 充电宝订单信息
     * @return 结果
     */
	public int updateHzBankOrder(HzBankOrder hzBankOrder);
	
	/**
     * 删除充电宝订单
     * 
     * @param id 充电宝订单ID
     * @return 结果
     */
	public int deleteHzBankOrderById(Long id);
	
	/**
     * 批量删除充电宝订单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHzBankOrderByIds(String[] ids);

    List<HzBankOrder> getBankHzOrder(@Param("openId") String openId, String qrCode,@Param("date")Date date);

	List<HzBankOrder> getBankHzOrderByOpenId(@Param("openId") String openId,String qrCode);

	HzBankOrder selectHzBankOrderByBankId(@Param("bankId")String bankId);
}