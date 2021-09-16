package com.ruoyi.project.service.impl;

import java.util.List;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.HzChargeDockMapper;
import com.ruoyi.project.domain.HzChargeDock;
import com.ruoyi.project.service.IHzChargeDockService;
import com.ruoyi.common.core.text.Convert;

/**
 * 充电坞 服务层实现
 * 
 * @author ruoyi
 * @date 2021-09-16
 */
@Service
public class HzChargeDockServiceImpl implements IHzChargeDockService 
{
	@Autowired
	private HzChargeDockMapper hzChargeDockMapper;

	/**
     * 查询充电坞信息
     * 
     * @param id 充电坞ID
     * @return 充电坞信息
     */
    @Override
	public HzChargeDock selectHzChargeDockById(Long id)
	{
	    return hzChargeDockMapper.selectHzChargeDockById(id);
	}
	
	/**
     * 查询充电坞列表
     * 
     * @param hzChargeDock 充电坞信息
     * @return 充电坞集合
     */
	@Override
	public List<HzChargeDock> selectHzChargeDockList(HzChargeDock hzChargeDock)
	{
	    return hzChargeDockMapper.selectHzChargeDockList(hzChargeDock);
	}
	
    /**
     * 新增充电坞
     * 
     * @param hzChargeDock 充电坞信息
     * @return 结果
     */
	@Override
	public int insertHzChargeDock(HzChargeDock hzChargeDock)
	{
		String code = "hz-"+ UUID.randomUUID().toString();
		hzChargeDock.setCodeUnique(code);
	    return hzChargeDockMapper.insertHzChargeDock(hzChargeDock);
	}
	
	/**
     * 修改充电坞
     * 
     * @param hzChargeDock 充电坞信息
     * @return 结果
     */
	@Override
	public int updateHzChargeDock(HzChargeDock hzChargeDock)
	{
	    return hzChargeDockMapper.updateHzChargeDock(hzChargeDock);
	}

	/**
     * 删除充电坞对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHzChargeDockByIds(String ids)
	{
		return hzChargeDockMapper.deleteHzChargeDockByIds(Convert.toStrArray(ids));
	}

	@Override
	public void scanCode(JSONObject params) {
		//
	}

}