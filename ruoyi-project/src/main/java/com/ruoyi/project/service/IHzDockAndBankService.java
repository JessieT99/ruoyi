package com.ruoyi.project.service;

import com.ruoyi.project.domain.HzDockAndBank;
import java.util.List;

/**
 * 充电坞与充电宝关联 服务层
 * 
 * @author ruoyi
 * @date 2021-09-17
 */
public interface IHzDockAndBankService 
{
	/**
     * 查询充电坞与充电宝关联信息
     * 
     * @param id 充电坞与充电宝关联ID
     * @return 充电坞与充电宝关联信息
     */
	public HzDockAndBank selectHzDockAndBankById(Long id);
	
	/**
     * 查询充电坞与充电宝关联列表
     * 
     * @param hzDockAndBank 充电坞与充电宝关联信息
     * @return 充电坞与充电宝关联集合
     */
	public List<HzDockAndBank> selectHzDockAndBankList(HzDockAndBank hzDockAndBank);
	
	/**
     * 新增充电坞与充电宝关联
     * 
     * @param hzDockAndBank 充电坞与充电宝关联信息
     * @return 结果
     */
	public int insertHzDockAndBank(HzDockAndBank hzDockAndBank);
	
	/**
     * 修改充电坞与充电宝关联
     * 
     * @param hzDockAndBank 充电坞与充电宝关联信息
     * @return 结果
     */
	public int updateHzDockAndBank(HzDockAndBank hzDockAndBank);
		
	/**
     * 删除充电坞与充电宝关联信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHzDockAndBankByIds(String ids);

	/**
	 * 查询充电坞是否存在充电宝
	 * @param qrCode
	 * @return
	 */
	Integer getExistBank(String qrCode);

	/**
	 * 查询充电坞是否存在充电宝
	 * @param bankId
	 * @param dockId
	 * @return
	 */
	void removeRelation(String bankId, String dockId);

    void insertRelation(String dockId, String bankId);
}
