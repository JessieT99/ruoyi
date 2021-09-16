package com.ruoyi.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.HzBankOrderMapper;
import com.ruoyi.project.domain.HzBankOrder;
import com.ruoyi.project.service.IHzBankOrderService;
import com.ruoyi.common.core.text.Convert;

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
	
}
