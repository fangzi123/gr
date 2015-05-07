package com.cyou.gr.entity;

public class FeeTemplate {
    private Integer id;

    private Integer processNodeId;

    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }
}