package org.module.hr.service.impl;

import java.util.List;
import java.util.Map;

import org.module.hr.dao.TrsEmployeeDAO;
import org.module.hr.dao.TrsEmployeeEmergencyContactDAO;
import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsEmployeeEmergencyContact;
import org.module.hr.service.TransactionEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionEmployeeServiceImpl implements TransactionEmployeeService{
	
	@Autowired
	private TrsEmployeeDAO trsEmployeeDAO;
	
	@Autowired
	private TrsEmployeeEmergencyContactDAO trsEmployeeEmergencyContactDAO;
	
	/*---------- Employee Detail ----------*/
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
	
	/*---------- Employee Emergency Contact ----------*/

	@Override
	public void save(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact) {
		trsEmployeeEmergencyContactDAO.save(trsEmployeeEmergencyContact);
	}

	@Override
	public void update(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact) {
		trsEmployeeEmergencyContactDAO.update(trsEmployeeEmergencyContact);
	}

	@Override
	public void saveOrUpdate(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact) {
		trsEmployeeEmergencyContactDAO.saveOrUpdate(trsEmployeeEmergencyContact);
	}

	@Override
	public void delete(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact) {
		trsEmployeeEmergencyContactDAO.delete(trsEmployeeEmergencyContact);
	}

	@Override
	public List<TrsEmployeeEmergencyContact> getAllTrsEmployeeEmergencyContact() {
		return trsEmployeeEmergencyContactDAO.getAllTrsEmployeeEmergencyContact();
	}


	// setter DAO 
	public void setTrsEmployeeDAO(TrsEmployeeDAO trsEmployeeDAO) {
		this.trsEmployeeDAO = trsEmployeeDAO;
	}

	public void setTrsEmployeeEmergencyContactDAO(TrsEmployeeEmergencyContactDAO trsEmployeeEmergencyContactDAO) {
		this.trsEmployeeEmergencyContactDAO = trsEmployeeEmergencyContactDAO;
	}
	
	
	
}
