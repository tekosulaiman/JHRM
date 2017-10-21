package org.module.hr.dao;

import java.util.Collection;
import java.util.List;

import org.module.hr.model.SystemSetting;
import org.springframework.dao.DataAccessException;

public interface SystemSettingDAO {

	/**
	 * 
	 * @return
	 */
	public List<SystemSetting> getAllSettings();
	
	/**
	 * 
	 */
	public void saveOrUpdateAll(Collection<SystemSetting> entities) throws DataAccessException ;

}
