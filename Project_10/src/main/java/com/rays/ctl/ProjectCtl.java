package com.rays.ctl;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.ProjectDTO;
import com.rays.form.ProjectForm;
import com.rays.service.ProjectServiceInt;

@RestController
@RequestMapping(value = "Project")
public class ProjectCtl extends BaseCtl<ProjectForm, ProjectDTO, ProjectServiceInt> {

	@GetMapping("/preload")
	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);

		// Project Category preload
		HashMap<Integer, String> categoryMap = new HashMap<>();
		categoryMap.put(1, "Web Application");
		categoryMap.put(2, "Mobile Application");
		categoryMap.put(3, "Desktop Application");
		categoryMap.put(4, "Cloud Project");

		res.addResult("projectCategoryList", categoryMap);

		return res;
	}
}
