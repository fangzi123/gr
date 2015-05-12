package com.cyou.gr.entity.vo;

import com.cyou.gr.entity.Project;

public class ProjectVo extends Project {
	private Boolean isView;

	private Boolean isEdit;

	public Boolean getIsView() {
		return isView;
	}

	public void setIsView(Boolean isView) {
		this.isView = isView;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
}
