package com.rays.form;

import javax.validation.constraints.NotEmpty;
import com.rays.common.BaseForm;
import com.rays.dto.SettingsDTO;

public class SettingsForm extends BaseForm {

	@NotEmpty(message = "Please enter setting name")
	private String settingName;

	@NotEmpty(message = "Please enter setting value")
	private String settingValue;

	@NotEmpty(message = "Please select setting type")
	private String settingType;

	@NotEmpty(message = "Please select setting status")
	private String settingStatus;

	public String getSettingName() { return settingName; }
	public void setSettingName(String settingName) { this.settingName = settingName; }

	public String getSettingValue() { return settingValue; }
	public void setSettingValue(String settingValue) { this.settingValue = settingValue; }

	public String getSettingType() { return settingType; }
	public void setSettingType(String settingType) { this.settingType = settingType; }

	public String getSettingStatus() { return settingStatus; }
	public void setSettingStatus(String settingStatus) { this.settingStatus = settingStatus; }

	@Override
	public SettingsDTO getDto() {
		SettingsDTO dto = initDTO(new SettingsDTO());
		dto.setSettingName(settingName);
		dto.setSettingValue(settingValue);
		dto.setSettingType(settingType);
		dto.setSettingStatus(settingStatus);
		return dto;
	}
}
