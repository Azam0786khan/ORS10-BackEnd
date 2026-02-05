package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_PROJECT")
public class ProjectDTO extends BaseDTO {

	@Column(name = "PROJECT_NAME", length = 50)
	private String projectName;

	@Column(name = "PROJECT_CATEGORY", length = 30)
	private String projectCategory;

	@Temporal(TemporalType.DATE)
	@Column(name = "PROJECT_DOB")
	private Date projectDob;

	@Column(name = "PROJECT_VERSION", length = 20)
	private String projectVersion;

	/* ================= Getters & Setters ================= */

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectCategory() {
		return projectCategory;
	}

	public void setProjectCategory(String projectCategory) {
		this.projectCategory = projectCategory;
	}

	public Date getProjectDob() {
		return projectDob;
	}

	public void setProjectDob(Date projectDob) {
		this.projectDob = projectDob;
	}

	public String getProjectVersion() {
		return projectVersion;
	}

	public void setProjectVersion(String projectVersion) {
		this.projectVersion = projectVersion;
	}

	/* ================= BaseDTO Overrides ================= */

	@Override
	public String getValue() {
		return projectName;
	}

	@Override
	public String getUniqueKey() {
		return "projectName";
	}

	@Override
	public String getUniqueValue() {
		return projectName;
	}

	@Override
	public String getLabel() {
		return "Project Name";
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("projectName", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("projectName", projectName);
		return map;
	}
}
