/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.module.hr.dao.impl;

import java.util.List;
import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.dao.MstWorkWeekDAO;
import org.module.hr.model.MstWorkWeek;

/**
 *
 * @author achmadsy
 */
public class MstWorkWeekDAOImpl extends BasisDAO<MstWorkWeek> implements MstWorkWeekDAO {

    @Override
    public MstWorkWeek getByDayName(String dayName) throws Exception {
        return (MstWorkWeek) getHibernateTemplate().find("FROM MstWorkWeek mww where mww.workdayName = ?", dayName).get(0);
    }

    @Override
    public List<MstWorkWeek> getAll() throws Exception {
        return (List<MstWorkWeek>) getHibernateTemplate().find("FROM MstWorkWeek mww ORDER BY mww.idWorkWeek ASC");
    }

    @Override
    public void update(MstWorkWeek mstWorkWeek) {
        super.update(mstWorkWeek);
    }

    @Override
    public void updateAll(List<MstWorkWeek> mstWorkWeek) throws Exception {
        super.saveOrUpdateAll(mstWorkWeek);
    }

}
