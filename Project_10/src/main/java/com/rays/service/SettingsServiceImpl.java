package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rays.common.BaseServiceImpl;
import com.rays.dao.SettingsDAOInt;
import com.rays.dto.SettingsDTO;

@Service
@Transactional
public class SettingsServiceImpl extends BaseServiceImpl<SettingsDTO, SettingsDAOInt>
		implements SettingsServiceInt {
}
