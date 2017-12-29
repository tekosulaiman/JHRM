/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.module.hr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.module.hr.model.MstLeavePeriod;
import org.module.hr.model.MstLeaveType;
import org.module.hr.model.MstWorkWeek;

/**
 *
 * @author achmadsy
 */
public interface LeaveService {

    //leave Period
    public List<MstLeavePeriod> getAllLeavePeriod() throws Exception;
    public void saveAllLeavePeriod(List<MstLeavePeriod> listLeavePeriod) throws Exception;
    public void deleteLeavePeriodList(List<MstLeavePeriod> listLeavePeriod) throws Exception;
    
    //leave Type
    public int getCountMstLeaveTypeWithFilter(HashMap<String, Object> hashMap) throws Exception;
    public List<MstLeaveType> getMstLeaveTypePagingWithFilter(HashMap<String,Object> map) throws Exception;
    public void saveOrUpdateMstLeaveType(MstLeaveType mstLeaveType) throws Exception;
    public void deleteMstLeaveType(MstLeaveType mstLeaveType) throws Exception;
    public void deleteListMstLeaveType(List<MstLeaveType> mstLeaveTypes) throws Exception;
    
    //work week
    public List<MstWorkWeek> getAllWorkWeek() throws Exception;
    public MstWorkWeek getWorkWeekByDayName(String dayName) throws Exception;
    public void updateWorkWeek(MstWorkWeek mstWorkWeek) throws Exception;
    public void updateAllWorkWeek(Map<String, Integer> mstWorkWeek) throws Exception;
    
}
