package com.ruoyi.web.controller.project;

import java.util.List;
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
import com.ruoyi.project.domain.HzBankOrder;
import com.ruoyi.project.service.IHzBankOrderService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 充电宝订单 信息操作处理
 * 
 * @author ruoyi
 * @date 2021-09-16
 */
@Controller
@RequestMapping("/project/hzBankOrder")
public class HzBankOrderController extends BaseController
{
    private String prefix = "project/hzBankOrder";
	
	@Autowired
	private IHzBankOrderService hzBankOrderService;
	
//	@RequiresPermissions("project:hzBankOrder:view")
	@GetMapping()
	public String hzBankOrder()
	{
	    return prefix + "/hzBankOrder";
	}
	
	/**
	 * 查询充电宝订单列表
	 */
//	@RequiresPermissions("project:hzBankOrder:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HzBankOrder hzBankOrder)
	{
		startPage();
        List<HzBankOrder> list = hzBankOrderService.selectHzBankOrderList(hzBankOrder);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出充电宝订单列表
	 */
//	@RequiresPermissions("project:hzBankOrder:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HzBankOrder hzBankOrder)
    {
    	List<HzBankOrder> list = hzBankOrderService.selectHzBankOrderList(hzBankOrder);
        ExcelUtil<HzBankOrder> util = new ExcelUtil<HzBankOrder>(HzBankOrder.class);
        return util.exportExcel(list, "hzBankOrder");
    }
	
	/**
	 * 新增充电宝订单
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存充电宝订单
	 */
//	@RequiresPermissions("project:hzBankOrder:add")
	@Log(title = "充电宝订单", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HzBankOrder hzBankOrder)
	{		
		return toAjax(hzBankOrderService.insertHzBankOrder(hzBankOrder));
	}

	/**
	 * 修改充电宝订单
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		HzBankOrder hzBankOrder = hzBankOrderService.selectHzBankOrderById(id);
		mmap.put("hzBankOrder", hzBankOrder);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存充电宝订单
	 */
//	@RequiresPermissions("project:hzBankOrder:edit")
	@Log(title = "充电宝订单", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HzBankOrder hzBankOrder)
	{		
		return toAjax(hzBankOrderService.updateHzBankOrder(hzBankOrder));
	}
	
	/**
	 * 删除充电宝订单
	 */
//	@RequiresPermissions("project:hzBankOrder:remove")
	@Log(title = "充电宝订单", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(hzBankOrderService.deleteHzBankOrderByIds(ids));
	}
	
}
