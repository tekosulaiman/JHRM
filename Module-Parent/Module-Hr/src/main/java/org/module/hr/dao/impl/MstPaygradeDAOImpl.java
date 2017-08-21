package org.module.hr.dao.impl;

import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstPaygradeDAO;
import org.module.hr.model.MstPaygrade;

@SuppressWarnings("unchecked")
public class MstPaygradeDAOImpl extends BasisDAO<MstPaygrade> implements MstPaygradeDAO{

	@Override
	public List<MstPaygrade> getAllMstPaygrades() {
		List<MstPaygrade>list = (List<MstPaygrade>) getHibernateTemplate().find("FROM MstPaygrade");
		
		return list;
	}
}