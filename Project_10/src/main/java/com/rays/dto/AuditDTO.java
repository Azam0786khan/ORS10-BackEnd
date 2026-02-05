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
@Table(name = "ST_AUDIT")
public class AuditDTO extends BaseDTO {

	@Column(name = "ACTION_TYPE", length = 50)
	private String actionType;

	@Column(name = "ACTION_BY", length = 50)
	private String actionBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "ACTION_DATE")
	private Date actionDate;

	@Column(name = "ACTION_RESULT", length = 20)
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

	/* ================= BaseDTO Methods ================= */

	@Override
	public String getValue() {
		return actionType;
	}

	@Override
	public String getUniqueKey() {
		return "actionDate";
	}

	@Override
	public String getUniqueValue() {
		return actionDate != null ? actionDate.toString() : null;
	}

	@Override
	public String getLabel() {
		return "Action Type";
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("actionDate", "desc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("actionDate", actionDate);
		map.put("actionBy", actionBy);
		return map;
	}
}
