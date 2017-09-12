package org.module.hr.service;

import java.util.List;
import java.util.Map;

import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsEmployeeEmergencyContact;

public interface TransactionEmployeeService {
	
	// employee detail
	public void save(TrsEmployee trsEmployee);
	public void update(TrsEmployee trsEmployee);
	public void saveOrUpdate(TrsEmployee trsEmployee);
	public void delete(TrsEmployee trsEmployee);
	public List<TrsEmployee> getAllTrsEmployee();
	public List<TrsEmployee> getByTrsEmployeeRequestMap(Map<String, Object> requestMap);
	
	// emergency contact
	public void save(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public void update(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public void saveOrUpdate(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public void delete(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public List<TrsEmployeeEmergencyContact> getAllTrsEmployeeEmergencyContact();

}
