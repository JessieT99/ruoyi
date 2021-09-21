package com.ruoyi.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.HzBaseUserMapper;
import com.ruoyi.project.domain.HzBaseUser;
import com.ruoyi.project.service.IHzBaseUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户 服务层实现
 * 
 * @author ruoyi
 * @date 2021-09-21
 */
@Service
public class HzBaseUserServiceImpl implements IHzBaseUserService 
{
	@Autowired
	private HzBaseUserMapper hzBaseUserMapper;



	/**
     * 查询用户信息
     * 
     * @param id 用户ID
     * @return 用户信息
     */
    @Override
	public HzBaseUser selectHzBaseUserById(Long id)
	{
	    return hzBaseUserMapper.selectHzBaseUserById(id);
	}
	
	/**
     * 查询用户列表
     * 
     * @param hzBaseUser 用户信息
     * @return 用户集合
     */
	@Override
	public List<HzBaseUser> selectHzBaseUserList(HzBaseUser hzBaseUser)
	{
	    return hzBaseUserMapper.selectHzBaseUserList(hzBaseUser);
	}
	
    /**
     * 新增用户
     * 
     * @param hzBaseUser 用户信息
     * @return 结果
     */
	@Override
	public int insertHzBaseUser(HzBaseUser hzBaseUser)
	{
	    return hzBaseUserMapper.insertHzBaseUser(hzBaseUser);
	}
	
	/**
     * 修改用户
     * 
     * @param hzBaseUser 用户信息
     * @return 结果
     */
	@Override
	public int updateHzBaseUser(HzBaseUser hzBaseUser)
	{
	    return hzBaseUserMapper.updateHzBaseUser(hzBaseUser);
	}

	/**
     * 删除用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHzBaseUserByIds(String ids)
	{
		return hzBaseUserMapper.deleteHzBaseUserByIds(Convert.toStrArray(ids));
	}
	
}
