package org.module.hr.dao.impl;

import java.util.List;
import java.util.Map;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsEmployeeImmigrationDAO;
import org.module.hr.model.TrsEmployeeImmigration;

@SuppressWarnings("unchecked")
public class TrsEmployeeImmigrationDAOImpl extends BasisDAO<TrsEmployeeImmigration>  implements TrsEmployeeImmigrationDAO{

	@Override
	public List<TrsEmployeeImmigration> getAllTrsEmployeeImmigration() {
		List<TrsEmployeeImmigration> list = (List<TrsEmployeeImmigration>) getHibernateTemplate().find("FROM TrsEmployeeImmigration");
		return list;
	}

	@Override
	public List<TrsEmployeeImmigration> getTrsEmployeeImmigrationByTrsEmployeeImmigrationRequestMap(Map<String, Object> requestMap) {
		return (List<TrsEmployeeImmigration>) getHibernateTemplate().findByNamedParam("FROM TrsEmployeeImmigration where idEmployee=:trsEmployee" , "trsEmployee", requestMap.get("trsEmployee"));
	}
}
