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
@Table(name = "trs_employee_membership", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsEmployeeMembership.findAll", query = "SELECT t FROM TrsEmployeeMembership t"),
    @NamedQuery(name = "TrsEmployeeMembership.findByIdEmployeeMembership", query = "SELECT t FROM TrsEmployeeMembership t WHERE t.idEmployeeMembership = :idEmployeeMembership")})
public class TrsEmployeeMembership implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_employee_membership")
    private Integer idEmployeeMembership;
    @JoinColumn(name = "id_membership", referencedColumnName = "id_membership")
    @ManyToOne
    private MstMembership idMembership;
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;

    public TrsEmployeeMembership() {
    }

    public TrsEmployeeMembership(Integer idEmployeeMembership) {
        this.idEmployeeMembership = idEmployeeMembership;
    }

    public Integer getIdEmployeeMembership() {
        return idEmployeeMembership;
    }

    public void setIdEmployeeMembership(Integer idEmployeeMembership) {
        this.idEmployeeMembership = idEmployeeMembership;
    }

    public MstMembership getIdMembership() {
        return idMembership;
    }

    public void setIdMembership(MstMembership idMembership) {
        this.idMembership = idMembership;
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
        hash += (idEmployeeMembership != null ? idEmployeeMembership.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrsEmployeeMembership)) {
            return false;
        }
        TrsEmployeeMembership other = (TrsEmployeeMembership) object;
        if ((this.idEmployeeMembership == null && other.idEmployeeMembership != null) || (this.idEmployeeMembership != null && !this.idEmployeeMembership.equals(other.idEmployeeMembership))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.TrsEmployeeMembership[ idEmployeeMembership=" + idEmployeeMembership + " ]";
    }
    
}
