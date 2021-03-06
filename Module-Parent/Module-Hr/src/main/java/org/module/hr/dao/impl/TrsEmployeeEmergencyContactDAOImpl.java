package org.module.hr.dao.impl;

import java.util.List;
import java.util.Map;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsEmployeeEmergencyContactDAO;
import org.module.hr.model.TrsEmployeeEmergencyContact;

public class TrsEmployeeEmergencyContactDAOImpl extends BasisDAO<TrsEmployeeEmergencyContact>
		implements TrsEmployeeEmergencyContactDAO {

	@Override
	public List<TrsEmployeeEmergencyContact> getAllTrsEmployeeEmergencyContact() {
		List<TrsEmployeeEmergencyContact> list = (List<TrsEmployeeEmergencyContact>) getHibernateTemplate().find("FROM TrsEmployeeEmergencyContact");
		return list;
	}

	@Override
	public List<TrsEmployeeEmergencyContact> getTrsEmployeeEmergencyContactByTrsEmployeeEmergencyContactRequestMap (Map<String, Object> requestMap) {
		return (List<TrsEmployeeEmergencyContact>) getHibernateTemplate().findByNamedParam("FROM TrsEmployeeEmergencyContact where idEmployee=:trsEmployee" , "trsEmployee", requestMap.get("trsEmployee"));
	}

}
