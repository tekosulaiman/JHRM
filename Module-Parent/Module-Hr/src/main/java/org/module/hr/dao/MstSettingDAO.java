package org.module.hr.dao;

import java.util.List;

import org.module.hr.model.MstSetting;
import org.springframework.dao.DataAccessException;

public interface MstSettingDAO {
	
	public List<MstSetting> getAllMstSetting();
	public void saveOrUpdateAll(List<MstSetting> settings) throws DataAccessException ;
}