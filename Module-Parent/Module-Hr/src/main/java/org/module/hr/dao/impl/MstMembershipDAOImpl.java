package org.module.hr.dao.impl;

import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstMembershipDAO;
import org.module.hr.model.MstMembership;

@SuppressWarnings("unchecked")
public class MstMembershipDAOImpl extends BasisDAO<MstMembership> implements MstMembershipDAO{

	@Override
	public List<MstMembership> getAllMstMembership() {
		List<MstMembership>list = (List<MstMembership>) getHibernateTemplate().find("FROM MstMembership");
		
		return list;
	}
}