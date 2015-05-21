package com.cyou.gr.entity;

import java.util.Date;

public class ProNode {
    private Integer id;

    private Integer projectId;

    private Integer processNodeId;
    private ProcessNode processNode;

    private String status;

    private Date startTime;

    private Date endTiem;

    private Date reviewTime;

    private String isNormal;

    private String currentProgressDesc;

    private String additionalDesc;

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTiem() {
        return endTiem;
    }

    public void setEndTiem(Date endTiem) {
        this.endTiem = endTiem;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
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

    public String getAdditionalDesc() {
        return additionalDesc;
    }

    public void setAdditionalDesc(String additionalDesc) {
        this.additionalDesc = additionalDesc;
    }

	public ProcessNode getProcessNode() {
		return processNode;
	}

	public void setProcessNode(ProcessNode processNode) {
		this.processNode = processNode;
	}
}