/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 10991044
 */
@Entity
@Table(name = "mst_leave_period", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstLeavePeriod.findAll", query = "SELECT m FROM MstLeavePeriod m"),
    @NamedQuery(name = "MstLeavePeriod.findByIdLeavePeriod", query = "SELECT m FROM MstLeavePeriod m WHERE m.idLeavePeriod = :idLeavePeriod"),
    @NamedQuery(name = "MstLeavePeriod.findByStartMonth", query = "SELECT m FROM MstLeavePeriod m WHERE m.startMonth = :startMonth"),
    @NamedQuery(name = "MstLeavePeriod.findByStartDay", query = "SELECT m FROM MstLeavePeriod m WHERE m.startDay = :startDay")})
public class MstLeavePeriod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_leave_period")
    private Integer idLeavePeriod;
    @Column(name = "start_month")
    private Integer startMonth;
    @Column(name = "start_day")
    private Integer startDay;
    @OneToMany(mappedBy = "idLeavePeriod")
    private List<TrsEntitlement> trsEntitlementList;

    public MstLeavePeriod() {
    }

    public MstLeavePeriod(Integer idLeavePeriod) {
        this.idLeavePeriod = idLeavePeriod;
    }

    public Integer getIdLeavePeriod() {
        return idLeavePeriod;
    }

    public void setIdLeavePeriod(Integer idLeavePeriod) {
        this.idLeavePeriod = idLeavePeriod;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    public Integer getStartDay() {
        return startDay;
    }

    public void setStartDay(Integer startDay) {
        this.startDay = startDay;
    }

    @XmlTransient
    public List<TrsEntitlement> getTrsEntitlementList() {
        return trsEntitlementList;
    }

    public void setTrsEntitlementList(List<TrsEntitlement> trsEntitlementList) {
        this.trsEntitlementList = trsEntitlementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLeavePeriod != null ? idLeavePeriod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstLeavePeriod)) {
            return false;
        }
        MstLeavePeriod other = (MstLeavePeriod) object;
        if ((this.idLeavePeriod == null && other.idLeavePeriod != null) || (this.idLeavePeriod != null && !this.idLeavePeriod.equals(other.idLeavePeriod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.MstLeavePeriod[ idLeavePeriod=" + idLeavePeriod + " ]";
    }
    
}
