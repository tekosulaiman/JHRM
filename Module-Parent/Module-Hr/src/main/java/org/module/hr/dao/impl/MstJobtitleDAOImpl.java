package org.module.hr.dao.impl;

import java.util.HashMap;
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
	
	@Override
	public List<MstJobtitle> getByRequestMstJobtitles(HashMap<String, Object> hashMap) {
		List<MstJobtitle>list = (List<MstJobtitle>) getHibernateTemplate().findByExample(new MstJobtitle(), (Integer)hashMap.get("firstResult"), (Integer)hashMap.get("maxResults"));
		return list;
	}

	@Override
	public Long getCountMsJobtitles() {
		Long count = (Long) getHibernateTemplate().find("select count(*) from MstJobtitle").get(0);
		return count;
	}
}