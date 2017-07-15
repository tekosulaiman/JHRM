/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "ohrm_module", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmModule.findAll", query = "SELECT o FROM OhrmModule o"),
    @NamedQuery(name = "OhrmModule.findById", query = "SELECT o FROM OhrmModule o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmModule.findByName", query = "SELECT o FROM OhrmModule o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmModule.findByStatus", query = "SELECT o FROM OhrmModule o WHERE o.status = :status")})
public class OhrmModule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private Short status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduleId")
    private List<OhrmModuleDefaultPage> ohrmModuleDefaultPageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduleId")
    private List<OhrmScreen> ohrmScreenList;

    public OhrmModule() {
    }

    public OhrmModule(Integer id) {
        this.id = id;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @XmlTransient
    public List<OhrmModuleDefaultPage> getOhrmModuleDefaultPageList() {
        return ohrmModuleDefaultPageList;
    }

    public void setOhrmModuleDefaultPageList(List<OhrmModuleDefaultPage> ohrmModuleDefaultPageList) {
        this.ohrmModuleDefaultPageList = ohrmModuleDefaultPageList;
    }

    @XmlTransient
    public List<OhrmScreen> getOhrmScreenList() {
        return ohrmScreenList;
    }

    public void setOhrmScreenList(List<OhrmScreen> ohrmScreenList) {
        this.ohrmScreenList = ohrmScreenList;
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
        if (!(object instanceof OhrmModule)) {
            return false;
        }
        OhrmModule other = (OhrmModule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmModule[ id=" + id + " ]";
    }
    
}
