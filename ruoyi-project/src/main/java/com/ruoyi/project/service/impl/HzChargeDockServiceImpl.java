package com.ruoyi.project.service.impl;

import java.util.*;
import java.util.concurrent.TimeUnit;

import com.ruoyi.common.enums.MqttStatus;
import com.ruoyi.common.enums.MqttType;
import com.ruoyi.common.enums.OrderStatus;
import com.ruoyi.common.enums.ServiceType;
import com.ruoyi.common.exception.RRException;
import com.ruoyi.common.exception.base.BaseException;
import com.ruoyi.project.config.CoreBaseDataLoaderMqttClient;
import com.ruoyi.project.domain.HzBankOrder;
import com.ruoyi.project.domain.HzPowerBank;
import com.ruoyi.project.mqtt.util.MqttPublishUtil;
import com.ruoyi.project.mqtt.util.MqttPushClientNew;
import com.ruoyi.project.service.IHzBankOrderService;
import com.ruoyi.project.service.IHzDockAndBankService;
import com.ruoyi.project.service.IHzPowerBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.HzChargeDockMapper;
import com.ruoyi.project.domain.HzChargeDock;
import com.ruoyi.project.service.IHzChargeDockService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.util.CollectionUtils;

/**
 * 充电坞 服务层实现
 *
 * @author ruoyi
 * @date 2021-09-16
 */
@Service
public class HzChargeDockServiceImpl implements IHzChargeDockService {
    @Autowired
    private HzChargeDockMapper hzChargeDockMapper;

    @Autowired
    private IHzDockAndBankService hzDockAndBankService;

    @Autowired
    private IHzPowerBankService hzPowerBankService;

    @Autowired
    private IHzBankOrderService hzBankOrderService;

    @Autowired
    private MqttPublishUtil mqttPublishUtil;


    /**
     * 查询充电坞信息
     *
     * @param id 充电坞ID
     * @return 充电坞信息
     */
    @Override
    public HzChargeDock selectHzChargeDockById(Long id) {
        return hzChargeDockMapper.selectHzChargeDockById(id);
    }

    /**
     * 查询充电坞列表
     *
     * @param hzChargeDock 充电坞信息
     * @return 充电坞集合
     */
    @Override
    public List<HzChargeDock> selectHzChargeDockList(HzChargeDock hzChargeDock) {
        return hzChargeDockMapper.selectHzChargeDockList(hzChargeDock);
    }

    /**
     * 新增充电坞
     *
     * @param hzChargeDock 充电坞信息
     * @return 结果
     */
    @Override
    public int insertHzChargeDock(HzChargeDock hzChargeDock) {
        String code = "hz-" + UUID.randomUUID().toString();
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
    public int updateHzChargeDock(HzChargeDock hzChargeDock) {
        return hzChargeDockMapper.updateHzChargeDock(hzChargeDock);
    }

    /**
     * 删除充电坞对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHzChargeDockByIds(String ids) {
        return hzChargeDockMapper.deleteHzChargeDockByIds(Convert.toStrArray(ids));
    }

    @Override
    public HzBankOrder rentBank(String openId, String qrCode) throws InterruptedException {
        Integer num = hzDockAndBankService.getExistBank(qrCode);
        if (num < 1) {
            new RRException("充电坞没有可用充电宝！");
            new BaseException("project", "004", null, "充电坞没有可用充电宝！");
            new RuntimeException("充电坞没有可用充电宝！");
            return null;
        }
        List<HzPowerBank> bankList = hzPowerBankService.getBankByCode(qrCode);
        Date date = new Date();
        Map<String, Object> data = new HashMap<>();
        data.put("type", MqttType.HZ_BANK_INFO.getCode());
        data.put("service", ServiceType.HZ_SERVICE_SERVER.getCode());
        data.put("status", MqttStatus.HZ_BANK_SUCCESS.getCode());
        data.put("openId", openId);
        data.put("qrCode", qrCode);
        data.put("bankList", bankList);
        mqttPublishUtil.publish(qrCode, data);
        HzBankOrder hzBankOrder = null;
        int count = 4;
        while (count > 0) {
            TimeUnit.SECONDS.sleep(5);
            List<HzBankOrder> hzBankOrderList = hzBankOrderService.getBankHzOrder(openId, qrCode, date);
            if (!CollectionUtils.isEmpty(hzBankOrderList)) {
                hzBankOrder = hzBankOrderList.get(0);
                count = 0;
                hzDockAndBankService.removeRelation(hzBankOrder.getBankId(), hzBankOrder.getDockId());
            }
            count--;
        }
        return hzBankOrder;
    }

    @Override
    public List<HzChargeDock> getDockList() {
        return hzChargeDockMapper.getDockList();
    }

    @Override
    public Long getDockIdByUniqueCode(String code) {
        return hzChargeDockMapper.getDockIdByUniqueCode(code);
    }

    @Override
    public HzBankOrder returnBank(String openId, String qrCode) throws InterruptedException {
        List<HzBankOrder> hzBankOrderList = hzBankOrderService.getBankHzOrderByOpenId(openId, qrCode);
        if (CollectionUtils.isEmpty(hzBankOrderList)) {
            new BaseException("project", "004", null, "未查询到订单，归还充电宝异常！");
        }
        HzBankOrder hzBankOrder = hzBankOrderList.get(0);
        Map<String, Object> data = new HashMap<>();
        data.put("type", MqttType.HZ_BANK_RETURN.getCode());
        data.put("service", ServiceType.HZ_SERVICE_SERVER.getCode());
        data.put("status", MqttStatus.HZ_BANK_SUCCESS.getCode());
        data.put("openId", openId);
        data.put("qrCode", qrCode);
        data.put("bankId", hzBankOrder.getBankId());
        data.put("orderId", hzBankOrder.getId());
        mqttPublishUtil.publish(qrCode, data);
        HzBankOrder order = null;
        int count = 4;
        while (count > 0) {
            TimeUnit.SECONDS.sleep(3);
            hzBankOrder = hzBankOrderService.selectHzBankOrderById(hzBankOrder.getId());
            if (hzBankOrder.getOrderStatus() == OrderStatus.HZ_ORDER_FINISH.getCode()) {
                order = hzBankOrder;
                count = 0;
            }
            count--;
        }

        return order;
    }

}
