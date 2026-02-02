package com.rays.ctl;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.ReportDTO;
import com.rays.form.ReportForm;
import com.rays.service.ReportServiceInt;

@RestController
@RequestMapping(value = "Report")
public class ReportCtl extends BaseCtl<ReportForm, ReportDTO, ReportServiceInt> {

	@GetMapping("/preload")
	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);

		HashMap<Integer, String> statusMap = new HashMap<>();
		statusMap.put(1, "GENERATED");
		statusMap.put(2, "PENDING");
		statusMap.put(3, "FAILED");

		res.addResult("reportStatusList", statusMap);

		return res;
	}
}
