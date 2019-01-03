package org.module.hr.dao;

import java.util.List;
import java.util.Map;

import org.module.hr.model.TrsEmployeeLicense;

public interface TrsEmployeeLicenseDAO {
	public void save(TrsEmployeeLicense trsEmployeeLicense);
	public void update(TrsEmployeeLicense trsEmployeeLicense);
	public void saveOrUpdate(TrsEmployeeLicense trsEmployeeLicense);
	public void delete(TrsEmployeeLicense TrsEmployeeLicense);
	public List<TrsEmployeeLicense> getAllTrsEmployeeLicense();
	public List<TrsEmployeeLicense> getTrsEmployeeLicenseByTrsEmployeeLicenseRequestMap(Map<String, Object> requestMap);
}