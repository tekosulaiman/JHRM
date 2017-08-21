package org.module.hr.service.impl;

import java.util.List;

import org.module.hr.dao.MstPaygradeDAO;
import org.module.hr.model.MstPaygrade;
import org.module.hr.service.MstPaygradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MstPaygradeServiceImpl implements MstPaygradeService{

	@Autowired
    private MstPaygradeDAO mstPaygradeDAO;

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

	public MstPaygradeDAO getMstPaygradeDAO() {
		return mstPaygradeDAO;
	}

	public void setMstPaygradeDAO(MstPaygradeDAO mstPaygradeDAO) {
		this.mstPaygradeDAO = mstPaygradeDAO;
	}
}