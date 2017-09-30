package org.module.hr.dao.impl;

import java.util.List;
import java.util.Map;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsEmployeeDependentDAO;
import org.module.hr.model.TrsEmployeeDependent;

public class TrsEmployeeDependentDAOImpl extends BasisDAO<TrsEmployeeDependent> implements TrsEmployeeDependentDAO{

	@Override
	public List<TrsEmployeeDependent> getAllTrsEmployeeDependent() {
		List<TrsEmployeeDependent> list = (List<TrsEmployeeDependent>) getHibernateTemplate().find("FROM TrsEmployeeDependent");
		return list;
	}

	@Override
	public List<TrsEmployeeDependent> getTrsEmployeeDependentByTrsEmployeeDependentRequestMap(
			Map<String, Object> requestMap) {
		return (List<TrsEmployeeDependent>) getHibernateTemplate().findByNamedParam("FROM TrsEmployeeDependent where idEmployee=:trsEmployee" , "trsEmployee", requestMap.get("trsEmployee"));
	}



}
