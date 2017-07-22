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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "mst_employement_status", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstEmployementStatus.findAll", query = "SELECT m FROM MstEmployementStatus m"),
    @NamedQuery(name = "MstEmployementStatus.findByIdEmployementStatus", query = "SELECT m FROM MstEmployementStatus m WHERE m.idEmployementStatus = :idEmployementStatus"),
    @NamedQuery(name = "MstEmployementStatus.findByEmployementStatusName", query = "SELECT m FROM MstEmployementStatus m WHERE m.employementStatusName = :employementStatusName")})
public class MstEmployementStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_employement_status")
    private Integer idEmployementStatus;
    @Column(name = "employement_status_name")
    private String employementStatusName;

    public MstEmployementStatus() {
    }

    public MstEmployementStatus(Integer idEmployementStatus) {
        this.idEmployementStatus = idEmployementStatus;
    }

    public Integer getIdEmployementStatus() {
        return idEmployementStatus;
    }

    public void setIdEmployementStatus(Integer idEmployementStatus) {
        this.idEmployementStatus = idEmployementStatus;
    }

    public String getEmployementStatusName() {
        return employementStatusName;
    }

    public void setEmployementStatusName(String employementStatusName) {
        this.employementStatusName = employementStatusName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmployementStatus != null ? idEmployementStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstEmployementStatus)) {
            return false;
        }
        MstEmployementStatus other = (MstEmployementStatus) object;
        if ((this.idEmployementStatus == null && other.idEmployementStatus != null) || (this.idEmployementStatus != null && !this.idEmployementStatus.equals(other.idEmployementStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.MstEmployementStatus[ idEmployementStatus=" + idEmployementStatus + " ]";
    }
    
}
