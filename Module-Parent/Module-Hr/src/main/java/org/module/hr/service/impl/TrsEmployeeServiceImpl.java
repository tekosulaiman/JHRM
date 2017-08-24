package org.module.hr.service.impl;

import java.util.List;
import java.util.Map;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsEmployeeDAO;
import org.module.hr.model.TrsEmployee;
import org.module.hr.service.TrsEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrsEmployeeServiceImpl extends BasisDAO<TrsEmployee> implements TrsEmployeeService{
	
	@Autowired
	private TrsEmployeeDAO trsEmployeeDAO;
	
	@Override
	public void save(TrsEmployee trsEmployee) {
		trsEmployeeDAO.save(trsEmployee);
	}
	
	@Override
	public void update(TrsEmployee trsEmployee) {
		trsEmployeeDAO.update(trsEmployee);
	}
	
	@Override
	public void saveOrUpdate(TrsEmployee trsEmployee) {
		trsEmployeeDAO.saveOrUpdate(trsEmployee);
	}
	
	@Override
	public void delete(TrsEmployee trsEmployee) {
		trsEmployeeDAO.delete(trsEmployee);
	}

	@Override
	public List<TrsEmployee> getAllTrsEmployee() {
		return trsEmployeeDAO.getAllTrsEmployee();
	}

	@Override
	public List<TrsEmployee> getByTrsEmployeeRequestMap(Map<String, Object> requestMap) {
		return trsEmployeeDAO.getByMstTestRequestMap(requestMap);
	}

	public TrsEmployeeDAO getTrsEmployeeDAO() {
		return trsEmployeeDAO;
	}

	public void setTrsEmployeeDAO(TrsEmployeeDAO trsEmployeeDAO) {
		this.trsEmployeeDAO = trsEmployeeDAO;
	}
	
}
