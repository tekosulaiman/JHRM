/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "hs_hr_emp_dependents", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrEmpDependents.findAll", query = "SELECT h FROM HsHrEmpDependents h"),
    @NamedQuery(name = "HsHrEmpDependents.findByEmpNumber", query = "SELECT h FROM HsHrEmpDependents h WHERE h.hsHrEmpDependentsPK.empNumber = :empNumber"),
    @NamedQuery(name = "HsHrEmpDependents.findByEdSeqno", query = "SELECT h FROM HsHrEmpDependents h WHERE h.hsHrEmpDependentsPK.edSeqno = :edSeqno"),
    @NamedQuery(name = "HsHrEmpDependents.findByEdName", query = "SELECT h FROM HsHrEmpDependents h WHERE h.edName = :edName"),
    @NamedQuery(name = "HsHrEmpDependents.findByEdRelationshipType", query = "SELECT h FROM HsHrEmpDependents h WHERE h.edRelationshipType = :edRelationshipType"),
    @NamedQuery(name = "HsHrEmpDependents.findByEdRelationship", query = "SELECT h FROM HsHrEmpDependents h WHERE h.edRelationship = :edRelationship"),
    @NamedQuery(name = "HsHrEmpDependents.findByEdDateOfBirth", query = "SELECT h FROM HsHrEmpDependents h WHERE h.edDateOfBirth = :edDateOfBirth")})
public class HsHrEmpDependents implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HsHrEmpDependentsPK hsHrEmpDependentsPK;
    @Column(name = "ed_name")
    private String edName;
    @Column(name = "ed_relationship_type")
    private String edRelationshipType;
    @Column(name = "ed_relationship")
    private String edRelationship;
    @Column(name = "ed_date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date edDateOfBirth;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HsHrEmployee hsHrEmployee;

    public HsHrEmpDependents() {
    }

    public HsHrEmpDependents(HsHrEmpDependentsPK hsHrEmpDependentsPK) {
        this.hsHrEmpDependentsPK = hsHrEmpDependentsPK;
    }

    public HsHrEmpDependents(int empNumber, short edSeqno) {
        this.hsHrEmpDependentsPK = new HsHrEmpDependentsPK(empNumber, edSeqno);
    }

    public HsHrEmpDependentsPK getHsHrEmpDependentsPK() {
        return hsHrEmpDependentsPK;
    }

    public void setHsHrEmpDependentsPK(HsHrEmpDependentsPK hsHrEmpDependentsPK) {
        this.hsHrEmpDependentsPK = hsHrEmpDependentsPK;
    }

    public String getEdName() {
        return edName;
    }

    public void setEdName(String edName) {
        this.edName = edName;
    }

    public String getEdRelationshipType() {
        return edRelationshipType;
    }

    public void setEdRelationshipType(String edRelationshipType) {
        this.edRelationshipType = edRelationshipType;
    }

    public String getEdRelationship() {
        return edRelationship;
    }

    public void setEdRelationship(String edRelationship) {
        this.edRelationship = edRelationship;
    }

    public Date getEdDateOfBirth() {
        return edDateOfBirth;
    }

    public void setEdDateOfBirth(Date edDateOfBirth) {
        this.edDateOfBirth = edDateOfBirth;
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
        hash += (hsHrEmpDependentsPK != null ? hsHrEmpDependentsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpDependents)) {
            return false;
        }
        HsHrEmpDependents other = (HsHrEmpDependents) object;
        if ((this.hsHrEmpDependentsPK == null && other.hsHrEmpDependentsPK != null) || (this.hsHrEmpDependentsPK != null && !this.hsHrEmpDependentsPK.equals(other.hsHrEmpDependentsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpDependents[ hsHrEmpDependentsPK=" + hsHrEmpDependentsPK + " ]";
    }
    
}
