package org.module.hr.service;

import java.util.List;

import org.module.hr.model.MstSetting;

public interface AdministrationService {
	
	public List<MstSetting> getAllSettings();
	public void saveAll(List<MstSetting> settings) throws Exception;
}
