package com.ruoyi.project.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.enums.OrderStatus;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.service.IHzDockAndBankService;
import com.ruoyi.project.vo.HzBankRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.HzBankOrderMapper;
import com.ruoyi.project.domain.HzBankOrder;
import com.ruoyi.project.service.IHzBankOrderService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 充电宝订单 服务层实现
 * 
 * @author ruoyi
 * @date 2021-09-16
 */
@Service
public class HzBankOrderServiceImpl implements IHzBankOrderService 
{
	@Autowired
	private HzBankOrderMapper hzBankOrderMapper;

	@Autowired
	private IHzDockAndBankService hzDockAndBankService;

	/**
     * 查询充电宝订单信息
     * 
     * @param id 充电宝订单ID
     * @return 充电宝订单信息
     */
    @Override
	public HzBankOrder selectHzBankOrderById(Long id)
	{
	    return hzBankOrderMapper.selectHzBankOrderById(id);
	}
	
	/**
     * 查询充电宝订单列表
     * 
     * @param hzBankOrder 充电宝订单信息
     * @return 充电宝订单集合
     */
	@Override
	public List<HzBankOrder> selectHzBankOrderList(HzBankOrder hzBankOrder)
	{
	    return hzBankOrderMapper.selectHzBankOrderList(hzBankOrder);
	}
	
    /**
     * 新增充电宝订单
     * 
     * @param hzBankOrder 充电宝订单信息
     * @return 结果
     */
	@Override
	public int insertHzBankOrder(HzBankOrder hzBankOrder)
	{
	    return hzBankOrderMapper.insertHzBankOrder(hzBankOrder);
	}
	
	/**
     * 修改充电宝订单
     * 
     * @param hzBankOrder 充电宝订单信息
     * @return 结果
     */
	@Override
	public int updateHzBankOrder(HzBankOrder hzBankOrder)
	{
	    return hzBankOrderMapper.updateHzBankOrder(hzBankOrder);
	}

	/**
     * 删除充电宝订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHzBankOrderByIds(String ids)
	{
		return hzBankOrderMapper.deleteHzBankOrderByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<HzBankOrder> getBankHzOrder(String openId, String qrCode, Date date) {
		return hzBankOrderMapper.getBankHzOrder(openId,qrCode,date);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void insertOrder(HzBankRequestVO vo) {
		HzBankOrder hzBankOrder = new HzBankOrder();
		Date date = new Date();
		hzBankOrder.setStartTime(date);
		hzBankOrder.setOrderUser(vo.getOpenId());
		hzBankOrder.setDockId(vo.getQrCode());
		hzBankOrder.setBankId(vo.getBankId());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		hzBankOrder.setOrderCode(vo.getOpenId()+calendar.getTimeInMillis());
		hzBankOrder.setOrderStatus(OrderStatus.HZ_ORDER_GOING.getCode());
		insertHzBankOrder(hzBankOrder);
	}

	@Override
	public List<HzBankOrder> getBankHzOrderByOpenId(String openId, String qrCode) {
		return hzBankOrderMapper.getBankHzOrderByOpenId(openId,qrCode);
	}

	@Override
	public void updateOrder(HzBankRequestVO hzBankRequestVO) {
		HzBankOrder hzBankOrder = selectHzBankOrderById(hzBankRequestVO.getOrderId());
		Date endTime = new Date();
		hzBankOrder.setEndTime(endTime);
		Long datePoorSecond = DateUtils.getDatePoorSecond(endTime, hzBankOrder.getStartTime());
		hzBankOrder.setOrderTime(datePoorSecond);
		hzBankOrder.setOrderStatus(OrderStatus.HZ_ORDER_FINISH.getCode());

		hzDockAndBankService.insertRelation(hzBankOrder.getDockId(),hzBankOrder.getBankId());

	}


}
