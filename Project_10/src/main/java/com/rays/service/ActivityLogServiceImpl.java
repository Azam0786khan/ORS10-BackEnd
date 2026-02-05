package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.ActivityLogDAOInt;
import com.rays.dto.ActivityLogDTO;

@Service
@Transactional
public class ActivityLogServiceImpl
		extends BaseServiceImpl<ActivityLogDTO, ActivityLogDAOInt>
		implements ActivityLogServiceInt {
}
