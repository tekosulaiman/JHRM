package org.module.hr.service.impl;

import java.util.List;

import org.module.hr.dao.MstJobtitleDAO;
import org.module.hr.model.MstJobtitle;
import org.module.hr.service.MstJobtitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MstJobtitleServiceImpl implements MstJobtitleService{

	@Autowired
    private MstJobtitleDAO mstJobtitleDAO;

	@Override
	public void save(MstJobtitle mstJobtitle) {
		mstJobtitleDAO.save(mstJobtitle);
	}

	@Override
	public void update(MstJobtitle mstJobtitle) {
		mstJobtitleDAO.update(mstJobtitle);
	}

	@Override
	public void saveOrUpdate(MstJobtitle mstJobtitle) {
		mstJobtitleDAO.saveOrUpdate(mstJobtitle);
	}

	@Override
	public void delete(MstJobtitle mstJobtitle) {
		mstJobtitleDAO.delete(mstJobtitle);
	}

	@Override
	public List<MstJobtitle> getAllMstJobtitles() {
		return mstJobtitleDAO.getAllMstJobtitles();
	}
	
	public MstJobtitleDAO getMstJobtitleDAO() {
		return mstJobtitleDAO;
	}

	public void setMstJobtitleDAO(MstJobtitleDAO mstJobtitleDAO) {
		this.mstJobtitleDAO = mstJobtitleDAO;
	}
}