/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.module.hr.dao.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstLeaveTypeDAO;
import org.module.hr.model.MstLeaveType;
import org.springframework.dao.support.DataAccessUtils;

/**
 *
 * @author achmadsy
 */
public class MstLeaveTypeDAOImpl extends BasisDAO<MstLeaveType> implements MstLeaveTypeDAO {

    @Override
    public int getCountWithFilter(HashMap<String, Object> hashMap) throws Exception {
        return DataAccessUtils.intResult(getByRequestMapCount(hashMap));
    }

    @Override
    public List<MstLeaveType> getPagingWithFilter(HashMap<String, Object> map) throws Exception {
        List<MstLeaveType> list = (List<MstLeaveType>) getByRequestMapWithSortingForPaging((HashMap<String, Object>) map.get("map")
                ,(LinkedHashMap<String, Object>) map.get("sortBy"),(int) map.get("offset"), (int) map.get("limit"));
        return list;
    }

    @Override
    public void saveOrUpdate(MstLeaveType mstLeaveType) {
        super.saveOrUpdate(mstLeaveType);
    }

    @Override
    public void delete(MstLeaveType mstLeaveType) {
        super.delete(mstLeaveType);
    }

    @Override
    public void deleteList(List<MstLeaveType> mstLeaveTypes) throws Exception {
        deleteAll(mstLeaveTypes);
    }


}
