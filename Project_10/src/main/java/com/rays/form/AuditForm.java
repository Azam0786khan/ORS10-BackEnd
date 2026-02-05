package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseForm;
import com.rays.dto.AuditDTO;

public class AuditForm extends BaseForm {

	@NotEmpty(message = "Please enter action type")
	private String actionType;

	@NotEmpty(message = "Please enter action by")
	private String actionBy;

	@NotNull(message = "Please select action date")
	private Date actionDate;   // ✅ java.util.Date

	@NotEmpty(message = "Please select action result")
	private String actionResult;

	/* ================= Getters & Setters ================= */

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getActionBy() {
		return actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public String getActionResult() {
		return actionResult;
	}

	public void setActionResult(String actionResult) {
		this.actionResult = actionResult;
	}

	/* ================= DTO Mapping ================= */

	@Override
	public AuditDTO getDto() {

		AuditDTO dto = initDTO(new AuditDTO());

		dto.setActionType(actionType);
		dto.setActionBy(actionBy);
		dto.setActionDate(actionDate);
		dto.setActionResult(actionResult);

		return dto;
	}
}
