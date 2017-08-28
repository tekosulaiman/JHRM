package org.module.hr.dao.impl;

import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstEducationDAO;
import org.module.hr.model.MstEducation;

@SuppressWarnings("unchecked")
public class MstEducationDAOImpl extends BasisDAO<MstEducation> implements MstEducationDAO{

	@Override
	public List<MstEducation> getAllMstEducation() {
		List<MstEducation>list = (List<MstEducation>) getHibernateTemplate().find("FROM MstEducation");
		
		return list;
	}
}