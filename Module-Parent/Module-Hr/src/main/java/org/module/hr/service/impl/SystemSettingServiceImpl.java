package org.module.hr.service.impl;

import java.util.Collection;
import java.util.List;

import org.module.hr.dao.SystemSettingDAO;
import org.module.hr.model.SystemSetting;
import org.module.hr.service.SystemSettingService;
import org.springframework.dao.DataAccessException;

public class SystemSettingServiceImpl implements SystemSettingService {

	private SystemSettingDAO systemSettingDAO;
	
	@Override
	public List<SystemSetting> getAllSettings() {
		return systemSettingDAO.getAllSettings();
	}

	@Override
	public void saveOrUpdateAll(Collection<SystemSetting> entities) throws DataAccessException {
		systemSettingDAO.saveOrUpdateAll(entities);
	}
	
	public void setSystemSettingDAO(SystemSettingDAO systemSettingDAO) {
		this.systemSettingDAO = systemSettingDAO;
	}

}
