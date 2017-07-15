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
@Table(name = "ohrm_subunit", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmSubunit.findAll", query = "SELECT o FROM OhrmSubunit o"),
    @NamedQuery(name = "OhrmSubunit.findById", query = "SELECT o FROM OhrmSubunit o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmSubunit.findByName", query = "SELECT o FROM OhrmSubunit o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmSubunit.findByUnitId", query = "SELECT o FROM OhrmSubunit o WHERE o.unitId = :unitId"),
    @NamedQuery(name = "OhrmSubunit.findByDescription", query = "SELECT o FROM OhrmSubunit o WHERE o.description = :description"),
    @NamedQuery(name = "OhrmSubunit.findByLft", query = "SELECT o FROM OhrmSubunit o WHERE o.lft = :lft"),
    @NamedQuery(name = "OhrmSubunit.findByRgt", query = "SELECT o FROM OhrmSubunit o WHERE o.rgt = :rgt"),
    @NamedQuery(name = "OhrmSubunit.findByLevel", query = "SELECT o FROM OhrmSubunit o WHERE o.level = :level")})
public class OhrmSubunit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "unit_id")
    private String unitId;
    @Column(name = "description")
    private String description;
    @Column(name = "lft")
    private Short lft;
    @Column(name = "rgt")
    private Short rgt;
    @Column(name = "level")
    private Short level;
    @OneToMany(mappedBy = "workStation")
    private List<HsHrEmployee> hsHrEmployeeList;

    public OhrmSubunit() {
    }

    public OhrmSubunit(Integer id) {
        this.id = id;
    }

    public OhrmSubunit(Integer id, String name) {
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

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getLft() {
        return lft;
    }

    public void setLft(Short lft) {
        this.lft = lft;
    }

    public Short getRgt() {
        return rgt;
    }

    public void setRgt(Short rgt) {
        this.rgt = rgt;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
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
        if (!(object instanceof OhrmSubunit)) {
            return false;
        }
        OhrmSubunit other = (OhrmSubunit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmSubunit[ id=" + id + " ]";
    }
    
}
