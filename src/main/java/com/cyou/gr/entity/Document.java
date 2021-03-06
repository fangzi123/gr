package com.cyou.gr.entity;

import java.util.Date;

public class Document {
    private Integer id;

	private String name;

	private Integer processId;

	private Integer projectId;

	private Integer procNodeId;

	private Integer proNodeId;
	private ProNode proNode;

	private String releaseLine;

	private String filename;

	private String url;

	private String author;

	private Date uploadTime;

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

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getProcNodeId() {
		return procNodeId;
	}

	public void setProcNodeId(Integer procNodeId) {
		this.procNodeId = procNodeId;
	}

	public Integer getProNodeId() {
		return proNodeId;
	}

	public void setProNodeId(Integer proNodeId) {
		this.proNodeId = proNodeId;
	}

	public String getReleaseLine() {
		return releaseLine;
	}

	public void setReleaseLine(String releaseLine) {
		this.releaseLine = releaseLine;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public ProNode getProNode() {
		return proNode;
	}

	public void setProNode(ProNode proNode) {
		this.proNode = proNode;
	}

}