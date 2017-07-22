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
@Table(name = "mst_language", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstLanguage.findAll", query = "SELECT m FROM MstLanguage m"),
    @NamedQuery(name = "MstLanguage.findByIdLanguage", query = "SELECT m FROM MstLanguage m WHERE m.idLanguage = :idLanguage"),
    @NamedQuery(name = "MstLanguage.findByNameLanguage", query = "SELECT m FROM MstLanguage m WHERE m.nameLanguage = :nameLanguage")})
public class MstLanguage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_language")
    private Integer idLanguage;
    @Column(name = "name_language")
    private String nameLanguage;
    @OneToMany(mappedBy = "idLanguage")
    private List<TrsEmployeeLanguage> trsEmployeeLanguageList;

    public MstLanguage() {
    }

    public MstLanguage(Integer idLanguage) {
        this.idLanguage = idLanguage;
    }

    public Integer getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(Integer idLanguage) {
        this.idLanguage = idLanguage;
    }

    public String getNameLanguage() {
        return nameLanguage;
    }

    public void setNameLanguage(String nameLanguage) {
        this.nameLanguage = nameLanguage;
    }

    @XmlTransient
    public List<TrsEmployeeLanguage> getTrsEmployeeLanguageList() {
        return trsEmployeeLanguageList;
    }

    public void setTrsEmployeeLanguageList(List<TrsEmployeeLanguage> trsEmployeeLanguageList) {
        this.trsEmployeeLanguageList = trsEmployeeLanguageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLanguage != null ? idLanguage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstLanguage)) {
            return false;
        }
        MstLanguage other = (MstLanguage) object;
        if ((this.idLanguage == null && other.idLanguage != null) || (this.idLanguage != null && !this.idLanguage.equals(other.idLanguage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.MstLanguage[ idLanguage=" + idLanguage + " ]";
    }
    
}
