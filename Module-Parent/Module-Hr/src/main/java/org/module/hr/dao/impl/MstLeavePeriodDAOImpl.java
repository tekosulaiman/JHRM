/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.module.hr.dao.impl;

import java.util.List;
import org.module.api.common.dao.base.BasisDAO;
import org.module.hr.model.MstLeavePeriod;
import org.module.hr.dao.MstLeavePeriodDAO;

/**
 *
 * @author achmadsy
 */
public class MstLeavePeriodDAOImpl extends BasisDAO<MstLeavePeriod> implements MstLeavePeriodDAO {

    @Override
    public List<MstLeavePeriod> getAll() throws Exception {
        return (List<MstLeavePeriod>) getHibernateTemplate().find("FROM MstLeavePeriod mlp ORDER BY mlp.idLeavePeriod ASC");
    }

    @Override
    public void saveOrUpdateList(List<MstLeavePeriod> listLeavePeriod) throws Exception {
        saveOrUpdateAll(listLeavePeriod);
    }

    @Override
    public void deleteList(List<MstLeavePeriod> listLeavePeriod) throws Exception {
        deleteAll(listLeavePeriod);
    }

}
