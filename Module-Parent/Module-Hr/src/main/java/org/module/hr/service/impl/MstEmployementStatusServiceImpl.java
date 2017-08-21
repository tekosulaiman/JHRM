package org.module.hr.service.impl;

import java.util.List;

import org.module.hr.dao.MstEmployementStatusDAO;
import org.module.hr.model.MstEmployementStatus;
import org.module.hr.service.MstEmployementStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MstEmployementStatusServiceImpl implements MstEmployementStatusService{

	@Autowired
    private MstEmployementStatusDAO mstEmployementStatusDAO;

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
	
	public MstEmployementStatusDAO getMstEmployementStatusDAO() {
		return mstEmployementStatusDAO;
	}

	public void setMstEmployementStatusDAO(MstEmployementStatusDAO mstEmployementStatusDAO) {
		this.mstEmployementStatusDAO = mstEmployementStatusDAO;
	}
}