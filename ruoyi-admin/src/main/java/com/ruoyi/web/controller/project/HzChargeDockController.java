package com.ruoyi.web.controller.project;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.project.domain.HzChargeDock;
import com.ruoyi.project.service.IHzChargeDockService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 充电坞 信息操作处理
 * 
 * @author ruoyi
 * @date 2021-09-16
 */
@Controller
@RequestMapping("/project/hzChargeDock")
public class HzChargeDockController extends BaseController
{
    private String prefix = "system/hzChargeDock";
	
	@Autowired
	private IHzChargeDockService hzChargeDockService;
	
	@RequiresPermissions("project:hzChargeDock:view")
	@GetMapping()
	public String hzChargeDock()
	{
	    return prefix + "/hzChargeDock";
	}
	
	/**
	 * 查询充电坞列表
	 */
	@RequiresPermissions("project:hzChargeDock:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HzChargeDock hzChargeDock)
	{
		startPage();
        List<HzChargeDock> list = hzChargeDockService.selectHzChargeDockList(hzChargeDock);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出充电坞列表
	 */
	@RequiresPermissions("project:hzChargeDock:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HzChargeDock hzChargeDock)
    {
    	List<HzChargeDock> list = hzChargeDockService.selectHzChargeDockList(hzChargeDock);
        ExcelUtil<HzChargeDock> util = new ExcelUtil<HzChargeDock>(HzChargeDock.class);
        return util.exportExcel(list, "hzChargeDock");
    }
	
	/**
	 * 新增充电坞
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存充电坞
	 */
	@RequiresPermissions("project:hzChargeDock:add")
	@Log(title = "充电坞", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(@RequestBody HzChargeDock hzChargeDock)
	{		
		return toAjax(hzChargeDockService.insertHzChargeDock(hzChargeDock));
	}

	/**
	 * 修改充电坞
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		HzChargeDock hzChargeDock = hzChargeDockService.selectHzChargeDockById(id);
		mmap.put("hzChargeDock", hzChargeDock);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存充电坞
	 */
	@RequiresPermissions("project:hzChargeDock:edit")
	@Log(title = "充电坞", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HzChargeDock hzChargeDock)
	{		
		return toAjax(hzChargeDockService.updateHzChargeDock(hzChargeDock));
	}
	
	/**
	 * 删除充电坞
	 */
	@RequiresPermissions("project:hzChargeDock:remove")
	@Log(title = "充电坞", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(hzChargeDockService.deleteHzChargeDockByIds(ids));
	}
	
}
