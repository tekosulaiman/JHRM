package org.module.hr.dao;

import java.util.List;

import org.module.hr.model.MstEducation;

public interface MstEducationDAO {
	public void save(MstEducation mstEducation);
    public void update(MstEducation mstEducation);
    public void saveOrUpdate(MstEducation mstEducation);
    public void delete(MstEducation mstEducation);
    public List<MstEducation> getAllMstEducation();
}
