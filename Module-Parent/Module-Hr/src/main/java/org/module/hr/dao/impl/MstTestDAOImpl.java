package org.module.hr.dao.impl;

import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstTestDAO;
import org.module.hr.model.MstTest;

@SuppressWarnings("unchecked")
public class MstTestDAOImpl extends BasisDAO<MstTest> implements MstTestDAO{
	
	@Override
	public List<MstTest> getAllMstTests() {
		List<MstTest>list = (List<MstTest>) getHibernateTemplate().find("FROM MstTest");
		
        return list;
	}
}