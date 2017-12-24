/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.module.hr.service.impl;

import java.util.List;
import org.module.hr.dao.MstLeavePeriodDAO;
import org.module.hr.model.MstLeavePeriod;
import org.module.hr.service.LeaveService;

/**
 *
 * @author achmadsy
 */
public class LeaveServiceImpl implements LeaveService{
    
    private MstLeavePeriodDAO mstLeavePeriodDAO;

    @Override
    public List<MstLeavePeriod> getAllLeavePeriod() throws Exception {
        return mstLeavePeriodDAO.getAllLeavePeriod();
    }

    @Override
    public void saveAllLeavePeriod(List<MstLeavePeriod> listLeavePeriod) throws Exception {
        mstLeavePeriodDAO.saveOrUpdateAllLeavePeriod(listLeavePeriod);
    }

    @Override
    public void deleteLeavePeriodList(List<MstLeavePeriod> listLeavePeriod) throws Exception {
        mstLeavePeriodDAO.deleteLeavePeriodList(listLeavePeriod);
    }

    public MstLeavePeriodDAO getMstLeavePeriodDAO() {
        return mstLeavePeriodDAO;
    }

    public void setMstLeavePeriodDAO(MstLeavePeriodDAO mstLeavePeriodDAO) {
        this.mstLeavePeriodDAO = mstLeavePeriodDAO;
    }
    
    
    
}
