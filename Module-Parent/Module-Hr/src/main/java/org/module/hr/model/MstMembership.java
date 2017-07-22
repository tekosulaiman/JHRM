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
 * @author Tom
 */
@Entity
@Table(name = "mst_membership", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstMembership.findAll", query = "SELECT m FROM MstMembership m"),
    @NamedQuery(name = "MstMembership.findByIdMembership", query = "SELECT m FROM MstMembership m WHERE m.idMembership = :idMembership"),
    @NamedQuery(name = "MstMembership.findByNameMembership", query = "SELECT m FROM MstMembership m WHERE m.nameMembership = :nameMembership")})
public class MstMembership implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_membership")
    private Integer idMembership;
    @Column(name = "name_membership")
    private String nameMembership;
    @OneToMany(mappedBy = "idMembership")
    private List<TrsEmployeeMembership> trsEmployeeMembershipList;

    public MstMembership() {
    }

    public MstMembership(Integer idMembership) {
        this.idMembership = idMembership;
    }

    public Integer getIdMembership() {
        return idMembership;
    }

    public void setIdMembership(Integer idMembership) {
        this.idMembership = idMembership;
    }

    public String getNameMembership() {
        return nameMembership;
    }

    public void setNameMembership(String nameMembership) {
        this.nameMembership = nameMembership;
    }

    @XmlTransient
    public List<TrsEmployeeMembership> getTrsEmployeeMembershipList() {
        return trsEmployeeMembershipList;
    }

    public void setTrsEmployeeMembershipList(List<TrsEmployeeMembership> trsEmployeeMembershipList) {
        this.trsEmployeeMembershipList = trsEmployeeMembershipList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMembership != null ? idMembership.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstMembership)) {
            return false;
        }
        MstMembership other = (MstMembership) object;
        if ((this.idMembership == null && other.idMembership != null) || (this.idMembership != null && !this.idMembership.equals(other.idMembership))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.MstMembership[ idMembership=" + idMembership + " ]";
    }
    
}
