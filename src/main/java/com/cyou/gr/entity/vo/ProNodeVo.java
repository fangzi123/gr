package com.cyou.gr.entity.vo;

import java.math.BigDecimal;

public class ProNodeVo {
	private Integer id;
	private Integer projectId;
	private Integer processNodeId;
	private String status;
	private String isNormal;
	private String currentProgressDesc;
	private String startTime;
	private String endTime;
	private String reviewTime;

	private Integer[] feeId;
	private Integer[] manpowerId;
	private Integer[] taskbookId;
	private Integer[] checkbillId;
	
	private Boolean[] display;
	private BigDecimal[] money;
	private BigDecimal[] coreMan;
	private BigDecimal[] quotaNum;
	private BigDecimal[] quotaNumReal;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getProcessNodeId() {
		return processNodeId;
	}

	public void setProcessNodeId(Integer processNodeId) {
		this.processNodeId = processNodeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsNormal() {
		return isNormal;
	}

	public void setIsNormal(String isNormal) {
		this.isNormal = isNormal;
	}

	public String getCurrentProgressDesc() {
		return currentProgressDesc;
	}

	public void setCurrentProgressDesc(String currentProgressDesc) {
		this.currentProgressDesc = currentProgressDesc;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getReviewTime() {
		return reviewTime;
	}

	public void setReviewTime(String reviewTime) {
		this.reviewTime = reviewTime;
	}

	public Integer[] getFeeId() {
		return feeId;
	}

	public void setFeeId(Integer[] feeId) {
		this.feeId = feeId;
	}

	public Integer[] getManpowerId() {
		return manpowerId;
	}

	public void setManpowerId(Integer[] manpowerId) {
		this.manpowerId = manpowerId;
	}

	public Integer[] getTaskbookId() {
		return taskbookId;
	}

	public void setTaskbookId(Integer[] taskbookId) {
		this.taskbookId = taskbookId;
	}

	public Integer[] getCheckbillId() {
		return checkbillId;
	}

	public void setCheckbillId(Integer[] checkbillId) {
		this.checkbillId = checkbillId;
	}

	public Boolean[] getDisplay() {
		return display;
	}

	public void setDisplay(Boolean[] display) {
		this.display = display;
	}

	public BigDecimal[] getMoney() {
		return money;
	}

	public void setMoney(BigDecimal[] money) {
		this.money = money;
	}

	public BigDecimal[] getCoreMan() {
		return coreMan;
	}

	public void setCoreMan(BigDecimal[] coreMan) {
		this.coreMan = coreMan;
	}

	public BigDecimal[] getQuotaNum() {
		return quotaNum;
	}

	public void setQuotaNum(BigDecimal[] quotaNum) {
		this.quotaNum = quotaNum;
	}

	public BigDecimal[] getQuotaNumReal() {
		return quotaNumReal;
	}

	public void setQuotaNumReal(BigDecimal[] quotaNumReal) {
		this.quotaNumReal = quotaNumReal;
	}


}
