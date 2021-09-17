package com.ruoyi.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.HzDockAndBankMapper;
import com.ruoyi.project.domain.HzDockAndBank;
import com.ruoyi.project.service.IHzDockAndBankService;
import com.ruoyi.common.core.text.Convert;

/**
 * 充电坞与充电宝关联 服务层实现
 * 
 * @author ruoyi
 * @date 2021-09-17
 */
@Service
public class HzDockAndBankServiceImpl implements IHzDockAndBankService 
{
	@Autowired
	private HzDockAndBankMapper hzDockAndBankMapper;

	/**
     * 查询充电坞与充电宝关联信息
     * 
     * @param id 充电坞与充电宝关联ID
     * @return 充电坞与充电宝关联信息
     */
    @Override
	public HzDockAndBank selectHzDockAndBankById(Long id)
	{
	    return hzDockAndBankMapper.selectHzDockAndBankById(id);
	}
	
	/**
     * 查询充电坞与充电宝关联列表
     * 
     * @param hzDockAndBank 充电坞与充电宝关联信息
     * @return 充电坞与充电宝关联集合
     */
	@Override
	public List<HzDockAndBank> selectHzDockAndBankList(HzDockAndBank hzDockAndBank)
	{
	    return hzDockAndBankMapper.selectHzDockAndBankList(hzDockAndBank);
	}
	
    /**
     * 新增充电坞与充电宝关联
     * 
     * @param hzDockAndBank 充电坞与充电宝关联信息
     * @return 结果
     */
	@Override
	public int insertHzDockAndBank(HzDockAndBank hzDockAndBank)
	{
	    return hzDockAndBankMapper.insertHzDockAndBank(hzDockAndBank);
	}
	
	/**
     * 修改充电坞与充电宝关联
     * 
     * @param hzDockAndBank 充电坞与充电宝关联信息
     * @return 结果
     */
	@Override
	public int updateHzDockAndBank(HzDockAndBank hzDockAndBank)
	{
	    return hzDockAndBankMapper.updateHzDockAndBank(hzDockAndBank);
	}

	/**
     * 删除充电坞与充电宝关联对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHzDockAndBankByIds(String ids)
	{
		return hzDockAndBankMapper.deleteHzDockAndBankByIds(Convert.toStrArray(ids));
	}
	
}
