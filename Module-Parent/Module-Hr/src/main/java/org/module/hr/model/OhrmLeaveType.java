/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_leave_type", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmLeaveType.findAll", query = "SELECT o FROM OhrmLeaveType o"),
    @NamedQuery(name = "OhrmLeaveType.findById", query = "SELECT o FROM OhrmLeaveType o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmLeaveType.findByName", query = "SELECT o FROM OhrmLeaveType o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmLeaveType.findByDeleted", query = "SELECT o FROM OhrmLeaveType o WHERE o.deleted = :deleted"),
    @NamedQuery(name = "OhrmLeaveType.findByExcludeInReportsIfNoEntitlement", query = "SELECT o FROM OhrmLeaveType o WHERE o.excludeInReportsIfNoEntitlement = :excludeInReportsIfNoEntitlement")})
public class OhrmLeaveType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "deleted")
    private boolean deleted;
    @Basic(optional = false)
    @Column(name = "exclude_in_reports_if_no_entitlement")
    private boolean excludeInReportsIfNoEntitlement;
    @JoinColumn(name = "operational_country_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmOperationalCountry operationalCountryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaveTypeId")
    private List<OhrmLeaveEntitlement> ohrmLeaveEntitlementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaveTypeId")
    private List<OhrmLeaveAdjustment> ohrmLeaveAdjustmentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaveTypeId")
    private List<OhrmLeaveRequest> ohrmLeaveRequestList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaveTypeId")
    private List<OhrmLeave> ohrmLeaveList;

    public OhrmLeaveType() {
    }

    public OhrmLeaveType(Integer id) {
        this.id = id;
    }

    public OhrmLeaveType(Integer id, String name, boolean deleted, boolean excludeInReportsIfNoEntitlement) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
        this.excludeInReportsIfNoEntitlement = excludeInReportsIfNoEntitlement;
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

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean getExcludeInReportsIfNoEntitlement() {
        return excludeInReportsIfNoEntitlement;
    }

    public void setExcludeInReportsIfNoEntitlement(boolean excludeInReportsIfNoEntitlement) {
        this.excludeInReportsIfNoEntitlement = excludeInReportsIfNoEntitlement;
    }

    public OhrmOperationalCountry getOperationalCountryId() {
        return operationalCountryId;
    }

    public void setOperationalCountryId(OhrmOperationalCountry operationalCountryId) {
        this.operationalCountryId = operationalCountryId;
    }

    @XmlTransient
    public List<OhrmLeaveEntitlement> getOhrmLeaveEntitlementList() {
        return ohrmLeaveEntitlementList;
    }

    public void setOhrmLeaveEntitlementList(List<OhrmLeaveEntitlement> ohrmLeaveEntitlementList) {
        this.ohrmLeaveEntitlementList = ohrmLeaveEntitlementList;
    }

    @XmlTransient
    public List<OhrmLeaveAdjustment> getOhrmLeaveAdjustmentList() {
        return ohrmLeaveAdjustmentList;
    }

    public void setOhrmLeaveAdjustmentList(List<OhrmLeaveAdjustment> ohrmLeaveAdjustmentList) {
        this.ohrmLeaveAdjustmentList = ohrmLeaveAdjustmentList;
    }

    @XmlTransient
    public List<OhrmLeaveRequest> getOhrmLeaveRequestList() {
        return ohrmLeaveRequestList;
    }

    public void setOhrmLeaveRequestList(List<OhrmLeaveRequest> ohrmLeaveRequestList) {
        this.ohrmLeaveRequestList = ohrmLeaveRequestList;
    }

    @XmlTransient
    public List<OhrmLeave> getOhrmLeaveList() {
        return ohrmLeaveList;
    }

    public void setOhrmLeaveList(List<OhrmLeave> ohrmLeaveList) {
        this.ohrmLeaveList = ohrmLeaveList;
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
        if (!(object instanceof OhrmLeaveType)) {
            return false;
        }
        OhrmLeaveType other = (OhrmLeaveType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmLeaveType[ id=" + id + " ]";
    }
    
}
