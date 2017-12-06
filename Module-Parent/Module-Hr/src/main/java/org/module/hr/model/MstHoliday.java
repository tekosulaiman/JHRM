package org.module.hr.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*
* @author tekosulaiman@yahoo.com
*/
@Entity
@Table(name = "mst_holiday", catalog = "dbhr", schema = "schema_hr")
public class MstHoliday implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_holiday")
    private Integer idHoliday;
    
    @Column(name = "holiday_name")
    private String holidayName;
    
    @Column(name = "duration")
    private Integer duration;

    public MstHoliday() {
    }

    public MstHoliday(Integer idHoliday) {
        this.idHoliday = idHoliday;
    }

    public Integer getIdHoliday() {
        return idHoliday;
    }

    public void setIdHoliday(Integer idHoliday) {
        this.idHoliday = idHoliday;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}