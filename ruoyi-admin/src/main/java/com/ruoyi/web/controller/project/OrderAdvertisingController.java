package com.ruoyi.web.controller.project;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.project.domain.HzOrderAdvertising;
import com.ruoyi.project.service.IHzOrderAdvertisingService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 广告订单 信息操作处理
 * 
 * @author ruoyi
 * @date 2021-06-25
 */
@Controller
@RequestMapping("/porject/orderAdvertising")
public class OrderAdvertisingController extends BaseController
{
    private String prefix = "system/orderAdvertising";
	
	@Autowired
	private IHzOrderAdvertisingService orderAdvertisingService;
	
//	@RequiresPermissions("system:orderAdvertising:view")
	@GetMapping()
	public String orderAdvertising()
	{
	    return prefix + "/orderAdvertising";
	}
	
	/**
	 * 查询广告订单列表
	 */
//	@RequiresPermissions("system:orderAdvertising:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HzOrderAdvertising orderAdvertising)
	{
		startPage();
        List<HzOrderAdvertising> list = orderAdvertisingService.selectOrderAdvertisingList(orderAdvertising);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出广告订单列表
	 */
//	@RequiresPermissions("system:orderAdvertising:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HzOrderAdvertising orderAdvertising)
    {
    	List<HzOrderAdvertising> list = orderAdvertisingService.selectOrderAdvertisingList(orderAdvertising);
        ExcelUtil<HzOrderAdvertising> util = new ExcelUtil<HzOrderAdvertising>(HzOrderAdvertising.class);
        return util.exportExcel(list, "orderAdvertising");
    }
	
	/**
	 * 新增广告订单
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存广告订单
	 */
//	@RequiresPermissions("system:orderAdvertising:add")
	@Log(title = "广告订单", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(@RequestBody HzOrderAdvertising orderAdvertising)
	{		
		return toAjax(orderAdvertisingService.insertOrderAdvertising(orderAdvertising));
	}

	/**
	 * 新增保存广告订单
	 */
	@Log(title = "广告订单", businessType = BusinessType.INSERT)
	@PostMapping("/submitOrder")
	@ResponseBody
	public AjaxResult submitOrder(@RequestBody HzOrderAdvertising orderAdvertising)
	{
		return toAjax(orderAdvertisingService.submitOrder(orderAdvertising));
	}

	/**
	 * 修改广告订单
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		HzOrderAdvertising orderAdvertising = orderAdvertisingService.selectOrderAdvertisingById(id);
		mmap.put("orderAdvertising", orderAdvertising);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存广告订单
	 */
//	@RequiresPermissions("system:orderAdvertising:edit")
	@Log(title = "广告订单", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HzOrderAdvertising orderAdvertising)
	{		
		return toAjax(orderAdvertisingService.updateOrderAdvertising(orderAdvertising));
	}
	
	/**
	 * 删除广告订单
	 */
//	@RequiresPermissions("system:orderAdvertising:remove")
	@Log(title = "广告订单", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(orderAdvertisingService.deleteOrderAdvertisingByIds(ids));
	}
	
}
