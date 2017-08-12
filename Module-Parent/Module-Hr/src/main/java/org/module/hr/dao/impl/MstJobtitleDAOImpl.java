package org.module.hr.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstJobtitleDAO;
import org.module.hr.model.MstJobtitle;

public class MstJobtitleDAOImpl extends BasisDAO<MstJobtitle> implements MstJobtitleDAO{

	@Override
	public List<MstJobtitle> getAllMstJobtitles() {
		List listJobtitle=getHibernateTemplate().find("from MstJobtitle jobtitle", null);		
		
		return listJobtitle;
	}

	

}
