package com.ruoyi.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.HzPowerBankMapper;
import com.ruoyi.project.domain.HzPowerBank;
import com.ruoyi.project.service.IHzPowerBankService;
import com.ruoyi.common.core.text.Convert;

/**
 * 充电宝 服务层实现
 * 
 * @author ruoyi
 * @date 2021-09-16
 */
@Service
public class HzPowerBankServiceImpl implements IHzPowerBankService 
{
	@Autowired
	private HzPowerBankMapper hzPowerBankMapper;

	/**
     * 查询充电宝信息
     * 
     * @param id 充电宝ID
     * @return 充电宝信息
     */
    @Override
	public HzPowerBank selectHzPowerBankById(Long id)
	{
	    return hzPowerBankMapper.selectHzPowerBankById(id);
	}
	
	/**
     * 查询充电宝列表
     * 
     * @param hzPowerBank 充电宝信息
     * @return 充电宝集合
     */
	@Override
	public List<HzPowerBank> selectHzPowerBankList(HzPowerBank hzPowerBank)
	{
	    return hzPowerBankMapper.selectHzPowerBankList(hzPowerBank);
	}
	
    /**
     * 新增充电宝
     * 
     * @param hzPowerBank 充电宝信息
     * @return 结果
     */
	@Override
	public Long insertHzPowerBank(HzPowerBank hzPowerBank)
	{
		int i = hzPowerBankMapper.insertHzPowerBank(hzPowerBank);
		System.out.println(hzPowerBank.toString());
		return hzPowerBank.getId();
	}
	
	/**
     * 修改充电宝
     * 
     * @param hzPowerBank 充电宝信息
     * @return 结果
     */
	@Override
	public int updateHzPowerBank(HzPowerBank hzPowerBank)
	{
	    return hzPowerBankMapper.updateHzPowerBank(hzPowerBank);
	}

	/**
     * 删除充电宝对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHzPowerBankByIds(String ids)
	{
		return hzPowerBankMapper.deleteHzPowerBankByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<HzPowerBank> getBankByCode(String qrCode) {
		return hzPowerBankMapper.getBankByCode(qrCode);
	}

	@Override
	public Long getBankIdByCode(String code) {
		return hzPowerBankMapper.getBankIdByCode(code);
	}

}
