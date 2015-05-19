package com.cyou.gr.entity;

public class ManpowerTemplate {
    private Integer id;

    private Integer processNodeId;

    private String projectTeam;

    private String standardModel;

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

    public String getProjectTeam() {
        return projectTeam;
    }

    public void setProjectTeam(String projectTeam) {
        this.projectTeam = projectTeam;
    }

    public String getStandardModel() {
        return standardModel;
    }

    public void setStandardModel(String standardModel) {
        this.standardModel = standardModel;
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

	public Boolean getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(Boolean isUsed) {
		this.isUsed = isUsed;
	}
}