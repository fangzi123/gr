package com.cyou.gr.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.cyou.gr.util.PasswordHelper;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private User2projectMapper user2projectMapper;
	@Autowired
	private PasswordHelper passwordHelper;
	@Override
	public User selectUserByName(String name){
		return userMapper.selectByName(name);
	}

	@Override
	public List<UserVo> selectUserList() throws Exception {
		List<UserVo> list = userMapper.selectUserList();
		return list;
	}

	@Override
	public void saveOrUpdateUser(UserVo uv) throws Exception {
		passwordHelper.encryptPassword(uv);
		if (uv.getId() == null) {//新增
			User u = new User();
			BeanUtils.copyProperties(uv, u);
			u.setFlag(true);
			userMapper.insert(u);
			String porIdsView = uv.getPorIdsView();
			String porIdsEdit = uv.getPorIdsEdit();
			if(porIdsEdit!=null){
				String[] porIds = porIdsView.split(",");
				for (int i = 0; i < porIds.length; i++) {
					User2project up = new User2project();
					up.setUserId(u.getId());
					up.setProjectId(Integer.valueOf(porIds[i]));
					if (porIdsEdit.contains(porIds[i])) {
						up.setIsEdit(true);
					} 
					user2projectMapper.insertSelective(up);
				}
			}
		} else {//修改
			user2projectMapper.deleteAllByUserId(uv.getId());
			User u = new User();
			BeanUtils.copyProperties(uv, u);
		    userMapper.updateByPrimaryKeySelective(u);
		    String porIdsView = uv.getPorIdsView();
			String porIdsEdit = uv.getPorIdsEdit();
			if(porIdsView!=null){
				String[] porIds = porIdsView.split(",");
				for (int i = 0; i < porIds.length; i++) {
					User2project up = new User2project();
					up.setUserId(u.getId());
					up.setProjectId(Integer.valueOf(porIds[i]));
					if (porIdsEdit!=null&&porIdsEdit.contains(porIds[i])) {
						up.setIsEdit(true);
					}
					user2projectMapper.insertSelective(up);
				}
			}
		}

	}

	@Override
	public void deleteUser(Integer userId) {
		User u = new User();
		u.setId(userId);
		u.setFlag(false);
		userMapper.updateByPrimaryKeySelective(u);
	}

	@Override
	public Set<String> selectPermissions(Integer userid) {
		Set<String> permissions = new HashSet<String>();
		List<User2project> u2pList =user2projectMapper.selectUser2projectsByUserid(userid);
	        for(User2project u2p : u2pList) {
	            if(u2p != null) {
	                permissions.add("view:"+u2p.getProjectId());
	                if(u2p.getIsEdit()){
	                	permissions.add("edit:"+u2p.getProjectId());
	                }
	            }
	        }
	   return permissions;
	}

}
