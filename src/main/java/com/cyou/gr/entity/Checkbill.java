package com.cyou.gr.entity;

public class Checkbill {
    private Integer id;

    private Integer proNodeId;

    private Integer checkbillTemplateId;
    private CheckbillTemplate checkbillTemplate;

    private Boolean isqualified;

    private String checkItem;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProNodeId() {
        return proNodeId;
    }

    public void setProNodeId(Integer proNodeId) {
        this.proNodeId = proNodeId;
    }

    public Integer getCheckbillTemplateId() {
        return checkbillTemplateId;
    }

    public void setCheckbillTemplateId(Integer checkbillTemplateId) {
        this.checkbillTemplateId = checkbillTemplateId;
    }

    public Boolean getIsqualified() {
        return isqualified;
    }

    public void setIsqualified(Boolean isqualified) {
        this.isqualified = isqualified;
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

	public CheckbillTemplate getCheckbillTemplate() {
		return checkbillTemplate;
	}

	public void setCheckbillTemplate(CheckbillTemplate checkbillTemplate) {
		this.checkbillTemplate = checkbillTemplate;
	}
}