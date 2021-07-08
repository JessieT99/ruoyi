package com.ruoyi.project.service;

import com.ruoyi.project.domain.HzMqttReceiveLog;
import java.util.List;

/**
 * mqtt接收记录 服务层
 * 
 * @author ruoyi
 * @date 2021-07-08
 */
public interface IHzMqttReceiveLogService 
{
	/**
     * 查询mqtt接收记录信息
     * 
     * @param id mqtt接收记录ID
     * @return mqtt接收记录信息
     */
	public HzMqttReceiveLog selectHzMqttReceiveLogById(Long id);
	
	/**
     * 查询mqtt接收记录列表
     * 
     * @param hzMqttReceiveLog mqtt接收记录信息
     * @return mqtt接收记录集合
     */
	public List<HzMqttReceiveLog> selectHzMqttReceiveLogList(HzMqttReceiveLog hzMqttReceiveLog);
	
	/**
     * 新增mqtt接收记录
     * 
     * @param hzMqttReceiveLog mqtt接收记录信息
     * @return 结果
     */
	public int insertHzMqttReceiveLog(HzMqttReceiveLog hzMqttReceiveLog);
	
	/**
     * 修改mqtt接收记录
     * 
     * @param hzMqttReceiveLog mqtt接收记录信息
     * @return 结果
     */
	public int updateHzMqttReceiveLog(HzMqttReceiveLog hzMqttReceiveLog);
		
	/**
     * 删除mqtt接收记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHzMqttReceiveLogByIds(String ids);
	
}
