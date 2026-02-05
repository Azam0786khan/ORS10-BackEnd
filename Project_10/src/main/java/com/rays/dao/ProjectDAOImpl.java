package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ProjectDTO;

@Repository
public class ProjectDAOImpl extends BaseDAOImpl<ProjectDTO> implements ProjectDAOInt {

	@Override
	protected List<Predicate> getWhereClause(ProjectDTO dto,
			CriteriaBuilder builder,
			Root<ProjectDTO> qRoot) {

		List<Predicate> where = new ArrayList<>();

		if (!isEmptyString(dto.getProjectName())) {
			where.add(builder.like(qRoot.get("projectName"),
					dto.getProjectName() + "%"));
		}

		if (!isEmptyString(dto.getProjectCategory())) {
			where.add(builder.equal(qRoot.get("projectCategory"),
					dto.getProjectCategory()));
		}

		if (dto.getProjectDob() != null) {
			where.add(builder.equal(qRoot.get("projectDob"),
					dto.getProjectDob()));
		}

		if (!isEmptyString(dto.getProjectVersion())) {
			where.add(builder.equal(qRoot.get("projectVersion"),
					dto.getProjectVersion()));
		}

		return where;
	}

	@Override
	public Class<ProjectDTO> getDTOClass() {
		return ProjectDTO.class;
	}
}
