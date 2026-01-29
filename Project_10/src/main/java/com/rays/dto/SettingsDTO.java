package com.rays.dto;

import java.util.LinkedHashMap;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_SETTINGS")
public class SettingsDTO extends BaseDTO {

	@Column(name = "SETTING_NAME", length = 50)
	private String settingName;

	@Column(name = "SETTING_VALUE", length = 100)
	private String settingValue;

	@Column(name = "SETTING_TYPE", length = 30)
	private String settingType;

	@Column(name = "SETTING_STATUS", length = 20)
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
	public String getValue() { return settingName; }

	@Override
	public String getUniqueKey() { return "settingName"; }

	@Override
	public String getUniqueValue() { return settingName; }

	@Override
	public String getLabel() { return "Setting Name"; }

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("settingName", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("settingName", settingName);
		return map;
	}
}
