package org.module.hr.service;

import java.util.List;

import org.module.hr.model.TrsEmployeeEmergencyContact;

public interface TrsEmployeeEmergencyContactService {
	public void save(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public void update(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public void saveOrUpdate(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public void delete(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public List<TrsEmployeeEmergencyContact> getAllTrsEmployeeEmergencyContact();
}
