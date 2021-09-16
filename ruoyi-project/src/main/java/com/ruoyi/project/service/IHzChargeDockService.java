package com.ruoyi.project.service;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.project.domain.HzChargeDock;
import java.util.List;

/**
 * 充电坞 服务层
 * 
 * @author ruoyi
 * @date 2021-09-16
 */
public interface IHzChargeDockService 
{
	/**
     * 查询充电坞信息
     * 
     * @param id 充电坞ID
     * @return 充电坞信息
     */
	public HzChargeDock selectHzChargeDockById(Long id);
	
	/**
     * 查询充电坞列表
     * 
     * @param hzChargeDock 充电坞信息
     * @return 充电坞集合
     */
	public List<HzChargeDock> selectHzChargeDockList(HzChargeDock hzChargeDock);
	
	/**
     * 新增充电坞
     * 
     * @param hzChargeDock 充电坞信息
     * @return 结果
     */
	public int insertHzChargeDock(HzChargeDock hzChargeDock);
	
	/**
     * 修改充电坞
     * 
     * @param hzChargeDock 充电坞信息
     * @return 结果
     */
	public int updateHzChargeDock(HzChargeDock hzChargeDock);
		
	/**
     * 删除充电坞信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHzChargeDockByIds(String ids);

	/**
	 * 扫描充电坞二维码
	 *
	 * @param params openId，dockCode
	 * @return 结果
	 */
	void scanCode(JSONObject params);
}
