package com.rays.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.AuditDTO;

@Repository
public class AuditDAOImpl extends BaseDAOImpl<AuditDTO> implements AuditDAOInt {

	@Override
	protected List<Predicate> getWhereClause(
			AuditDTO dto,
			CriteriaBuilder builder,
			Root<AuditDTO> qRoot) {

		List<Predicate> where = new ArrayList<>();

		// Action Type
		if (!isEmptyString(dto.getActionType())) {
			where.add(builder.like(
					qRoot.get("actionType"),
					dto.getActionType() + "%"));
		}

		// Action By
		if (!isEmptyString(dto.getActionBy())) {
			where.add(builder.equal(
					qRoot.get("actionBy"),
					dto.getActionBy()));
		}

		// ✅ Action Date (SAFE DATE RANGE SEARCH)
		if (dto.getActionDate() != null) {

			Calendar cal = Calendar.getInstance();
			cal.setTime(dto.getActionDate());

			// Start of day
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			Date startDate = cal.getTime();

			// End of day (next day)
			cal.add(Calendar.DATE, 1);
			Date endDate = cal.getTime();

			where.add(builder.between(
					qRoot.get("actionDate"),
					startDate,
					endDate));
		}

		// Action Result
		if (!isEmptyString(dto.getActionResult())) {
			where.add(builder.equal(
					qRoot.get("actionResult"),
					dto.getActionResult()));
		}

		return where;
	}

	@Override
	public Class<AuditDTO> getDTOClass() {
		return AuditDTO.class;
	}
}
