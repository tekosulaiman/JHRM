package org.module.hr.service;

import java.util.List;
import java.util.Map;

import org.module.hr.model.MstTest;

public interface MstTestService {
	public void save(MstTest mstTest);
    public void update(MstTest mstTest);
    public void saveOrUpdate(MstTest mstTest);
    public void delete(MstTest mstTest);
    public List<MstTest> getAllMstTests();
}