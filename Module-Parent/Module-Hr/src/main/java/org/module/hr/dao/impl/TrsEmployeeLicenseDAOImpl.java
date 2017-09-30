package org.module.hr.dao.impl;

import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsEmployeeLicenseDAO;
import org.module.hr.model.TrsEmployeeLicense;

public class TrsEmployeeLicenseDAOImpl extends BasisDAO<TrsEmployeeLicense> implements TrsEmployeeLicenseDAO {

	@Override
	public List<TrsEmployeeLicense> getAllTrsEmployeeLicense() {
		List<TrsEmployeeLicense> list = (List<TrsEmployeeLicense>) getHibernateTemplate().find("FROM TrsEmployeeLicense");
		return list;
	}


}
