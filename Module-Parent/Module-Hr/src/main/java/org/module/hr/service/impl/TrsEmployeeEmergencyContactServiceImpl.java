package org.module.hr.service.impl;

import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsEmployeeEmergencyContactDAO;
import org.module.hr.model.TrsEmployeeEmergencyContact;
import org.module.hr.service.TrsEmployeeEmergencyContactService;
import org.springframework.beans.factory.annotation.Autowired;

public class TrsEmployeeEmergencyContactServiceImpl extends BasisDAO<TrsEmployeeEmergencyContact> implements TrsEmployeeEmergencyContactService{
	
	@Autowired
	private TrsEmployeeEmergencyContactDAO trsEmployeeEmergencyContactDAO;

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

	public TrsEmployeeEmergencyContactDAO getTrsEmployeeEmergencyContactDAO() {
		return trsEmployeeEmergencyContactDAO;
	}

	public void setTrsEmployeeEmergencyContactDAO(TrsEmployeeEmergencyContactDAO trsEmployeeEmergencyContactDAO) {
		this.trsEmployeeEmergencyContactDAO = trsEmployeeEmergencyContactDAO;
	}

}
