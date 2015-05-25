package com.cyou.gr.entity;

import java.math.BigDecimal;

public class TaskBook {
    private Integer id;

    private Integer proNodeId;

    private Integer taskBookTemplateId;
    private TaskBookTemplate taskBookTemplate;

    private BigDecimal quotaNum;

    private BigDecimal quotaNumReal;

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

    public Integer getTaskBookTemplateId() {
        return taskBookTemplateId;
    }

    public void setTaskBookTemplateId(Integer taskBookTemplateId) {
        this.taskBookTemplateId = taskBookTemplateId;
    }

    public BigDecimal getQuotaNum() {
        return quotaNum;
    }

    public void setQuotaNum(BigDecimal quotaNum) {
        this.quotaNum = quotaNum;
    }

    public BigDecimal getQuotaNumReal() {
        return quotaNumReal;
    }

    public void setQuotaNumReal(BigDecimal quotaNumReal) {
        this.quotaNumReal = quotaNumReal;
    }

	public TaskBookTemplate getTaskBookTemplate() {
		return taskBookTemplate;
	}

	public void setTaskBookTemplate(TaskBookTemplate taskBookTemplate) {
		this.taskBookTemplate = taskBookTemplate;
	}
}