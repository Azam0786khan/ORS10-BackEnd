package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseForm;
import com.rays.dto.ActivityLogDTO;

public class ActivityLogForm extends BaseForm {

	@NotEmpty(message = "Please enter activity name")
	private String activityName;

	@NotEmpty(message = "Please enter performed by")
	private String performedBy;

	@NotNull(message = "Please select activity time")
	private Date activityTime;

	@NotEmpty(message = "Please select activity status")
	private String activityStatus;

	/* Getters & Setters */

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getPerformedBy() {
		return performedBy;
	}

	public void setPerformedBy(String performedBy) {
		this.performedBy = performedBy;
	}

	public Date getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(Date activityTime) {
		this.activityTime = activityTime;
	}

	public String getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}

	@Override
	public ActivityLogDTO getDto() {

		ActivityLogDTO dto = initDTO(new ActivityLogDTO());

		dto.setActivityName(activityName);
		dto.setPerformedBy(performedBy);
		dto.setActivityTime(activityTime);
		dto.setActivityStatus(activityStatus);

		return dto;
	}
}
