package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.InquiryDTO;

@Repository
public class InquiryDAOImpl extends BaseDAOImpl<InquiryDTO> implements InquiryDAOInt {

	@Override
	protected List<Predicate> getWhereClause(InquiryDTO dto,
			CriteriaBuilder builder,
			Root<InquiryDTO> qRoot) {

		List<Predicate> where = new ArrayList<>();

		if (!isEmptyString(dto.getInquirerName())) {
			where.add(builder.like(qRoot.get("inquirerName"), dto.getInquirerName() + "%"));
		}

		if (!isEmptyString(dto.getEmail())) {
			where.add(builder.equal(qRoot.get("email"), dto.getEmail()));
		}

		if (!isEmptyString(dto.getInquiryStatus())) {
			where.add(builder.equal(qRoot.get("inquiryStatus"), dto.getInquiryStatus()));
		}

		return where;
	}

	@Override
	public Class<InquiryDTO> getDTOClass() {
		return InquiryDTO.class;
	}
}
