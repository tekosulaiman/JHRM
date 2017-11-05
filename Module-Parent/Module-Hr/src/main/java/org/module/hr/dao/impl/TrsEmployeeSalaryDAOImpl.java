package org.module.hr.dao.impl;

import java.util.List;
import java.util.Map;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.TrsEmployeeSalaryDAO;
import org.module.hr.model.TrsEmployeeEducation;
import org.module.hr.model.TrsEmployeeSalary;

@SuppressWarnings("unchecked")
public class TrsEmployeeSalaryDAOImpl extends BasisDAO<TrsEmployeeSalary> implements TrsEmployeeSalaryDAO{

	@Override
	public List<TrsEmployeeSalary> getAllTrsEmployeeSalary() {
		List<TrsEmployeeSalary> list = (List<TrsEmployeeSalary>) getHibernateTemplate().find("FROM TrsEmployeeSalary");
		return list;
	}

	@Override
	public List<TrsEmployeeSalary> getTrsEmployeeSalaryByTrsEmployeeSalaryRequestMap(Map<String, Object> requestMap) {
		return (List<TrsEmployeeSalary>) getHibernateTemplate().findByNamedParam("FROM TrsEmployeeSalary where idEmployee=:trsEmployee" , "trsEmployee", requestMap.get("trsEmployee"));
	}

}
