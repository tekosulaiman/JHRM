package org.module.hr.dao;

import java.util.List;
import java.util.Map;

import org.module.hr.model.TrsEmployeeImmigration;

public interface TrsEmployeeImmigrationDAO {
	public void save(TrsEmployeeImmigration TrsEmployeeImmigration);
	public void update(TrsEmployeeImmigration TrsEmployeeImmigration);
	public void saveOrUpdate(TrsEmployeeImmigration TrsEmployeeImmigration);
	public void delete(TrsEmployeeImmigration TrsEmployeeImmigration);
	public List<TrsEmployeeImmigration> getAllTrsEmployeeImmigration();
	public List<TrsEmployeeImmigration> getTrsEmployeeImmigrationByTrsEmployeeImmigrationRequestMap (Map<String, Object> requestMap);

}
