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
@Table(name = "ohrm_leave_entitlement_type", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmLeaveEntitlementType.findAll", query = "SELECT o FROM OhrmLeaveEntitlementType o"),
    @NamedQuery(name = "OhrmLeaveEntitlementType.findById", query = "SELECT o FROM OhrmLeaveEntitlementType o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmLeaveEntitlementType.findByName", query = "SELECT o FROM OhrmLeaveEntitlementType o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmLeaveEntitlementType.findByIsEditable", query = "SELECT o FROM OhrmLeaveEntitlementType o WHERE o.isEditable = :isEditable")})
public class OhrmLeaveEntitlementType implements Serializable {
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
    @Column(name = "is_editable")
    private boolean isEditable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entitlementType")
    private List<OhrmLeaveEntitlement> ohrmLeaveEntitlementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adjustmentType")
    private List<OhrmLeaveAdjustment> ohrmLeaveAdjustmentList;

    public OhrmLeaveEntitlementType() {
    }

    public OhrmLeaveEntitlementType(Integer id) {
        this.id = id;
    }

    public OhrmLeaveEntitlementType(Integer id, String name, boolean isEditable) {
        this.id = id;
        this.name = name;
        this.isEditable = isEditable;
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

    public boolean getIsEditable() {
        return isEditable;
    }

    public void setIsEditable(boolean isEditable) {
        this.isEditable = isEditable;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmLeaveEntitlementType)) {
            return false;
        }
        OhrmLeaveEntitlementType other = (OhrmLeaveEntitlementType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmLeaveEntitlementType[ id=" + id + " ]";
    }
    
}
