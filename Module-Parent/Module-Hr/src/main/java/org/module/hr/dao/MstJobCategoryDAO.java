package org.module.hr.dao;

import java.util.List;

import org.module.hr.model.MstJobCategory;

public interface MstJobCategoryDAO {
	public void save(MstJobCategory mstJobCategory);
    public void update(MstJobCategory mstJobCategory);
    public void saveOrUpdate(MstJobCategory mstJobCategory);
    public void delete(MstJobCategory mstJobCategory);
    public List<MstJobCategory> getAllMstJobCategories();
}
