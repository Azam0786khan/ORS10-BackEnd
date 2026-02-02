package com.rays.dto;

import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_INQUIRY")
public class InquiryDTO extends BaseDTO {

	@Column(name = "INQUIRER_NAME", length = 50)
	private String inquirerName;

	@Column(name = "EMAIL", length = 50)
	private String email;

	@Column(name = "INQUIRY_SUBJECT", length = 100)
	private String inquirySubject;

	@Column(name = "INQUIRY_STATUS", length = 20)
	private String inquiryStatus;

	/* ================= Getters & Setters ================= */

	public String getInquirerName() {
		return inquirerName;
	}

	public void setInquirerName(String inquirerName) {
		this.inquirerName = inquirerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInquirySubject() {
		return inquirySubject;
	}

	public void setInquirySubject(String inquirySubject) {
		this.inquirySubject = inquirySubject;
	}

	public String getInquiryStatus() {
		return inquiryStatus;
	}

	public void setInquiryStatus(String inquiryStatus) {
		this.inquiryStatus = inquiryStatus;
	}

	/* ================= BaseDTO Overrides ================= */

	@Override
	public String getValue() {
		return inquirerName;
	}

	@Override
	public String getUniqueKey() {
		return "email";
	}

	@Override
	public String getUniqueValue() {
		return email;
	}

	@Override
	public String getLabel() {
		return "Inquirer Name";
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("inquirerName", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("email", email);
		return map;
	}
}
