package org.module.hr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.module.hr.model.MstHoliday;
import org.module.hr.model.MstLeavePeriod;
import org.module.hr.model.MstLeaveType;
import org.module.hr.model.MstWorkWeek;

public interface LeaveService {

	/*- Leave Period +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public List<MstLeavePeriod> getAllLeavePeriod() throws Exception;
    public void saveAllLeavePeriod(List<MstLeavePeriod> listLeavePeriod) throws Exception;
    public void deleteLeavePeriodList(List<MstLeavePeriod> listLeavePeriod) throws Exception;
    
    /*- Leave Type +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public int getCountMstLeaveTypeWithFilter(HashMap<String, Object> hashMap) throws Exception;
    public List<MstLeaveType> getMstLeaveTypePagingWithFilter(HashMap<String,Object> map) throws Exception;
    public void saveOrUpdateMstLeaveType(MstLeaveType mstLeaveType) throws Exception;
    public void deleteMstLeaveType(MstLeaveType mstLeaveType) throws Exception;
    public void deleteListMstLeaveType(List<MstLeaveType> mstLeaveTypes) throws Exception;
    
    /*- Work Week +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public List<MstWorkWeek> getAllWorkWeek() throws Exception;
    public MstWorkWeek getWorkWeekByDayName(String dayName) throws Exception;
    public void updateWorkWeek(MstWorkWeek mstWorkWeek) throws Exception;
    public void updateAllWorkWeek(Map<String, Integer> mstWorkWeek) throws Exception;
    
    /*- Holiday +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void save(MstHoliday mstHoliday);
    public void update(MstHoliday mstHoliday);
    public void saveOrUpdate(MstHoliday mstHoliday);
    public void delete(MstHoliday mstHoliday);
    public List<MstHoliday> getAllMstHolidays();
    public List<MstHoliday> getByRequestMap(HashMap<String, Object> hashMap);
    public List<MstHoliday> getMstHolidayPaging(HashMap<String, Object> hashMap);
    public int getCountAllMstHolidays();
    
    /*- Leave Entitlement +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    
    /*- Leave +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
}