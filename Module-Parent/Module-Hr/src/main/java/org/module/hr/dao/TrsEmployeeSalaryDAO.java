package org.module.hr.dao;

import java.util.List;
import java.util.Map;

import org.module.hr.model.TrsEmployeeSalary;

public interface TrsEmployeeSalaryDAO {
	public void save(TrsEmployeeSalary trsEmployeeSalary);
	public void update(TrsEmployeeSalary trsEmployeeSalary);
	public void saveOrUpdate(TrsEmployeeSalary trsEmployeeSalary);
	public void delete(TrsEmployeeSalary trsEmployeeSalary);
	public List<TrsEmployeeSalary> getAllTrsEmployeeSalary();
	public List<TrsEmployeeSalary> getTrsEmployeeSalaryByTrsEmployeeSalaryRequestMap(Map<String, Object> requestMap);
}
