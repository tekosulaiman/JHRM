/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "trs_employee_emergency_contact", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsEmployeeEmergencyContact.findAll", query = "SELECT t FROM TrsEmployeeEmergencyContact t"),
    @NamedQuery(name = "TrsEmployeeEmergencyContact.findByIdEmployeeEmergencyContact", query = "SELECT t FROM TrsEmployeeEmergencyContact t WHERE t.idEmployeeEmergencyContact = :idEmployeeEmergencyContact"),
    @NamedQuery(name = "TrsEmployeeEmergencyContact.findByName", query = "SELECT t FROM TrsEmployeeEmergencyContact t WHERE t.name = :name"),
    @NamedQuery(name = "TrsEmployeeEmergencyContact.findByRelationship", query = "SELECT t FROM TrsEmployeeEmergencyContact t WHERE t.relationship = :relationship"),
    @NamedQuery(name = "TrsEmployeeEmergencyContact.findByHomeTelephone", query = "SELECT t FROM TrsEmployeeEmergencyContact t WHERE t.homeTelephone = :homeTelephone"),
    @NamedQuery(name = "TrsEmployeeEmergencyContact.findByMobile", query = "SELECT t FROM TrsEmployeeEmergencyContact t WHERE t.mobile = :mobile"),
    @NamedQuery(name = "TrsEmployeeEmergencyContact.findByWorkTelephone", query = "SELECT t FROM TrsEmployeeEmergencyContact t WHERE t.workTelephone = :workTelephone")})
public class TrsEmployeeEmergencyContact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_employee_emergency_contact")
    private Integer idEmployeeEmergencyContact;
    @Column(name = "name")
    private String name;
    @Column(name = "relationship")
    private String relationship;
    @Column(name = "home_telephone")
    private String homeTelephone;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "work_telephone")
    private String workTelephone;
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;

    public TrsEmployeeEmergencyContact() {
    }

    public TrsEmployeeEmergencyContact(Integer idEmployeeEmergencyContact) {
        this.idEmployeeEmergencyContact = idEmployeeEmergencyContact;
    }

    public Integer getIdEmployeeEmergencyContact() {
        return idEmployeeEmergencyContact;
    }

    public void setIdEmployeeEmergencyContact(Integer idEmployeeEmergencyContact) {
        this.idEmployeeEmergencyContact = idEmployeeEmergencyContact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getHomeTelephone() {
        return homeTelephone;
    }

    public void setHomeTelephone(String homeTelephone) {
        this.homeTelephone = homeTelephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWorkTelephone() {
        return workTelephone;
    }

    public void setWorkTelephone(String workTelephone) {
        this.workTelephone = workTelephone;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmployeeEmergencyContact != null ? idEmployeeEmergencyContact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrsEmployeeEmergencyContact)) {
            return false;
        }
        TrsEmployeeEmergencyContact other = (TrsEmployeeEmergencyContact) object;
        if ((this.idEmployeeEmergencyContact == null && other.idEmployeeEmergencyContact != null) || (this.idEmployeeEmergencyContact != null && !this.idEmployeeEmergencyContact.equals(other.idEmployeeEmergencyContact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.TrsEmployeeEmergencyContact[ idEmployeeEmergencyContact=" + idEmployeeEmergencyContact + " ]";
    }
    
}
