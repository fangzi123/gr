package com.cyou.gr.entity;

public class Project {
    private Integer id;

    private String name;

    private Integer processId;

    private String releaseLine;

    private Integer sort;

    private Boolean flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public String getReleaseLine() {
        return releaseLine;
    }

    public void setReleaseLine(String releaseLine) {
        this.releaseLine = releaseLine;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}