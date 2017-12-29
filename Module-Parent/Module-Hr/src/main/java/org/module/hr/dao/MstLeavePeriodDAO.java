/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.module.hr.dao;

import java.util.List;
import org.module.hr.model.MstLeavePeriod;

/**
 *
 * @author achmadsy
 */
public interface MstLeavePeriodDAO {

    public List<MstLeavePeriod> getAll() throws Exception;
    public void saveOrUpdateList(List<MstLeavePeriod> listLeavePeriod) throws Exception;
    public void deleteList(List<MstLeavePeriod> listLeavePeriod) throws Exception;
}
