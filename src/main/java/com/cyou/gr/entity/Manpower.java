package com.cyou.gr.entity;

import java.math.BigDecimal;

public class Manpower {
    private Integer id;

    private Integer proNodeId;

    private Integer manpowerId;

    private BigDecimal coreMan;

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

    public Integer getManpowerId() {
        return manpowerId;
    }

    public void setManpowerId(Integer manpowerId) {
        this.manpowerId = manpowerId;
    }

    public BigDecimal getCoreMan() {
        return coreMan;
    }

    public void setCoreMan(BigDecimal coreMan) {
        this.coreMan = coreMan;
    }
}