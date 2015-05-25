package com.cyou.gr.entity;

public class ProcessNode {

	private Integer id;

	private String name;

	private Integer processId;
	private Process Process;

	private Integer sort;

	private String processType;

	private String endType;

	private String timeType;

	private Boolean flag;

	private Boolean hasFee;
	private Boolean hasManpower;
	private Boolean hasTaskbook;
	private Boolean hasCheckbill;
	private Boolean hasDocument;
	private String nodesOverview;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getProcessId() {
		return processId;
	}

	public void setProcessId(Integer processId) {
		this.processId = processId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getProcessType() {
		return processType;
	}

	public void setProcessType(String processType) {
		this.processType = processType;
	}

	public String getEndType() {
		return endType;
	}

	public void setEndType(String endType) {
		this.endType = endType;
	}

	public String getTimeType() {
		return timeType;
	}

	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public Process getProcess() {
		return Process;
	}

	public void setProcess(Process process) {
		Process = process;
	}

	public Boolean getHasFee() {
		return hasFee;
	}

	public void setHasFee(Boolean hasFee) {
		this.hasFee = hasFee;
	}


	public String getNodesOverview() {
		return nodesOverview;
	}

	public void setNodesOverview(String nodesOverview) {
		this.nodesOverview = nodesOverview;
	}

	public Boolean getHasManpower() {
		return hasManpower;
	}

	public void setHasManpower(Boolean hasManpower) {
		this.hasManpower = hasManpower;
	}

	public Boolean getHasTaskbook() {
		return hasTaskbook;
	}

	public void setHasTaskbook(Boolean hasTaskbook) {
		this.hasTaskbook = hasTaskbook;
	}

	public Boolean getHasCheckbill() {
		return hasCheckbill;
	}

	public void setHasCheckbill(Boolean hasCheckbill) {
		this.hasCheckbill = hasCheckbill;
	}

	public Boolean getHasDocument() {
		return hasDocument;
	}

	public void setHasDocument(Boolean hasDocument) {
		this.hasDocument = hasDocument;
	}
}