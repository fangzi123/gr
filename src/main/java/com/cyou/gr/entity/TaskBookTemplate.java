package com.cyou.gr.entity;

public class TaskBookTemplate {
    private Integer id;

    private Integer processNodeId;

    private String quotaName;

    private String quotaType;

    private Byte sort;
    private Boolean flag;
    private Boolean isUsed;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProcessNodeId() {
        return processNodeId;
    }

    public void setProcessNodeId(Integer processNodeId) {
        this.processNodeId = processNodeId;
    }

    public String getQuotaName() {
        return quotaName;
    }

    public void setQuotaName(String quotaName) {
        this.quotaName = quotaName;
    }


    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public void setQuotaType(String quotaType) {
		this.quotaType = quotaType;
	}

	public String getQuotaType() {
		return quotaType;
	}

	public Boolean getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(Boolean isUsed) {
		this.isUsed = isUsed;
	}
}