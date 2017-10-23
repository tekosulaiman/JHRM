package org.module.hr.dao.impl;

import java.util.List;
import java.util.Map;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsEmployeeLicenseDAO;
import org.module.hr.model.TrsEmployeeLicense;

@SuppressWarnings("unchecked")
public class TrsEmployeeLicenseDAOImpl extends BasisDAO<TrsEmployeeLicense> implements TrsEmployeeLicenseDAO {

	@Override
	public List<TrsEmployeeLicense> getAllTrsEmployeeLicense() {
		List<TrsEmployeeLicense> list = (List<TrsEmployeeLicense>) getHibernateTemplate().find("FROM TrsEmployeeLicense");
		return list;
	}

	@Override
	public List<TrsEmployeeLicense> getTrsEmployeeLicenseByTrsEmployeeLicenseRequestMap(
			Map<String, Object> requestMap) {
		return (List<TrsEmployeeLicense>) getHibernateTemplate().findByNamedParam("FROM TrsEmployeeLicense where idEmployee=:trsEmployee" , "trsEmployee", requestMap.get("trsEmployee"));
	}


}
