package com.cyou.gr.entity;

import java.util.Date;
import java.util.List;

public class ProNode {
    private Integer id;

    private Integer projectId;

    private Integer processNodeId;
    private ProcessNode processNode;

    private String status;

    private Date startTime;

    private Date endTime;

    private Date reviewTime;

    private String isNormal;

    private String currentProgressDesc;

    private String additionalDesc;

    private List<Fee> feeList;
    
    private List<Manpower> manpowerList;
    
    private List<TaskBook> taskbookList;
    
    private List<Checkbill> checkbillList;
    
    private List<Document> documentList;
    
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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

	public List<Fee> getFeeList() {
		return feeList;
	}

	public void setFeeList(List<Fee> feeList) {
		this.feeList = feeList;
	}

	public List<Manpower> getManpowerList() {
		return manpowerList;
	}

	public void setManpowerList(List<Manpower> manpowerList) {
		this.manpowerList = manpowerList;
	}

	public List<TaskBook> getTaskbookList() {
		return taskbookList;
	}

	public void setTaskbookList(List<TaskBook> taskbookList) {
		this.taskbookList = taskbookList;
	}

	public List<Checkbill> getCheckbillList() {
		return checkbillList;
	}

	public void setCheckbillList(List<Checkbill> checkbillList) {
		this.checkbillList = checkbillList;
	}

	public List<Document> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<Document> documentList) {
		this.documentList = documentList;
	}
}