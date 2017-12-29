/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.module.hr.dao;

import java.util.List;
import org.module.hr.model.MstWorkWeek;

/**
 *
 * @author achmadsy
 */
public interface MstWorkWeekDAO {
    public List<MstWorkWeek> getAll() throws Exception;
    public MstWorkWeek getByDayName(String dayName) throws Exception;
    public void update(MstWorkWeek mstWorkWeek) throws Exception;
    public void updateAll(List<MstWorkWeek> mstWorkWeek) throws Exception;
}
