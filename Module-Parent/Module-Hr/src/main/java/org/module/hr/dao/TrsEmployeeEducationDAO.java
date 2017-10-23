package org.module.hr.dao;

import java.util.List;
import java.util.Map;

import org.module.hr.model.TrsEmployeeEducation;


public interface TrsEmployeeEducationDAO {
	public void save(TrsEmployeeEducation trsEmployeeEducation);
	public void update(TrsEmployeeEducation trsEmployeeEducation);
	public void saveOrUpdate(TrsEmployeeEducation trsEmployeeEducation);
	public void delete(TrsEmployeeEducation trsEmployeeEducation);
	public List<TrsEmployeeEducation> getAllTrsEmployeeEducation();
	public List<TrsEmployeeEducation> getTrsEmployeeEducationByTrsEmployeeEducationRequestMap(Map<String, Object> requestMap);
}
