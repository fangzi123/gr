package com.cyou.gr.entity;

import java.math.BigDecimal;

public class Manpower {
    private Integer id;

    private Integer proNodeId;

    private Integer manpowerTemplateId;

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

    public BigDecimal getCoreMan() {
        return coreMan;
    }

    public void setCoreMan(BigDecimal coreMan) {
        this.coreMan = coreMan;
    }

	public Integer getManpowerTemplateId() {
		return manpowerTemplateId;
	}

	public void setManpowerTemplateId(Integer manpowerTemplateId) {
		this.manpowerTemplateId = manpowerTemplateId;
	}
}