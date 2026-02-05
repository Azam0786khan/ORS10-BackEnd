package com.rays.ctl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.AuditDTO;
import com.rays.form.AuditForm;
import com.rays.service.AuditServiceInt;

@RestController
@RequestMapping(value = "Audit")
public class AuditCtl extends BaseCtl<AuditForm, AuditDTO, AuditServiceInt> {

	/* ================= DATE BINDER ================= */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		binder.registerCustomEditor(
			Date.class,
			new CustomDateEditor(sdf, true)
		);
	}

	/* ================= PRELOAD ================= */
	@GetMapping("/preload")
	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);

		HashMap<Integer, String> resultMap = new HashMap<>();
		resultMap.put(1, "SUCCESS");
		resultMap.put(2, "FAILED");

		res.addResult("actionResultList", resultMap);

		return res;
	}
}
