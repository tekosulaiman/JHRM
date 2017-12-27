/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;
import org.module.hr.model.MstLeaveType;

/**
 *
 * @author achmadsy
 */
public interface MstLeaveTypeDAO {

    public int getCountMstLeaveTypeWithFilter(HashMap<String, Object> hashMap) throws Exception;
    public List<MstLeaveType> getMstLeaveTypePagingWithFilter(HashMap<String,Object> map) throws Exception;
    public void saveOrUpdateLeaveType(MstLeaveType mstLeaveType) throws Exception;
    public void deleteLeaveType(MstLeaveType mstLeaveType) throws Exception;
    public void deleteLeaveTypeList(List<MstLeaveType> mstLeaveTypes) throws Exception;
}
