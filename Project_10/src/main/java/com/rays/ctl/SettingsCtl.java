package com.rays.ctl;

import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.SettingsDTO;
import com.rays.form.SettingsForm;
import com.rays.service.SettingsServiceInt;

@RestController
@RequestMapping(value = "Settings")
public class SettingsCtl extends BaseCtl<SettingsForm, SettingsDTO, SettingsServiceInt> {

	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);

		HashMap<Integer, String> typeMap = new HashMap<>();
		typeMap.put(1, "SYSTEM");
		typeMap.put(2, "APPLICATION");
		typeMap.put(3, "USER");

		HashMap<Integer, String> statusMap = new HashMap<>();
		statusMap.put(1, "ACTIVE");
		statusMap.put(2, "INACTIVE");

		res.addResult("settingTypeList", typeMap);
		res.addResult("settingStatusList", statusMap);

		return res;
	}
}
