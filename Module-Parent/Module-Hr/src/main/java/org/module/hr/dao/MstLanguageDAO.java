package org.module.hr.dao;

import java.util.List;

import org.module.hr.model.MstLanguage;

public interface MstLanguageDAO {
	public void save(MstLanguage mstLanguage);
    public void update(MstLanguage mstLanguage);
    public void saveOrUpdate(MstLanguage mstLanguage);
    public void delete(MstLanguage mstLanguage);
    public List<MstLanguage> getAllMstLanguage();
}
