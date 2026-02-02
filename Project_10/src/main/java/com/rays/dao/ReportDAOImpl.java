package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ReportDTO;

@Repository
public class ReportDAOImpl extends BaseDAOImpl<ReportDTO> implements ReportDAOInt {

	@Override
	protected List<Predicate> getWhereClause(ReportDTO dto, CriteriaBuilder builder, Root<ReportDTO> qRoot) {

		List<Predicate> where = new ArrayList<>();

		if (!isEmptyString(dto.getReportName())) {
			where.add(builder.like(qRoot.get("reportName"), dto.getReportName() + "%"));
		}

		if (!isEmptyString(dto.getGeneratedBy())) {
			where.add(builder.equal(qRoot.get("generatedBy"), dto.getGeneratedBy()));
		}

		if (!isEmptyString(dto.getReportStatus())) {
			where.add(builder.equal(qRoot.get("reportStatus"), dto.getReportStatus()));
		}

		if (dto.getGeneratedDate() != null) {
			where.add(builder.equal(qRoot.get("generatedDate"), dto.getGeneratedDate()));
		}

		return where;
	}

	@Override
	public Class<ReportDTO> getDTOClass() {
		return ReportDTO.class;
	}
}
