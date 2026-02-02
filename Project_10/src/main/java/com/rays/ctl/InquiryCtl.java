package com.rays.ctl;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.InquiryDTO;
import com.rays.form.InquiryForm;
import com.rays.service.InquiryServiceInt;

@RestController
@RequestMapping(value = "Inquiry")
public class InquiryCtl extends BaseCtl<InquiryForm, InquiryDTO, InquiryServiceInt> {

	@GetMapping("/preload")
	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);

		HashMap<Integer, String> statusMap = new HashMap<>();
		statusMap.put(1, "NEW");
		statusMap.put(2, "IN_PROGRESS");
		statusMap.put(3, "RESOLVED");
		statusMap.put(4, "CLOSED");

		res.addResult("inquiryStatusList", statusMap);

		return res;
	}
}
