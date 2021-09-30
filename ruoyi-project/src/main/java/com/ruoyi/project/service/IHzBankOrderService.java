package com.ruoyi.project.service;

import com.ruoyi.project.domain.HzBankOrder;
import com.ruoyi.project.vo.HzBankRequestVO;

import java.util.Date;
import java.util.List;

/**
 * 充电宝订单 服务层
 * 
 * @author ruoyi
 * @date 2021-09-16
 */
public interface IHzBankOrderService 
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
     * 删除充电宝订单信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHzBankOrderByIds(String ids);

	/**
	 * 查询充电宝订单信息
	 *
	 * @param  openId 需要删除的数据ID
	 * @param  qrCode 需要删除的数据ID
	 * @param  date 需要删除的数据ID
	 * @return 结果
	 */
    List<HzBankOrder> getBankHzOrder(String openId, String qrCode, Date date);

	void insertOrder(HzBankRequestVO hzBankRequestVO);

	List<HzBankOrder> getBankHzOrderByOpenId(String openId, String qrCode);

	void updateOrder(HzBankRequestVO hzBankRequestVO);

	void updateOrderGiveBack(HzBankRequestVO hzBankRequestVO);
}
