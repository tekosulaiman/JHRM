package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.TrsJobVacancy;

public interface TrsJobVacancyDAO {

	public void save(TrsJobVacancy trsJobVacancy);
    public void update(TrsJobVacancy trsJobVacancy);
    public void saveOrUpdate(TrsJobVacancy trsJobVacancy);
    public void delete(TrsJobVacancy trsJobVacancy);
    public List<TrsJobVacancy> getAllTrsJobVacancy();
    public TrsJobVacancy getTrsJobVacancyById(Integer id);
    public List<TrsJobVacancy> getByRequest(HashMap<String, Object> params);
}
