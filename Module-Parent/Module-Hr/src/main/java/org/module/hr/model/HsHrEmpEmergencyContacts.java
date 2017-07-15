/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "hs_hr_emp_emergency_contacts", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrEmpEmergencyContacts.findAll", query = "SELECT h FROM HsHrEmpEmergencyContacts h"),
    @NamedQuery(name = "HsHrEmpEmergencyContacts.findByEmpNumber", query = "SELECT h FROM HsHrEmpEmergencyContacts h WHERE h.hsHrEmpEmergencyContactsPK.empNumber = :empNumber"),
    @NamedQuery(name = "HsHrEmpEmergencyContacts.findByEecSeqno", query = "SELECT h FROM HsHrEmpEmergencyContacts h WHERE h.hsHrEmpEmergencyContactsPK.eecSeqno = :eecSeqno"),
    @NamedQuery(name = "HsHrEmpEmergencyContacts.findByEecName", query = "SELECT h FROM HsHrEmpEmergencyContacts h WHERE h.eecName = :eecName"),
    @NamedQuery(name = "HsHrEmpEmergencyContacts.findByEecRelationship", query = "SELECT h FROM HsHrEmpEmergencyContacts h WHERE h.eecRelationship = :eecRelationship"),
    @NamedQuery(name = "HsHrEmpEmergencyContacts.findByEecHomeNo", query = "SELECT h FROM HsHrEmpEmergencyContacts h WHERE h.eecHomeNo = :eecHomeNo"),
    @NamedQuery(name = "HsHrEmpEmergencyContacts.findByEecMobileNo", query = "SELECT h FROM HsHrEmpEmergencyContacts h WHERE h.eecMobileNo = :eecMobileNo"),
    @NamedQuery(name = "HsHrEmpEmergencyContacts.findByEecOfficeNo", query = "SELECT h FROM HsHrEmpEmergencyContacts h WHERE h.eecOfficeNo = :eecOfficeNo")})
public class HsHrEmpEmergencyContacts implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HsHrEmpEmergencyContactsPK hsHrEmpEmergencyContactsPK;
    @Column(name = "eec_name")
    private String eecName;
    @Column(name = "eec_relationship")
    private String eecRelationship;
    @Column(name = "eec_home_no")
    private String eecHomeNo;
    @Column(name = "eec_mobile_no")
    private String eecMobileNo;
    @Column(name = "eec_office_no")
    private String eecOfficeNo;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HsHrEmployee hsHrEmployee;

    public HsHrEmpEmergencyContacts() {
    }

    public HsHrEmpEmergencyContacts(HsHrEmpEmergencyContactsPK hsHrEmpEmergencyContactsPK) {
        this.hsHrEmpEmergencyContactsPK = hsHrEmpEmergencyContactsPK;
    }

    public HsHrEmpEmergencyContacts(int empNumber, short eecSeqno) {
        this.hsHrEmpEmergencyContactsPK = new HsHrEmpEmergencyContactsPK(empNumber, eecSeqno);
    }

    public HsHrEmpEmergencyContactsPK getHsHrEmpEmergencyContactsPK() {
        return hsHrEmpEmergencyContactsPK;
    }

    public void setHsHrEmpEmergencyContactsPK(HsHrEmpEmergencyContactsPK hsHrEmpEmergencyContactsPK) {
        this.hsHrEmpEmergencyContactsPK = hsHrEmpEmergencyContactsPK;
    }

    public String getEecName() {
        return eecName;
    }

    public void setEecName(String eecName) {
        this.eecName = eecName;
    }

    public String getEecRelationship() {
        return eecRelationship;
    }

    public void setEecRelationship(String eecRelationship) {
        this.eecRelationship = eecRelationship;
    }

    public String getEecHomeNo() {
        return eecHomeNo;
    }

    public void setEecHomeNo(String eecHomeNo) {
        this.eecHomeNo = eecHomeNo;
    }

    public String getEecMobileNo() {
        return eecMobileNo;
    }

    public void setEecMobileNo(String eecMobileNo) {
        this.eecMobileNo = eecMobileNo;
    }

    public String getEecOfficeNo() {
        return eecOfficeNo;
    }

    public void setEecOfficeNo(String eecOfficeNo) {
        this.eecOfficeNo = eecOfficeNo;
    }

    public HsHrEmployee getHsHrEmployee() {
        return hsHrEmployee;
    }

    public void setHsHrEmployee(HsHrEmployee hsHrEmployee) {
        this.hsHrEmployee = hsHrEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hsHrEmpEmergencyContactsPK != null ? hsHrEmpEmergencyContactsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpEmergencyContacts)) {
            return false;
        }
        HsHrEmpEmergencyContacts other = (HsHrEmpEmergencyContacts) object;
        if ((this.hsHrEmpEmergencyContactsPK == null && other.hsHrEmpEmergencyContactsPK != null) || (this.hsHrEmpEmergencyContactsPK != null && !this.hsHrEmpEmergencyContactsPK.equals(other.hsHrEmpEmergencyContactsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpEmergencyContacts[ hsHrEmpEmergencyContactsPK=" + hsHrEmpEmergencyContactsPK + " ]";
    }
    
}
