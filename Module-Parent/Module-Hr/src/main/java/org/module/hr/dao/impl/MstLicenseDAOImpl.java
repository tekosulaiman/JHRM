package org.module.hr.dao.impl;

import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstLicenseDAO;
import org.module.hr.model.MstLicense;

@SuppressWarnings("unchecked")
public class MstLicenseDAOImpl extends BasisDAO<MstLicense> implements MstLicenseDAO{

	@Override
	public List<MstLicense> getAllMstLicense() {
		List<MstLicense>list = (List<MstLicense>) getHibernateTemplate().find("FROM MstLicense");
		
		return list;
	}
}