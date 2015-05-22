package com.cyou.gr.entity;

import java.util.List;


public class Process {
    private Integer id;

    private String name;

    private Integer sort;

    private Boolean flag;
    
    private List<Project> projList;
    
//    private List<ProcessNode> procNodeList;
    
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

	public List<Project> getProjList() {
		return projList;
	}

	public void setProjList(List<Project> projList) {
		this.projList = projList;
	}

}