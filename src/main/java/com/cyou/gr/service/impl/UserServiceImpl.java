package com.cyou.gr.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.User2projectMapper;
import com.cyou.gr.dao.UserMapper;
import com.cyou.gr.entity.User;
import com.cyou.gr.entity.User2project;
import com.cyou.gr.entity.vo.UserVo;
import com.cyou.gr.service.UserService;
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private User2projectMapper user2projectMapper;

	@Override
	public User selectUserByName(String name) throws Exception {
		return userMapper.selectByName(name);
	}

	@Override
	public List<UserVo> selectUserList() throws Exception {
		List<UserVo> list=userMapper.selectUserList();
		return list;
	}

	@Override
	public void saveOrUpdateUser(UserVo uv) throws Exception {
		User u=new User();
		BeanUtils.copyProperties(uv, u);
		int a=userMapper.insert(u);
		
		String porIdsView=uv.getPorIdsView();
		String porIdsEdit=uv.getPorIdsEdit();
		String[] porIds=porIdsView.split(",");
		for(int i=0;i<porIds.length;i++){
			User2project up=new User2project();
			up.setUserId(u.getId());
			up.setIsView(true);
			up.setProjectId(Integer.valueOf(porIds[i]));
			up.setFlag(true);
			if(porIdsEdit.contains(porIds[i])){
				up.setIsEdit(true);
			}else{
				up.setIsEdit(false);
			}
			user2projectMapper.insertSelective(up);
		}
		
	}

	@Override
	public void deleteUser(Integer userId) {
		User u=new User();
		u.setId(userId);
		u.setFlag(false);
		userMapper.updateByPrimaryKeySelective(u);
	}

}
