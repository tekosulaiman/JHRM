package org.module.hr.dao;

import java.util.List;
import java.util.Map;

import org.module.hr.model.TrsEmployeeEmergencyContact;

public interface TrsEmployeeEmergencyContactDAO {
	public void save(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public void update(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public void saveOrUpdate(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public void delete(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public List<TrsEmployeeEmergencyContact> getAllTrsEmployeeEmergencyContact();
	public List<TrsEmployeeEmergencyContact> getTrsEmployeeEmergencyContactByTrsEmployeeEmergencyContactRequestMap (Map<String, Object> requestMap);
}
