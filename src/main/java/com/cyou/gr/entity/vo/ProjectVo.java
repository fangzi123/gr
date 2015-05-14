package com.cyou.gr.entity.vo;

import com.cyou.gr.entity.Process;
import com.cyou.gr.entity.Project;

public class ProjectVo extends Project {
	private Boolean isView;

	private Boolean isEdit;

	private Process process;
	
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

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}
}
