package org.module.hr.dao.impl;

import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstLanguageDAO;
import org.module.hr.model.MstLanguage;

@SuppressWarnings("unchecked")
public class MstLanguageDAOImpl extends BasisDAO<MstLanguage> implements MstLanguageDAO{

	@Override
	public List<MstLanguage> getAllMstLanguage() {
		List<MstLanguage>list = (List<MstLanguage>) getHibernateTemplate().find("FROM MstLanguage");
		
		return list;
	}
}