package com.ruoyi.project.mapper;

import com.ruoyi.project.domain.HzOrderAdvertising;
import java.util.List;	

/**
 * 广告订单 数据层
 * 
 * @author ruoyi
 * @date 2021-06-25
 */
public interface HzOrderAdvertisingMapper
{
	/**
     * 查询广告订单信息
     * 
     * @param id 广告订单ID
     * @return 广告订单信息
     */
	public HzOrderAdvertising selectHzOrderAdvertisingById(Long id);
	
	/**
     * 查询广告订单列表
     * 
     * @param hzOrderAdvertising 广告订单信息
     * @return 广告订单集合
     */
	public List<HzOrderAdvertising> selectHzOrderAdvertisingList(HzOrderAdvertising hzOrderAdvertising);
	
	/**
     * 新增广告订单
     * 
     * @param hzOrderAdvertising 广告订单信息
     * @return 结果
     */
	public int insertHzOrderAdvertising(HzOrderAdvertising hzOrderAdvertising);
	
	/**
     * 修改广告订单
     * 
     * @param hzOrderAdvertising 广告订单信息
     * @return 结果
     */
	public int updateHzOrderAdvertising(HzOrderAdvertising hzOrderAdvertising);
	
	/**
     * 删除广告订单
     * 
     * @param id 广告订单ID
     * @return 结果
     */
	public int deleteHzOrderAdvertisingById(Long id);
	
	/**
     * 批量删除广告订单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHzOrderAdvertisingByIds(String[] ids);
	
}