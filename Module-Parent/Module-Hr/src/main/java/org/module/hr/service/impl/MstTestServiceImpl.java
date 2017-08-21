package org.module.hr.service.impl;

import java.util.List;

import org.module.hr.dao.MstTestDAO;
import org.module.hr.model.MstTest;
import org.module.hr.service.MstTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MstTestServiceImpl implements MstTestService{

	@Autowired
    private MstTestDAO mstTestDAO;

	@Override
	public void save(MstTest mstTest) {
		mstTestDAO.save(mstTest);
	}

	@Override
	public void update(MstTest mstTest) {
		mstTestDAO.update(mstTest);
	}

	@Override
	public void saveOrUpdate(MstTest mstTest) {
		mstTestDAO.saveOrUpdate(mstTest);
	}

	@Override
	public void delete(MstTest mstTest) {
		mstTestDAO.delete(mstTest);
	}

	@Override
	public List<MstTest> getAllMstTests() {
		return mstTestDAO.getAllMstTests();
	}
	
	public MstTestDAO getMstTestDAO() {
		return mstTestDAO;
	}

	public void setMstTestDAO(MstTestDAO mstTestDAO) {
		this.mstTestDAO = mstTestDAO;
	}
}