package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseForm;
import com.rays.dto.ProjectDTO;

public class ProjectForm extends BaseForm {

	@NotEmpty(message = "Please enter project name")
	private String projectName;

	@NotEmpty(message = "Please select project category")
	private String projectCategory;

	@NotNull(message = "Please select project date")
	private Date projectDob;

	@NotEmpty(message = "Please enter project version")
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

	/* ================= DTO Mapping ================= */

	@Override
	public ProjectDTO getDto() {

		ProjectDTO dto = initDTO(new ProjectDTO());

		dto.setProjectName(projectName);
		dto.setProjectCategory(projectCategory);
		dto.setProjectDob(projectDob);
		dto.setProjectVersion(projectVersion);

		return dto;
	}
}
