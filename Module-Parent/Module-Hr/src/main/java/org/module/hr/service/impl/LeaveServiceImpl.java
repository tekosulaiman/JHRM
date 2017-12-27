/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.module.hr.service.impl;

import java.util.HashMap;
import java.util.List;
import org.module.hr.dao.MstLeavePeriodDAO;
import org.module.hr.model.MstLeavePeriod;
import org.module.hr.model.MstLeaveType;
import org.module.hr.service.LeaveService;
import org.module.hr.dao.MstLeaveTypeDAO;

/**
 *
 * @author achmadsy
 */
public class LeaveServiceImpl implements LeaveService{
    
    private MstLeavePeriodDAO mstLeavePeriodDAO;
    private MstLeaveTypeDAO mstLeaveTypeDAO;

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

    @Override
    public int getCountMstLeaveTypeWithFilter(HashMap<String, Object> hashMap) throws Exception {
        return mstLeaveTypeDAO.getCountMstLeaveTypeWithFilter(hashMap);
    }

    @Override
    public List<MstLeaveType> getMstLeaveTypePagingWithFilter(HashMap<String, Object> map) throws Exception {
        return mstLeaveTypeDAO.getMstLeaveTypePagingWithFilter(map);
    }

    @Override
    public void saveOrUpdateMstLeaveType(MstLeaveType mstLeaveType) throws Exception {
        mstLeaveTypeDAO.saveOrUpdateLeaveType(mstLeaveType);
    }

    @Override
    public void deleteMstLeaveType(MstLeaveType mstLeaveType) throws Exception {
        mstLeaveTypeDAO.deleteLeaveType(mstLeaveType);
    }

    @Override
    public void deleteListMstLeaveType(List<MstLeaveType> mstLeaveTypes) throws Exception {
        mstLeaveTypeDAO.deleteLeaveTypeList(mstLeaveTypes);
    }

    public MstLeavePeriodDAO getMstLeavePeriodDAO() {
        return mstLeavePeriodDAO;
    }

    public void setMstLeavePeriodDAO(MstLeavePeriodDAO mstLeavePeriodDAO) {
        this.mstLeavePeriodDAO = mstLeavePeriodDAO;
    }

    public MstLeaveTypeDAO getMstLeaveTypeDAO() {
        return mstLeaveTypeDAO;
    }

    public void setMstLeaveTypeDAO(MstLeaveTypeDAO mstLeaveTypeDAO) {
        this.mstLeaveTypeDAO = mstLeaveTypeDAO;
    }

    
    
    
}
