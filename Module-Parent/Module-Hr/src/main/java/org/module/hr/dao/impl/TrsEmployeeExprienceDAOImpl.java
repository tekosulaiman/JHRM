package org.module.hr.dao.impl;

import java.util.List;
import java.util.Map;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsEmployeeExprienceDAO;
import org.module.hr.model.TrsEmployeeExprience;

@SuppressWarnings("unchecked")
public class TrsEmployeeExprienceDAOImpl extends BasisDAO<TrsEmployeeExprience> implements TrsEmployeeExprienceDAO{

	@Override
	public List<TrsEmployeeExprience> getAllTrsEmployeeExprience() {
		List<TrsEmployeeExprience> list = (List<TrsEmployeeExprience>) getHibernateTemplate().find("FROM TrsEmployeeExprience");
		return list;
	}

	@Override
	public List<TrsEmployeeExprience> getTrsEmployeeExprienceByTrsEmployeeExprienceRequestMap(
			Map<String, Object> requestMap) {
		return (List<TrsEmployeeExprience>) getHibernateTemplate().findByNamedParam("FROM TrsEmployeeExprience where idEmployee=:trsEmployee" , "trsEmployee", requestMap.get("trsEmployee"));
	}

}
