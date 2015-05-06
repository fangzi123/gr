package com.cyou.gr.entity;

public class ProcessNode {
    private Integer id;

    private String name;

    private Integer processId;

    private Short sort;

    private String processType;

    private Boolean hasStatus;

    private Boolean hasStartEndTime;

    private Boolean hasReviewTime;

    private Boolean hasDoc;

    private Boolean hasCurrentProgress;

    private Boolean hasModuleDesc;

    private Boolean flag;

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

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public Boolean getHasStatus() {
        return hasStatus;
    }

    public void setHasStatus(Boolean hasStatus) {
        this.hasStatus = hasStatus;
    }

    public Boolean getHasStartEndTime() {
        return hasStartEndTime;
    }

    public void setHasStartEndTime(Boolean hasStartEndTime) {
        this.hasStartEndTime = hasStartEndTime;
    }

    public Boolean getHasReviewTime() {
        return hasReviewTime;
    }

    public void setHasReviewTime(Boolean hasReviewTime) {
        this.hasReviewTime = hasReviewTime;
    }

    public Boolean getHasDoc() {
        return hasDoc;
    }

    public void setHasDoc(Boolean hasDoc) {
        this.hasDoc = hasDoc;
    }

    public Boolean getHasCurrentProgress() {
        return hasCurrentProgress;
    }

    public void setHasCurrentProgress(Boolean hasCurrentProgress) {
        this.hasCurrentProgress = hasCurrentProgress;
    }

    public Boolean getHasModuleDesc() {
        return hasModuleDesc;
    }

    public void setHasModuleDesc(Boolean hasModuleDesc) {
        this.hasModuleDesc = hasModuleDesc;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}