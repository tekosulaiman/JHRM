package org.module.hr.dao;

import java.util.List;
import java.util.Map;

import org.module.hr.model.TrsEmployeeDependent;

public interface TrsEmployeeDependentDAO {
	public void save(TrsEmployeeDependent trsEmployeeDependent);
	public void update(TrsEmployeeDependent trsEmployeeDependent);
	public void saveOrUpdate(TrsEmployeeDependent trsEmployeeDependent);
	public void delete(TrsEmployeeDependent trsEmployeeDependent);
	public List<TrsEmployeeDependent> getAllTrsEmployeeDependent();
	public List<TrsEmployeeDependent> getTrsEmployeeDependentByTrsEmployeeDependentRequestMap(Map<String, Object> requestMap);
}
