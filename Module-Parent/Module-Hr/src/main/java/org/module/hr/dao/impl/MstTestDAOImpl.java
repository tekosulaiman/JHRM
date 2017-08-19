package org.module.hr.dao.impl;

import java.util.List;
import java.util.Map;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstTestDAO;
import org.module.hr.model.MstTest;

@SuppressWarnings("unchecked")
public class MstTestDAOImpl extends BasisDAO<MstTest> implements MstTestDAO{
	
	@Override
	public List<MstTest> getAllMstTests() {
		//List<MstTest>list = (List<MstTest>) getHibernateTemplate().loadAll(MstTest.class);
		List<MstTest>list = (List<MstTest>) getHibernateTemplate().find("FROM MstTest");
		//List<MstTest>list = (List<MstTest>) getHibernateTemplate().findByNamedQuery("MstTest.findAll");
		
		/*Hibernate Criteria
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MstTest.class);
		List<MstTest>list = (List<MstTest>) getHibernateTemplate().findByCriteria(detachedCriteria).listIterator();*/
        
        return list;
	}

	@Override
	public List<MstTest> getByMstTestRequestMap(Map<String, Object> requestMap) {
		final StringBuffer queryString = new StringBuffer();
		
		queryString.append("FROM MstTest AS test");
		
		List <MstTest>list = (List<MstTest>) getHibernateTemplate().find(queryString.toString());
		return list;
	}
}