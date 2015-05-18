package com.cyou.gr.entity.vo;

import com.cyou.gr.entity.ProcessNode;

public class ProcessNodeVo extends ProcessNode {
	//费用模板
	private String[] feeName;
	//人力模板
	private String[] projectTeam;
	private String[] standardModel;
	//任务书模板
	private String[] quotaName;
	private String[] quotaType;
	//检查单模板
	private String[] checkItem;
	private String[] checkItemProperty;
	private String[] remark;

	private Integer[] feetId;
	private Integer[] manpowertId;
	private Integer[] taskbooktId;
	private Integer[] checkbilltId;
	
	public String[] getFeeName() {
		return feeName;
	}

	public void setFeeName(String[] feeName) {
		this.feeName = feeName;
	}

	public String[] getProjectTeam() {
		return projectTeam;
	}

	public void setProjectTeam(String[] projectTeam) {
		this.projectTeam = projectTeam;
	}

	public String[] getStandardModel() {
		return standardModel;
	}

	public void setStandardModel(String[] standardModel) {
		this.standardModel = standardModel;
	}

	public String[] getQuotaName() {
		return quotaName;
	}

	public void setQuotaName(String[] quotaName) {
		this.quotaName = quotaName;
	}

	public String[] getQuotaType() {
		return quotaType;
	}

	public void setQuotaType(String[] quotaType) {
		this.quotaType = quotaType;
	}

	public String[] getCheckItem() {
		return checkItem;
	}

	public void setCheckItem(String[] checkItem) {
		this.checkItem = checkItem;
	}

	public String[] getCheckItemProperty() {
		return checkItemProperty;
	}

	public void setCheckItemProperty(String[] checkItemProperty) {
		this.checkItemProperty = checkItemProperty;
	}

	public String[] getRemark() {
		return remark;
	}

	public void setRemark(String[] remark) {
		this.remark = remark;
	}

	public Integer[] getFeetId() {
		return feetId;
	}

	public void setFeetId(Integer[] feetId) {
		this.feetId = feetId;
	}

	public Integer[] getManpowertId() {
		return manpowertId;
	}

	public void setManpowertId(Integer[] manpowertId) {
		this.manpowertId = manpowertId;
	}

	public Integer[] getTaskbooktId() {
		return taskbooktId;
	}

	public void setTaskbooktId(Integer[] taskbooktId) {
		this.taskbooktId = taskbooktId;
	}

	public Integer[] getCheckbilltId() {
		return checkbilltId;
	}

	public void setCheckbilltId(Integer[] checkbilltId) {
		this.checkbilltId = checkbilltId;
	}
}
