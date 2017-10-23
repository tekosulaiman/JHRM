package org.module.hr.dao.impl;

import java.util.List;
import java.util.Map;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsEmployeeEducationDAO;
import org.module.hr.model.TrsEmployeeEducation;

@SuppressWarnings("unchecked")
public class TrsEmployeeEducationDAOImpl extends BasisDAO<TrsEmployeeEducation> implements TrsEmployeeEducationDAO{

	@Override
	public List<TrsEmployeeEducation> getAllTrsEmployeeEducation() {
		List<TrsEmployeeEducation> list = (List<TrsEmployeeEducation>) getHibernateTemplate().find("FROM TrsEmployeeEducation");
		return list;
	}

	@Override
	public List<TrsEmployeeEducation> getTrsEmployeeEducationByTrsEmployeeEducationRequestMap(
			Map<String, Object> requestMap) {
		return (List<TrsEmployeeEducation>) getHibernateTemplate().findByNamedParam("FROM TrsEmployeeEducation where idEmployee=:trsEmployee" , "trsEmployee", requestMap.get("trsEmployee"));
	}

}
