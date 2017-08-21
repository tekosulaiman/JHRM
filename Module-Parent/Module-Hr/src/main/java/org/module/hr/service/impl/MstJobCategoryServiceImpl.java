package org.module.hr.service.impl;

import java.util.List;

import org.module.hr.dao.MstJobCategoryDAO;
import org.module.hr.model.MstJobCategory;
import org.module.hr.service.MstJobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MstJobCategoryServiceImpl implements MstJobCategoryService{

	@Autowired
    private MstJobCategoryDAO mstJobCategoryDAO;

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
	
	public MstJobCategoryDAO getMstJobCategoryDAO() {
		return mstJobCategoryDAO;
	}

	public void setMstJobCategoryDAO(MstJobCategoryDAO mstJobCategoryDAO) {
		this.mstJobCategoryDAO = mstJobCategoryDAO;
	}
}