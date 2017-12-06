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
@Table(name = "mst_work_week", catalog = "dbhr", schema = "schema_hr")
public class MstWorkWeek implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_work_week")
    private Integer idWorkWeek;
    
    @Column(name = "monday")
    private Integer monday;
    
    @Column(name = "tuesday")
    private Integer tuesday;
    
    @Column(name = "wednesday")
    private Integer wednesday;
   
    @Column(name = "thursday")
    private Integer thursday;
    
    @Column(name = "friday")
    private Integer friday;
    
    @Column(name = "saturday")
    private Integer saturday;
    
    @Column(name = "sunday")
    private Integer sunday;

    public MstWorkWeek() {
    }

    public MstWorkWeek(Integer idWorkWeek) {
        this.idWorkWeek = idWorkWeek;
    }

    public Integer getIdWorkWeek() {
        return idWorkWeek;
    }

    public void setIdWorkWeek(Integer idWorkWeek) {
        this.idWorkWeek = idWorkWeek;
    }

    public Integer getMonday() {
        return monday;
    }

    public void setMonday(Integer monday) {
        this.monday = monday;
    }

    public Integer getTuesday() {
        return tuesday;
    }

    public void setTuesday(Integer tuesday) {
        this.tuesday = tuesday;
    }

    public Integer getWednesday() {
        return wednesday;
    }

    public void setWednesday(Integer wednesday) {
        this.wednesday = wednesday;
    }

    public Integer getThursday() {
        return thursday;
    }

    public void setThursday(Integer thursday) {
        this.thursday = thursday;
    }

    public Integer getFriday() {
        return friday;
    }

    public void setFriday(Integer friday) {
        this.friday = friday;
    }

    public Integer getSaturday() {
        return saturday;
    }

    public void setSaturday(Integer saturday) {
        this.saturday = saturday;
    }

    public Integer getSunday() {
        return sunday;
    }

    public void setSunday(Integer sunday) {
        this.sunday = sunday;
    }
}