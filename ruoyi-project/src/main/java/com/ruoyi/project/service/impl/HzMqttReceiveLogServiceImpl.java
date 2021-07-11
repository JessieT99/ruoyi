package com.ruoyi.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.HzMqttReceiveLogMapper;
import com.ruoyi.project.domain.HzMqttReceiveLog;
import com.ruoyi.project.service.IHzMqttReceiveLogService;
import com.ruoyi.common.core.text.Convert;

/**
 * mqtt接收记录 服务层实现
 * 
 * @author ruoyi
 * @date 2021-07-08
 */
@Service
public class HzMqttReceiveLogServiceImpl implements IHzMqttReceiveLogService 
{
	@Autowired
	private HzMqttReceiveLogMapper hzMqttReceiveLogMapper;

	/**
     * 查询mqtt接收记录信息
     * 
     * @param id mqtt接收记录ID
     * @return mqtt接收记录信息
     */
    @Override
	public HzMqttReceiveLog selectHzMqttReceiveLogById(Long id)
	{
	    return hzMqttReceiveLogMapper.selectHzMqttReceiveLogById(id);
	}
	
	/**
     * 查询mqtt接收记录列表
     * 
     * @param hzMqttReceiveLog mqtt接收记录信息
     * @return mqtt接收记录集合
     */
	@Override
	public List<HzMqttReceiveLog> selectHzMqttReceiveLogList(HzMqttReceiveLog hzMqttReceiveLog)
	{
	    return hzMqttReceiveLogMapper.selectHzMqttReceiveLogList(hzMqttReceiveLog);
	}
	
    /**
     * 新增mqtt接收记录
     * 
     * @param hzMqttReceiveLog mqtt接收记录信息
     * @return 结果
     */
	@Override
	public int insertHzMqttReceiveLog(HzMqttReceiveLog hzMqttReceiveLog)
	{
	    return hzMqttReceiveLogMapper.insertHzMqttReceiveLog(hzMqttReceiveLog);
	}
	
	/**
     * 修改mqtt接收记录
     * 
     * @param hzMqttReceiveLog mqtt接收记录信息
     * @return 结果
     */
	@Override
	public int updateHzMqttReceiveLog(HzMqttReceiveLog hzMqttReceiveLog)
	{
	    return hzMqttReceiveLogMapper.updateHzMqttReceiveLog(hzMqttReceiveLog);
	}

	/**
     * 删除mqtt接收记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHzMqttReceiveLogByIds(String ids)
	{
		return hzMqttReceiveLogMapper.deleteHzMqttReceiveLogByIds(Convert.toStrArray(ids));
	}
	
}
