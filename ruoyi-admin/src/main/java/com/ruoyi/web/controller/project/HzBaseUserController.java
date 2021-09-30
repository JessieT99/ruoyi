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
import com.ruoyi.project.domain.HzBaseUser;
import com.ruoyi.project.service.IHzBaseUserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 用户 信息操作处理
 * 
 * @author ruoyi
 * @date 2021-09-21
 */
@Controller
@RequestMapping("/system/hzBaseUser")
public class HzBaseUserController extends BaseController
{
    private String prefix = "system/hzBaseUser";
	
	@Autowired
	private IHzBaseUserService hzBaseUserService;
	
//	@RequiresPermissions("system:hzBaseUser:view")
	@GetMapping()
	public String hzBaseUser()
	{
	    return prefix + "/hzBaseUser";
	}
	
	/**
	 * 查询用户列表
	 */
//	@RequiresPermissions("system:hzBaseUser:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HzBaseUser hzBaseUser)
	{
		startPage();
        List<HzBaseUser> list = hzBaseUserService.selectHzBaseUserList(hzBaseUser);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户列表
	 */
//	@RequiresPermissions("system:hzBaseUser:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HzBaseUser hzBaseUser)
    {
    	List<HzBaseUser> list = hzBaseUserService.selectHzBaseUserList(hzBaseUser);
        ExcelUtil<HzBaseUser> util = new ExcelUtil<HzBaseUser>(HzBaseUser.class);
        return util.exportExcel(list, "hzBaseUser");
    }
	
	/**
	 * 新增用户
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户
	 */
//	@RequiresPermissions("system:hzBaseUser:add")
	@Log(title = "用户", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HzBaseUser hzBaseUser)
	{		
		return toAjax(hzBaseUserService.insertHzBaseUser(hzBaseUser));
	}

	/**
	 * 修改用户
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		HzBaseUser hzBaseUser = hzBaseUserService.selectHzBaseUserById(id);
		mmap.put("hzBaseUser", hzBaseUser);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户
	 */
//	@RequiresPermissions("system:hzBaseUser:edit")
	@Log(title = "用户", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HzBaseUser hzBaseUser)
	{		
		return toAjax(hzBaseUserService.updateHzBaseUser(hzBaseUser));
	}
	
	/**
	 * 删除用户
	 */
//	@RequiresPermissions("system:hzBaseUser:remove")
	@Log(title = "用户", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(hzBaseUserService.deleteHzBaseUserByIds(ids));
	}
	
}
