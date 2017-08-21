package org.module.hr.dao.impl;

import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstEmployementStatusDAO;
import org.module.hr.model.MstEmployementStatus;

@SuppressWarnings("unchecked")
public class MstEmployementStatusDAOImpl extends BasisDAO<MstEmployementStatus> implements MstEmployementStatusDAO{

	@Override
	public List<MstEmployementStatus> getAllMstEmployementStatus() {
		List<MstEmployementStatus>list = (List<MstEmployementStatus>) getHibernateTemplate().find("FROM MstEmployementStatus");
		
		return list;
	}
}