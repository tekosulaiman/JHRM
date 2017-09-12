package org.module.hr.service;

import java.util.List;
import java.util.Map;

import org.module.hr.model.TrsEmployee;

public interface TrsEmployeeService {
	
	public void save(TrsEmployee trsEmployee);
	public void update(TrsEmployee trsEmployee);
	public void saveOrUpdate(TrsEmployee trsEmployee);
	public void delete(TrsEmployee trsEmployee);
	public List<TrsEmployee> getAllTrsEmployee();
	public List<TrsEmployee> getByTrsEmployeeRequestMap(Map<String, Object> requestMap);

}
