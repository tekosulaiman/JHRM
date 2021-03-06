package org.module.hr.dao.impl;

import java.util.List;
import java.util.Map;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsEmployeeDAO;
import org.module.hr.model.TrsEmployee;

@SuppressWarnings("unchecked")
public class TrsEmployeeDAOImpl extends BasisDAO<TrsEmployee> implements TrsEmployeeDAO{

	@Override
	public List<TrsEmployee> getAllTrsEmployee() {
		List<TrsEmployee> list = (List<TrsEmployee>) getHibernateTemplate().find("FROM TrsEmployee");
		return list;
	}

	@Override
	public List<TrsEmployee> getByMstTestRequestMap(Map<String, Object> requestMap) {
		final StringBuffer queryString = new StringBuffer();
		
		queryString.append("FROM TrsEmployee AS trsEmployee");
		
		List<TrsEmployee> list = (List<TrsEmployee>) getHibernateTemplate().find(queryString.toString());
		return list;
	}
	

}
