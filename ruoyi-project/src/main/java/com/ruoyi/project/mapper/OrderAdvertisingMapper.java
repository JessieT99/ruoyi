package com.ruoyi.project.mapper;

import com.ruoyi.project.domain.OrderAdvertising;
import java.util.List;	

/**
 * 广告订单 数据层
 * 
 * @author ruoyi
 * @date 2021-06-25
 */
public interface OrderAdvertisingMapper 
{
	/**
     * 查询广告订单信息
     * 
     * @param id 广告订单ID
     * @return 广告订单信息
     */
	public OrderAdvertising selectOrderAdvertisingById(Long id);
	
	/**
     * 查询广告订单列表
     * 
     * @param orderAdvertising 广告订单信息
     * @return 广告订单集合
     */
	public List<OrderAdvertising> selectOrderAdvertisingList(OrderAdvertising orderAdvertising);
	
	/**
     * 新增广告订单
     * 
     * @param orderAdvertising 广告订单信息
     * @return 结果
     */
	public int insertOrderAdvertising(OrderAdvertising orderAdvertising);
	
	/**
     * 修改广告订单
     * 
     * @param orderAdvertising 广告订单信息
     * @return 结果
     */
	public int updateOrderAdvertising(OrderAdvertising orderAdvertising);
	
	/**
     * 删除广告订单
     * 
     * @param id 广告订单ID
     * @return 结果
     */
	public int deleteOrderAdvertisingById(Long id);
	
	/**
     * 批量删除广告订单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOrderAdvertisingByIds(String[] ids);
	
}