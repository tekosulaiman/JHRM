package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstGeneralInformationDAO;
import org.module.hr.model.MstGeneralInformation;
import org.springframework.dao.support.DataAccessUtils;

@SuppressWarnings("unchecked")
public class MstGeneralInformationDAOImpl extends BasisDAO<MstGeneralInformation> implements MstGeneralInformationDAO {

	@Override
	public List<MstGeneralInformation> getAllMstGeneralInformations() {
		List<MstGeneralInformation> list = (List<MstGeneralInformation>) getHibernateTemplate().find("FROM MstGeneralInformation");
		return list;
	}

	@Override
	public List<MstGeneralInformation> getMstGeneralInformationPaging(HashMap<String, Object> hashMap) {
		List<MstGeneralInformation>list = (List<MstGeneralInformation>) getHibernateTemplate().findByExample(new MstGeneralInformation(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public int getCountAllMstGeneralInformations() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("SELECT COUNT(*) FROM MstGeneralInformation"));
	}
}