package com.rays.ctl;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.ActivityLogDTO;
import com.rays.form.ActivityLogForm;
import com.rays.service.ActivityLogServiceInt;

@RestController
@RequestMapping(value = "ActivityLog")
public class ActivityLogCtl
		extends BaseCtl<ActivityLogForm, ActivityLogDTO, ActivityLogServiceInt> {

	@GetMapping("/preload")
	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);

		HashMap<Integer, String> statusMap = new HashMap<>();
		statusMap.put(1, "SUCCESS");
		statusMap.put(2, "FAILED");

		res.addResult("activityStatusList", statusMap);
		return res;
	}
}
