package org.module.hr.service.impl;

import java.util.List;

import org.module.hr.dao.MstSettingDAO;
import org.module.hr.model.MstSetting;
import org.module.hr.service.AdministrationService;

public class AdministrationServiceImpl implements AdministrationService {
	
	private MstSettingDAO mstSettingDAO;
	
	@Override
	public List<MstSetting> getAllSettings() { 
		return mstSettingDAO.getAllMstSetting();
	}

	@Override
	public void saveAll(List<MstSetting> settings) throws Exception {
		mstSettingDAO.saveOrUpdateAll(settings);
	}
	
	
	/* ----------- GETTER - SETTER -----------*/
	public void setMstSettingDAO(MstSettingDAO mstSettingDAO) {
		this.mstSettingDAO = mstSettingDAO;
	}
}