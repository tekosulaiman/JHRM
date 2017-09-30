package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsJobVacancyDAO;
import org.module.hr.model.TrsJobVacancy;

public class TrsJobVacancyDAOImpl extends BasisDAO<TrsJobVacancy> implements TrsJobVacancyDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<TrsJobVacancy> getAllTrsJobVacancy() {
		List<TrsJobVacancy> list = (List<TrsJobVacancy>) getHibernateTemplate().find("FROM TrsJobVacancy t");
		return list;
	}

	@Override
	public TrsJobVacancy getTrsJobVacancyById(Integer id) {
		return getHibernateTemplate().get(TrsJobVacancy.class, id);
	}
	
	@Override
	public List<TrsJobVacancy> getByRequest(HashMap<String, Object> params) {
		return getByRequestMap(params);
	}

}
