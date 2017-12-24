/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.module.hr.service;

import java.util.List;
import org.module.hr.model.MstLeavePeriod;

/**
 *
 * @author achmadsy
 */
public interface LeaveService {

    public List<MstLeavePeriod> getAllLeavePeriod() throws Exception;
    public void saveAllLeavePeriod(List<MstLeavePeriod> listLeavePeriod) throws Exception;
    public void deleteLeavePeriodList(List<MstLeavePeriod> listLeavePeriod) throws Exception;
}
