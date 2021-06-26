package com.ruoyi.project.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.OrderAdvertisingMapper;
import com.ruoyi.project.domain.OrderAdvertising;
import com.ruoyi.project.service.IOrderAdvertisingService;
import com.ruoyi.common.core.text.Convert;

/**
 * 广告订单 服务层实现
 * 
 * @author ruoyi
 * @date 2021-06-25
 */
@Service
public class OrderAdvertisingServiceImpl implements IOrderAdvertisingService 
{
	@Autowired
	private OrderAdvertisingMapper orderAdvertisingMapper;

	/**
     * 查询广告订单信息
     * 
     * @param id 广告订单ID
     * @return 广告订单信息
     */
    @Override
	public OrderAdvertising selectOrderAdvertisingById(Long id)
	{
	    return orderAdvertisingMapper.selectOrderAdvertisingById(id);
	}
	
	/**
     * 查询广告订单列表
     * 
     * @param orderAdvertising 广告订单信息
     * @return 广告订单集合
     */
	@Override
	public List<OrderAdvertising> selectOrderAdvertisingList(OrderAdvertising orderAdvertising)
	{
	    return orderAdvertisingMapper.selectOrderAdvertisingList(orderAdvertising);
	}
	
    /**
     * 新增广告订单
     * 
     * @param orderAdvertising 广告订单信息
     * @return 结果
     */
	@Override
	public int insertOrderAdvertising(OrderAdvertising orderAdvertising)
	{
	    return orderAdvertisingMapper.insertOrderAdvertising(orderAdvertising);
	}
	
	/**
     * 修改广告订单
     * 
     * @param orderAdvertising 广告订单信息
     * @return 结果
     */
	@Override
	public int updateOrderAdvertising(OrderAdvertising orderAdvertising)
	{
	    return orderAdvertisingMapper.updateOrderAdvertising(orderAdvertising);
	}

	/**
     * 删除广告订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteOrderAdvertisingByIds(String ids)
	{
		return orderAdvertisingMapper.deleteOrderAdvertisingByIds(Convert.toStrArray(ids));
	}

	@Override
	public int submitOrder(OrderAdvertising orderAdvertising) {
		//订单编号
		String code= System.currentTimeMillis()+"000"+(orderAdvertising.getUserId()==null?1:orderAdvertising.getUserId());
		orderAdvertising.setOrderCode(code);
		orderAdvertising.setOrderTime(new Date());
		return orderAdvertisingMapper.insertOrderAdvertising(orderAdvertising);
	}

}
