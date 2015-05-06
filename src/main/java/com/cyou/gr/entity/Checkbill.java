package com.cyou.gr.entity;

public class Checkbill {
    private Integer id;

    private Integer proNodeId;

    private Integer checkbillTemplateId;

    private Boolean isqualified;

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
}