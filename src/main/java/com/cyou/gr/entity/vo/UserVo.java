package com.cyou.gr.entity.vo;

import java.util.List;

import com.cyou.gr.entity.User;

public class UserVo extends User {
	private String porIdsView;
	private String porIdsEdit;
	private List<ProjectVo> proList;

	public List<ProjectVo> getProList() {
		return proList;
	}

	public void setProList(List<ProjectVo> proList) {
		this.proList = proList;
	}

	public String getPorIdsView() {
		return porIdsView;
	}

	public void setPorIdsView(String porIdsView) {
		this.porIdsView = porIdsView;
	}

	public String getPorIdsEdit() {
		return porIdsEdit;
	}

	public void setPorIdsEdit(String porIdsEdit) {
		this.porIdsEdit = porIdsEdit;
	}

}
