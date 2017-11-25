package org.module.hr.service.impl;

import java.util.HashMap;
import java.util.List;

import org.module.hr.dao.MstEmployementStatusDAO;
import org.module.hr.dao.MstJobCategoryDAO;
import org.module.hr.dao.MstJobtitleDAO;
import org.module.hr.dao.MstPaygradeDAO;
import org.module.hr.model.MstEmployementStatus;
import org.module.hr.model.MstJobCategory;
import org.module.hr.model.MstJobtitle;
import org.module.hr.model.MstPaygrade;
import org.module.hr.service.MasterJobService;

public class MasterJobServiceImpl implements MasterJobService{

	private MstJobtitleDAO mstJobtitleDAO;
	private MstPaygradeDAO mstPaygradeDAO;
	private MstEmployementStatusDAO mstEmployementStatusDAO;
	private MstJobCategoryDAO mstJobCategoryDAO;
	
	/* ------------ JobTitle ----------*/
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
	
	@Override
	public List<MstJobtitle> getByRequestMstJobtitles(HashMap<String, Object> hashMap) {
		return mstJobtitleDAO.getByRequestMstJobtitles(hashMap);
	}
	
	public void setMstJobtitleDAO(MstJobtitleDAO mstJobtitleDAO) {
		this.mstJobtitleDAO = mstJobtitleDAO;
	}
	
	@Override
	public Long getCountMsJobtitles() {
		return mstJobtitleDAO.getCountMsJobtitles();
	}
	
	/* ----------- PayGrade -----------*/
	@Override
	public void save(MstPaygrade mstPaygrade) {
		mstPaygradeDAO.save(mstPaygrade);
	}
	
	@Override
	public void update(MstPaygrade mstPaygrade) {
		mstPaygradeDAO.update(mstPaygrade);
	}
	
	@Override
	public void saveOrUpdate(MstPaygrade mstPaygrade) {
		mstPaygradeDAO.saveOrUpdate(mstPaygrade);
	}
	
	@Override
	public void delete(MstPaygrade mstPaygrade) {
		mstPaygradeDAO.delete(mstPaygrade);
	}
	
	@Override
	public List<MstPaygrade> getAllMstPaygrades() {
		return mstPaygradeDAO.getAllMstPaygrades();
	}
	
	public void setMstPaygradeDAO(MstPaygradeDAO mstPaygradeDAO) {
		this.mstPaygradeDAO = mstPaygradeDAO;
	}
	
	/* ------- Employment Status --------*/
	@Override
	public void save(MstEmployementStatus mstEmployementStatus) {
		mstEmployementStatusDAO.save(mstEmployementStatus);
	}
	
	@Override
	public void update(MstEmployementStatus mstEmployementStatus) {
		mstEmployementStatusDAO.update(mstEmployementStatus);
	}
	
	@Override
	public void saveOrUpdate(MstEmployementStatus mstEmployementStatus) {
		mstEmployementStatusDAO.saveOrUpdate(mstEmployementStatus);
	}
	
	@Override
	public void delete(MstEmployementStatus mstEmployementStatus) {
		mstEmployementStatusDAO.delete(mstEmployementStatus);
	}
	
	@Override
	public List<MstEmployementStatus> getAllMstEmployementStatus() {
		return mstEmployementStatusDAO.getAllMstEmployementStatus();
	}
	
	public void setMstEmployementStatusDAO(MstEmployementStatusDAO mstEmployementStatusDAO) {
		this.mstEmployementStatusDAO = mstEmployementStatusDAO;
	}
	
	/* ---------- Job Category -----------*/
	@Override
	public void save(MstJobCategory mstJobCategory) {
		mstJobCategoryDAO.save(mstJobCategory);
	}
	
	@Override
	public void update(MstJobCategory mstJobCategory) {
		mstJobCategoryDAO.update(mstJobCategory);
	}
	
	@Override
	public void saveOrUpdate(MstJobCategory mstJobCategory) {
		mstJobCategoryDAO.saveOrUpdate(mstJobCategory);
	}
	
	@Override
	public void delete(MstJobCategory mstJobCategory) {
		mstJobCategoryDAO.delete(mstJobCategory);
	}
	
	@Override
	public List<MstJobCategory> getAllMstJobCategories() {
		return mstJobCategoryDAO.getAllMstJobCategories();
	}
	
	public void setMstJobCategoryDAO(MstJobCategoryDAO mstJobCategoryDAO) {
		this.mstJobCategoryDAO = mstJobCategoryDAO;
	}
}