package org.module.hr.dao.impl;

import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.SystemSettingDAO;
import org.module.hr.model.SystemSetting;

@SuppressWarnings("unchecked")
public class SystemSettingDAOImpl extends BasisDAO<SystemSetting> implements SystemSettingDAO {
	
	@Override
	public List<SystemSetting> getAllSettings() {
		List<SystemSetting> list = (List<SystemSetting>) getHibernateTemplate().find("FROM SystemSetting");
		return list;
	}

}
