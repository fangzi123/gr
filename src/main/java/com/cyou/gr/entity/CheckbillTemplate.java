package com.cyou.gr.entity;

public class CheckbillTemplate {
    private Integer id;

    private Integer processNodeId;

    private String checkItem;

    private String checkItemProperty;

    private String remark;

    private Boolean isqualified;

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

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem;
    }

    public String getCheckItemProperty() {
        return checkItemProperty;
    }

    public void setCheckItemProperty(String checkItemProperty) {
        this.checkItemProperty = checkItemProperty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getIsqualified() {
        return isqualified;
    }

    public void setIsqualified(Boolean isqualified) {
        this.isqualified = isqualified;
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }
}