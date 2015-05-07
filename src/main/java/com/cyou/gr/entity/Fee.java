package com.cyou.gr.entity;

import java.math.BigDecimal;

public class Fee {
    private Integer id;

    private Integer proNodeId;

    private Integer feeTemplateId;

    private BigDecimal money;

    private Boolean display;

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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }
}