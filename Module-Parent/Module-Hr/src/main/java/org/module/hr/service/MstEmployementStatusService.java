package org.module.hr.service;

import java.util.List;

import org.module.hr.model.MstEmployementStatus;

public interface MstEmployementStatusService {
	public void save(MstEmployementStatus mstEmployementStatus);
    public void update(MstEmployementStatus mstEmployementStatus);
    public void saveOrUpdate(MstEmployementStatus mstEmployementStatus);
    public void delete(MstEmployementStatus mstEmployementStatus);
    public List<MstEmployementStatus> getAllMstEmployementStatus();
}
