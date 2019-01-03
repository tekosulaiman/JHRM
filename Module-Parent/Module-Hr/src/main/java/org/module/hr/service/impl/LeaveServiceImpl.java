package org.module.hr.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.module.hr.dao.MstHolidayDAO;
import org.module.hr.dao.MstLeavePeriodDAO;
import org.module.hr.model.MstHoliday;
import org.module.hr.model.MstLeavePeriod;
import org.module.hr.model.MstLeaveType;
import org.module.hr.service.LeaveService;
import org.module.hr.dao.MstLeaveTypeDAO;
import org.module.hr.dao.MstWorkWeekDAO;
import org.module.hr.model.MstWorkWeek;

public class LeaveServiceImpl implements LeaveService {
    private MstLeavePeriodDAO mstLeavePeriodDAO;
    private MstLeaveTypeDAO mstLeaveTypeDAO;
    private MstWorkWeekDAO mstWorkWeekDAO;
    private MstHolidayDAO mstHolidayDAO;

    @Override
    public List<MstLeavePeriod> getAllLeavePeriod() throws Exception {
        return mstLeavePeriodDAO.getAll();
    }

    @Override
    public void saveAllLeavePeriod(List<MstLeavePeriod> listLeavePeriod) throws Exception {
        mstLeavePeriodDAO.saveOrUpdateList(listLeavePeriod);
    }

    @Override
    public void deleteLeavePeriodList(List<MstLeavePeriod> listLeavePeriod) throws Exception {
        mstLeavePeriodDAO.deleteList(listLeavePeriod);
    }

    @Override
    public int getCountMstLeaveTypeWithFilter(HashMap<String, Object> hashMap) throws Exception {
        return mstLeaveTypeDAO.getCountWithFilter(hashMap);
    }

    @Override
    public List<MstLeaveType> getMstLeaveTypePagingWithFilter(HashMap<String, Object> map) throws Exception {
        return mstLeaveTypeDAO.getPagingWithFilter(map);
    }

    @Override
    public void saveOrUpdateMstLeaveType(MstLeaveType mstLeaveType) throws Exception {
        mstLeaveTypeDAO.saveOrUpdate(mstLeaveType);
    }

    @Override
    public void deleteMstLeaveType(MstLeaveType mstLeaveType) throws Exception {
        mstLeaveTypeDAO.delete(mstLeaveType);
    }

    @Override
    public void deleteListMstLeaveType(List<MstLeaveType> mstLeaveTypes) throws Exception {
        mstLeaveTypeDAO.deleteList(mstLeaveTypes);
    }

    @Override
    public List<MstWorkWeek> getAllWorkWeek() throws Exception {
        return mstWorkWeekDAO.getAll();
    }

    @Override
    public MstWorkWeek getWorkWeekByDayName(String dayName) throws Exception {
        return mstWorkWeekDAO.getByDayName(dayName);
    }

    @Override
    public void updateWorkWeek(MstWorkWeek mstWorkWeek) throws Exception {
        mstWorkWeekDAO.update(mstWorkWeek);
    }

    @Override
    public void updateAllWorkWeek(Map<String, Integer> mstWorkWeek) throws Exception {
        for (String key : mstWorkWeek.keySet()) {
            MstWorkWeek obj = getWorkWeekByDayName(key);
            obj.setDayType(mstWorkWeek.get(key));
            mstWorkWeekDAO.update(obj);
        }
    }
    
    @Override
	public void save(MstHoliday mstHoliday) {
		mstHolidayDAO.save(mstHoliday);
	}

	@Override
	public void update(MstHoliday mstHoliday) {
		mstHolidayDAO.update(mstHoliday);
	}

	@Override
	public void saveOrUpdate(MstHoliday mstHoliday) {
		mstHolidayDAO.saveOrUpdate(mstHoliday);
	}

	@Override
	public void delete(MstHoliday mstHoliday) {
		mstHolidayDAO.delete(mstHoliday);
	}

	@Override
	public List<MstHoliday> getAllMstHolidays() {
		return mstHolidayDAO.getAllMstHolidays();
	}

	@Override
	public List<MstHoliday> getByRequestMap(HashMap<String, Object> hashMap) {
		return mstHolidayDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<MstHoliday> getMstHolidayPaging(HashMap<String, Object> hashMap) {
		return mstHolidayDAO.getMstHolidayPaging(hashMap);
	}

	@Override
	public int getCountAllMstHolidays() {
		return mstHolidayDAO.getCountAllMstHolidays();
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

	public MstWorkWeekDAO getMstWorkWeekDAO() {
		return mstWorkWeekDAO;
	}

	public void setMstWorkWeekDAO(MstWorkWeekDAO mstWorkWeekDAO) {
		this.mstWorkWeekDAO = mstWorkWeekDAO;
	}

	public MstHolidayDAO getMstHolidayDAO() {
		return mstHolidayDAO;
	}

	public void setMstHolidayDAO(MstHolidayDAO mstHolidayDAO) {
		this.mstHolidayDAO = mstHolidayDAO;
	}
}