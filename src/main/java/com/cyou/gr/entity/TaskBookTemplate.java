package com.cyou.gr.entity;

public class TaskBookTemplate {
    private Integer id;

    private Integer processNodeId;

    private String quotaName;

    private String quotaType;

    private Byte sort;

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

    public String getQuotaType() {
        return quotaType;
    }

    public void setQutaType(String qutaType) {
        this.quotaType = qutaType;
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }
}