/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_work_shift", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmWorkShift.findAll", query = "SELECT o FROM OhrmWorkShift o"),
    @NamedQuery(name = "OhrmWorkShift.findById", query = "SELECT o FROM OhrmWorkShift o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmWorkShift.findByName", query = "SELECT o FROM OhrmWorkShift o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmWorkShift.findByHoursPerDay", query = "SELECT o FROM OhrmWorkShift o WHERE o.hoursPerDay = :hoursPerDay"),
    @NamedQuery(name = "OhrmWorkShift.findByStartTime", query = "SELECT o FROM OhrmWorkShift o WHERE o.startTime = :startTime"),
    @NamedQuery(name = "OhrmWorkShift.findByEndTime", query = "SELECT o FROM OhrmWorkShift o WHERE o.endTime = :endTime")})
public class OhrmWorkShift implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "hours_per_day")
    private BigDecimal hoursPerDay;
    @Basic(optional = false)
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Basic(optional = false)
    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @JoinTable(name = "ohrm_employee_work_shift", joinColumns = {
        @JoinColumn(name = "work_shift_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "emp_number", referencedColumnName = "emp_number")})
    @ManyToMany
    private List<HsHrEmployee> hsHrEmployeeList;

    public OhrmWorkShift() {
    }

    public OhrmWorkShift(Integer id) {
        this.id = id;
    }

    public OhrmWorkShift(Integer id, String name, BigDecimal hoursPerDay, Date startTime, Date endTime) {
        this.id = id;
        this.name = name;
        this.hoursPerDay = hoursPerDay;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getHoursPerDay() {
        return hoursPerDay;
    }

    public void setHoursPerDay(BigDecimal hoursPerDay) {
        this.hoursPerDay = hoursPerDay;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @XmlTransient
    public List<HsHrEmployee> getHsHrEmployeeList() {
        return hsHrEmployeeList;
    }

    public void setHsHrEmployeeList(List<HsHrEmployee> hsHrEmployeeList) {
        this.hsHrEmployeeList = hsHrEmployeeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmWorkShift)) {
            return false;
        }
        OhrmWorkShift other = (OhrmWorkShift) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmWorkShift[ id=" + id + " ]";
    }
    
}
