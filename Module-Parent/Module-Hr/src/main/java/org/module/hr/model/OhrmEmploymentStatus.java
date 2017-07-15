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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "ohrm_employment_status", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmEmploymentStatus.findAll", query = "SELECT o FROM OhrmEmploymentStatus o"),
    @NamedQuery(name = "OhrmEmploymentStatus.findById", query = "SELECT o FROM OhrmEmploymentStatus o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmEmploymentStatus.findByName", query = "SELECT o FROM OhrmEmploymentStatus o WHERE o.name = :name")})
public class OhrmEmploymentStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "ohrmEmploymentStatusList")
    private List<OhrmJobTitle> ohrmJobTitleList;
    @OneToMany(mappedBy = "empStatus")
    private List<HsHrEmployee> hsHrEmployeeList;

    public OhrmEmploymentStatus() {
    }

    public OhrmEmploymentStatus(Integer id) {
        this.id = id;
    }

    public OhrmEmploymentStatus(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @XmlTransient
    public List<OhrmJobTitle> getOhrmJobTitleList() {
        return ohrmJobTitleList;
    }

    public void setOhrmJobTitleList(List<OhrmJobTitle> ohrmJobTitleList) {
        this.ohrmJobTitleList = ohrmJobTitleList;
    }

    @XmlTransient
    public List<HsHrEmployee> getHsHrEmployeeList() {
        return hsHrEmployeeList;
    }

    public void setHsHrEmployeeList(List<HsHrEmployee> hsHrEmployeeList) {
        this.hsHrEmployeeList = hsHrEmployeeList;
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
        if (!(object instanceof OhrmEmploymentStatus)) {
            return false;
        }
        OhrmEmploymentStatus other = (OhrmEmploymentStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmEmploymentStatus[ id=" + id + " ]";
    }
    
}
