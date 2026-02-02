package com.rays.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseForm;
import com.rays.dto.InquiryDTO;

public class InquiryForm extends BaseForm {

	@NotEmpty(message = "Please enter inquirer name")
	private String inquirerName;

	@NotEmpty(message = "Please enter email")
	@Email(message = "Please enter valid email")
	private String email;

	@NotEmpty(message = "Please enter inquiry subject")
	private String inquirySubject;

	@NotEmpty(message = "Please select inquiry status")
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

	/* ================= DTO Mapping ================= */

	@Override
	public InquiryDTO getDto() {

		InquiryDTO dto = initDTO(new InquiryDTO());

		dto.setInquirerName(inquirerName);
		dto.setEmail(email);
		dto.setInquirySubject(inquirySubject);
		dto.setInquiryStatus(inquiryStatus);

		return dto;
	}
}
