package com.ruoyi.web.controller.project;

import java.util.List;

import com.ruoyi.project.domain.HzDockAndBank;
import com.ruoyi.project.service.IHzDockAndBankService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.project.domain.HzPowerBank;
import com.ruoyi.project.service.IHzPowerBankService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 充电宝 信息操作处理
 *
 * @author ruoyi
 * @date 2021-09-16
 */
@Controller
@RequestMapping("/project/hzPowerBank")
public class HzPowerBankController extends BaseController {
    private String prefix = "project/hzPowerBank";

    @Autowired
    private IHzPowerBankService hzPowerBankService;

    @Autowired
    private IHzDockAndBankService hzDockAndBankService;


//    @RequiresPermissions("project:hzPowerBank:view")
    @GetMapping()
    public String hzPowerBank() {
        return prefix + "/hzPowerBank";
    }

    /**
     * 查询充电宝列表
     */
//    @RequiresPermissions("project:hzPowerBank:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HzPowerBank hzPowerBank) {
        startPage();
        List<HzPowerBank> list = hzPowerBankService.selectHzPowerBankList(hzPowerBank);
        return getDataTable(list);
    }


    /**
     * 导出充电宝列表
     */
//    @RequiresPermissions("project:hzPowerBank:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HzPowerBank hzPowerBank) {
        List<HzPowerBank> list = hzPowerBankService.selectHzPowerBankList(hzPowerBank);
        ExcelUtil<HzPowerBank> util = new ExcelUtil<HzPowerBank>(HzPowerBank.class);
        return util.exportExcel(list, "hzPowerBank");
    }

    /**
     * 新增充电宝
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存充电宝
     */
//    @RequiresPermissions("project:hzPowerBank:add")
    @Log(title = "充电宝", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HzPowerBank hzPowerBank) {
        return toAjax(hzPowerBankService.insertHzPowerBank(hzPowerBank));
    }

    /**
     * 修改充电宝
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        HzPowerBank hzPowerBank = hzPowerBankService.selectHzPowerBankById(id);
        mmap.put("hzPowerBank", hzPowerBank);
        return prefix + "/edit";
    }

    /**
     * 修改保存充电宝
     */
//    @RequiresPermissions("project:hzPowerBank:edit")
    @Log(title = "充电宝", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HzPowerBank hzPowerBank) {
        return toAjax(hzPowerBankService.updateHzPowerBank(hzPowerBank));
    }

    /**
     * 删除充电宝
     */
//    @RequiresPermissions("project:hzPowerBank:remove")
    @Log(title = "充电宝", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(hzPowerBankService.deleteHzPowerBankByIds(ids));
    }

    /**
     * 插入充电宝与充电坞的关联关系
     */
    @Log(title = "充电宝", businessType = BusinessType.INSERT)
    @PostMapping("/insertRelation")
    @ResponseBody
    public AjaxResult insertRelation(HzDockAndBank hzDockAndBank) {
        return toAjax(hzDockAndBankService.insertHzDockAndBank(hzDockAndBank));
    }

}
