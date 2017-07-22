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
@Table(name = "mst_nationality", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstNationality.findAll", query = "SELECT m FROM MstNationality m"),
    @NamedQuery(name = "MstNationality.findByIdNationality", query = "SELECT m FROM MstNationality m WHERE m.idNationality = :idNationality"),
    @NamedQuery(name = "MstNationality.findByNameNationality", query = "SELECT m FROM MstNationality m WHERE m.nameNationality = :nameNationality")})
public class MstNationality implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_nationality")
    private Integer idNationality;
    @Column(name = "name_nationality")
    private String nameNationality;

    public MstNationality() {
    }

    public MstNationality(Integer idNationality) {
        this.idNationality = idNationality;
    }

    public Integer getIdNationality() {
        return idNationality;
    }

    public void setIdNationality(Integer idNationality) {
        this.idNationality = idNationality;
    }

    public String getNameNationality() {
        return nameNationality;
    }

    public void setNameNationality(String nameNationality) {
        this.nameNationality = nameNationality;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNationality != null ? idNationality.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstNationality)) {
            return false;
        }
        MstNationality other = (MstNationality) object;
        if ((this.idNationality == null && other.idNationality != null) || (this.idNationality != null && !this.idNationality.equals(other.idNationality))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.MstNationality[ idNationality=" + idNationality + " ]";
    }
    
}
