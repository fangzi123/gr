package com.cyou.gr.service;

import java.util.List;
import java.util.Set;

import com.cyou.gr.entity.User;
import com.cyou.gr.entity.vo.UserVo;


public interface UserService {
    public User selectUserByName(String name);
    /**
     * 查询用户列表
     * @return
     * @throws Exception
     */
	public List<UserVo> selectUserList() throws Exception;
	/**
	 * 添加账户
	 * @param uv
	 * @throws Exception
	 */
	public void saveOrUpdateUser(UserVo uv) throws Exception;
	/**
	 * 删除账户
	 * @param userId
	 */
	public void deleteUser(Integer userId);
	/**
	 * 用户 项目权限
	 * @param integer
	 * @return
	 */
	public Set<String> selectPermissions(Integer userid);
}
