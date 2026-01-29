package com.rays.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.rays.common.BaseDAOImpl;
import com.rays.dto.SettingsDTO;

@Repository
public class SettingsDAOImpl extends BaseDAOImpl<SettingsDTO> implements SettingsDAOInt {

	@Override
	protected List<Predicate> getWhereClause(SettingsDTO dto, CriteriaBuilder builder, Root<SettingsDTO> qRoot) {
		List<Predicate> where = new ArrayList<>();

		if (!isEmptyString(dto.getSettingName())) {
			where.add(builder.like(qRoot.get("settingName"), dto.getSettingName() + "%"));
		}
		if (!isEmptyString(dto.getSettingType())) {
			where.add(builder.equal(qRoot.get("settingType"), dto.getSettingType()));
		}
		if (!isEmptyString(dto.getSettingStatus())) {
			where.add(builder.equal(qRoot.get("settingStatus"), dto.getSettingStatus()));
		}
		return where;
	}

	@Override
	public Class<SettingsDTO> getDTOClass() {
		return SettingsDTO.class;
	}
}
