package org.module.hr.dao.impl;

import java.util.List;
import java.util.Map;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsEmployeeSkillDAO;
import org.module.hr.model.TrsEmployeeSkill;

@SuppressWarnings("unchecked")
public class TrsEmployeeSkillDAOImpl extends BasisDAO<TrsEmployeeSkill> implements TrsEmployeeSkillDAO{
	
	@Override
	public List<TrsEmployeeSkill> getAllTrsEmployeeSkill() {
		List<TrsEmployeeSkill> list = (List<TrsEmployeeSkill>) getHibernateTemplate().find("FROM TrsEmployeeSkill");
		return list;
	}

	@Override
	public List<TrsEmployeeSkill> getTrsEmployeeSkillByTrsEmployeeSkillRequestMap(Map<String, Object> requestMap) {
		return (List<TrsEmployeeSkill>) getHibernateTemplate().findByNamedParam("FROM TrsEmployeeSkill where idEmployee=:trsEmployee" , "trsEmployee", requestMap.get("trsEmployee"));
	}

}
