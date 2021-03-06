package com.ruoyi.project.service.impl;

import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.service.IHzChargeDockService;
import com.ruoyi.project.service.IHzPowerBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.HzDockAndBankMapper;
import com.ruoyi.project.domain.HzDockAndBank;
import com.ruoyi.project.service.IHzDockAndBankService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 充电坞与充电宝关联 服务层实现
 *
 * @author ruoyi
 * @date 2021-09-17
 */
@Service
public class HzDockAndBankServiceImpl implements IHzDockAndBankService {
    @Autowired
    private HzDockAndBankMapper hzDockAndBankMapper;

    @Autowired
    private IHzChargeDockService hzChargeDockService;

    @Autowired
    private IHzPowerBankService hzPowerBankService;


    /**
     * 查询充电坞与充电宝关联信息
     *
     * @param id 充电坞与充电宝关联ID
     * @return 充电坞与充电宝关联信息
     */
    @Override
    public HzDockAndBank selectHzDockAndBankById(Long id) {
        return hzDockAndBankMapper.selectHzDockAndBankById(id);
    }

    /**
     * 查询充电坞与充电宝关联列表
     *
     * @param hzDockAndBank 充电坞与充电宝关联信息
     * @return 充电坞与充电宝关联集合
     */
    @Override
    public List<HzDockAndBank> selectHzDockAndBankList(HzDockAndBank hzDockAndBank) {
        return hzDockAndBankMapper.selectHzDockAndBankList(hzDockAndBank);
    }

    /**
     * 新增充电坞与充电宝关联
     *
     * @param hzDockAndBank 充电坞与充电宝关联信息
     * @return 结果
     */
    @Override
    public int insertHzDockAndBank(HzDockAndBank hzDockAndBank) {
        return hzDockAndBankMapper.insertHzDockAndBank(hzDockAndBank);
    }

    /**
     * 修改充电坞与充电宝关联
     *
     * @param hzDockAndBank 充电坞与充电宝关联信息
     * @return 结果
     */
    @Override
    public int updateHzDockAndBank(HzDockAndBank hzDockAndBank) {
        return hzDockAndBankMapper.updateHzDockAndBank(hzDockAndBank);
    }

    /**
     * 删除充电坞与充电宝关联对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHzDockAndBankByIds(String ids) {
        return hzDockAndBankMapper.deleteHzDockAndBankByIds(Convert.toStrArray(ids));
    }

    @Override
    public Integer getExistBank(String qrCode) {
        return hzDockAndBankMapper.getExistBank(qrCode);
    }

    @Override
    public void removeRelation(String bankId, String dockId) {
        if (StringUtils.isEmpty(bankId) || StringUtils.isEmpty(dockId)) {
            return;
        }
        Long dId = hzChargeDockService.getDockIdByUniqueCode(dockId);
        Long bId = hzPowerBankService.getBankIdByCode(bankId);
        hzDockAndBankMapper.removeRelation(dId, bId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertRelation(String dockId, String bankId) {
        Long dId = hzChargeDockService.getDockIdByUniqueCode(dockId);
        Long bId = hzPowerBankService.getBankIdByCode(bankId);
        HzDockAndBank hzDockAndBank = new HzDockAndBank();
        hzDockAndBank.setBankId(bId);
        hzDockAndBank.setDockId(dId);
        insertHzDockAndBank(hzDockAndBank);
    }

}
