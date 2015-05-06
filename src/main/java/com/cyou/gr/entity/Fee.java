package com.cyou.gr.entity;

public class Fee {
    private Integer id;

    private Integer proNodeId;

    private Integer feeTemplateId;

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

    public Integer getFeeTemplateId() {
        return feeTemplateId;
    }

    public void setFeeTemplateId(Integer feeTemplateId) {
        this.feeTemplateId = feeTemplateId;
    }
}