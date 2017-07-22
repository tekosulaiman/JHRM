/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "trs_employee_dependent", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsEmployeeDependent.findAll", query = "SELECT t FROM TrsEmployeeDependent t"),
    @NamedQuery(name = "TrsEmployeeDependent.findByIdDependent", query = "SELECT t FROM TrsEmployeeDependent t WHERE t.idDependent = :idDependent"),
    @NamedQuery(name = "TrsEmployeeDependent.findByName", query = "SELECT t FROM TrsEmployeeDependent t WHERE t.name = :name"),
    @NamedQuery(name = "TrsEmployeeDependent.findByRelationship", query = "SELECT t FROM TrsEmployeeDependent t WHERE t.relationship = :relationship"),
    @NamedQuery(name = "TrsEmployeeDependent.findByDateOfBirth", query = "SELECT t FROM TrsEmployeeDependent t WHERE t.dateOfBirth = :dateOfBirth")})
public class TrsEmployeeDependent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_dependent")
    private Integer idDependent;
    @Column(name = "name")
    private String name;
    @Column(name = "relationship")
    private String relationship;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;

    public TrsEmployeeDependent() {
    }

    public TrsEmployeeDependent(Integer idDependent) {
        this.idDependent = idDependent;
    }

    public Integer getIdDependent() {
        return idDependent;
    }

    public void setIdDependent(Integer idDependent) {
        this.idDependent = idDependent;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
        hash += (idDependent != null ? idDependent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrsEmployeeDependent)) {
            return false;
        }
        TrsEmployeeDependent other = (TrsEmployeeDependent) object;
        if ((this.idDependent == null && other.idDependent != null) || (this.idDependent != null && !this.idDependent.equals(other.idDependent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.TrsEmployeeDependent[ idDependent=" + idDependent + " ]";
    }
    
}
