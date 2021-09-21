package com.ruoyi.project.mapper;

import com.ruoyi.project.domain.HzBaseUser;
import java.util.List;	

/**
 * 用户 数据层
 * 
 * @author ruoyi
 * @date 2021-09-21
 */
public interface HzBaseUserMapper 
{
	/**
     * 查询用户信息
     * 
     * @param id 用户ID
     * @return 用户信息
     */
	public HzBaseUser selectHzBaseUserById(Long id);
	
	/**
     * 查询用户列表
     * 
     * @param hzBaseUser 用户信息
     * @return 用户集合
     */
	public List<HzBaseUser> selectHzBaseUserList(HzBaseUser hzBaseUser);
	
	/**
     * 新增用户
     * 
     * @param hzBaseUser 用户信息
     * @return 结果
     */
	public int insertHzBaseUser(HzBaseUser hzBaseUser);
	
	/**
     * 修改用户
     * 
     * @param hzBaseUser 用户信息
     * @return 结果
     */
	public int updateHzBaseUser(HzBaseUser hzBaseUser);
	
	/**
     * 删除用户
     * 
     * @param id 用户ID
     * @return 结果
     */
	public int deleteHzBaseUserById(Long id);
	
	/**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHzBaseUserByIds(String[] ids);
	
}