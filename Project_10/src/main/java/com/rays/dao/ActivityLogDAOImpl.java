package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ActivityLogDTO;

@Repository
public class ActivityLogDAOImpl
		extends BaseDAOImpl<ActivityLogDTO>
		implements ActivityLogDAOInt {

	@Override
	protected List<Predicate> getWhereClause(
			ActivityLogDTO dto,
			CriteriaBuilder builder,
			Root<ActivityLogDTO> qRoot) {

		List<Predicate> where = new ArrayList<>();

		if (!isEmptyString(dto.getActivityName())) {
			where.add(builder.like(
					qRoot.get("activityName"),
					dto.getActivityName() + "%"));
		}

		if (!isEmptyString(dto.getPerformedBy())) {
			where.add(builder.equal(
					qRoot.get("performedBy"),
					dto.getPerformedBy()));
		}

		if (dto.getActivityTime() != null) {
			where.add(builder.equal(
					qRoot.get("activityTime"),
					dto.getActivityTime()));
		}

		if (!isEmptyString(dto.getActivityStatus())) {
			where.add(builder.equal(
					qRoot.get("activityStatus"),
					dto.getActivityStatus()));
		}

		return where;
	}

	@Override
	public Class<ActivityLogDTO> getDTOClass() {
		return ActivityLogDTO.class;
	}
}
