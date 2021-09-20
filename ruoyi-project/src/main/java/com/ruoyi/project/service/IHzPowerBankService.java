package com.ruoyi.project.service;

import com.ruoyi.project.domain.HzPowerBank;
import java.util.List;

/**
 * 充电宝 服务层
 * 
 * @author ruoyi
 * @date 2021-09-16
 */
public interface IHzPowerBankService 
{
	/**
     * 查询充电宝信息
     * 
     * @param id 充电宝ID
     * @return 充电宝信息
     */
	public HzPowerBank selectHzPowerBankById(Long id);
	
	/**
     * 查询充电宝列表
     * 
     * @param hzPowerBank 充电宝信息
     * @return 充电宝集合
     */
	public List<HzPowerBank> selectHzPowerBankList(HzPowerBank hzPowerBank);
	
	/**
     * 新增充电宝
     * 
     * @param hzPowerBank 充电宝信息
     * @return 结果
     */
	public int insertHzPowerBank(HzPowerBank hzPowerBank);
	
	/**
     * 修改充电宝
     * 
     * @param hzPowerBank 充电宝信息
     * @return 结果
     */
	public int updateHzPowerBank(HzPowerBank hzPowerBank);
		
	/**
     * 删除充电宝信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHzPowerBankByIds(String ids);

    List<HzPowerBank> getBankByCode(String qrCode);
}
