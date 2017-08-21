package org.module.hr.dao;

import java.util.List;

import org.module.hr.model.MstEmployementStatus;

public interface MstEmployementStatusDAO {
	public void save(MstEmployementStatus mstEmployementStatus);
    public void update(MstEmployementStatus mstEmployementStatus);
    public void saveOrUpdate(MstEmployementStatus mstEmployementStatus);
    public void delete(MstEmployementStatus mstEmployementStatus);
    public List<MstEmployementStatus> getAllMstEmployementStatus();
}
