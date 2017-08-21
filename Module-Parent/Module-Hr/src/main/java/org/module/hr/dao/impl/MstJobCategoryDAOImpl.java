package org.module.hr.dao.impl;

import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstJobCategoryDAO;
import org.module.hr.model.MstJobCategory;

@SuppressWarnings("unchecked")
public class MstJobCategoryDAOImpl extends BasisDAO<MstJobCategory> implements MstJobCategoryDAO{

	@Override
	public List<MstJobCategory> getAllMstJobCategories() {
		List<MstJobCategory>list = (List<MstJobCategory>) getHibernateTemplate().find("FROM MstJobCategory");
		
		return list;
	}
}