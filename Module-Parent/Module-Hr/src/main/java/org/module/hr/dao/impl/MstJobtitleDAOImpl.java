package org.module.hr.dao.impl;

import java.util.List;

import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstJobtitleDAO;
import org.module.hr.model.MstJobtitle;

@SuppressWarnings("unchecked")
public class MstJobtitleDAOImpl extends BasisDAO<MstJobtitle> implements MstJobtitleDAO{

	@Override
	public List<MstJobtitle> getAllMstJobtitles() {
		List<MstJobtitle>list = (List<MstJobtitle>) getHibernateTemplate().find("FROM MstJobtitle");
		
		return list;
	}
}