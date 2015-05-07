package com.cyou.gr.entity;

public class Manpower {
    private Integer id;

    private Integer proNodeId;

    private Integer manpowerId;

    private String coreMan;

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

    public String getCoreMan() {
        return coreMan;
    }

    public void setCoreMan(String coreMan) {
        this.coreMan = coreMan;
    }
}