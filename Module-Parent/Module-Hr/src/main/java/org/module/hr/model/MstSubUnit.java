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
@Table(name = "mst_sub_unit", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstSubUnit.findAll", query = "SELECT m FROM MstSubUnit m"),
    @NamedQuery(name = "MstSubUnit.findByIdSubUnit", query = "SELECT m FROM MstSubUnit m WHERE m.idSubUnit = :idSubUnit"),
    @NamedQuery(name = "MstSubUnit.findByCodeSubUnit", query = "SELECT m FROM MstSubUnit m WHERE m.codeSubUnit = :codeSubUnit"),
    @NamedQuery(name = "MstSubUnit.findByNameSubUnit", query = "SELECT m FROM MstSubUnit m WHERE m.nameSubUnit = :nameSubUnit"),
    @NamedQuery(name = "MstSubUnit.findByDescriptionSubUnit", query = "SELECT m FROM MstSubUnit m WHERE m.descriptionSubUnit = :descriptionSubUnit"),
    @NamedQuery(name = "MstSubUnit.findByParent", query = "SELECT m FROM MstSubUnit m WHERE m.parent = :parent"),
    @NamedQuery(name = "MstSubUnit.findByChild", query = "SELECT m FROM MstSubUnit m WHERE m.child = :child"),
    @NamedQuery(name = "MstSubUnit.findByLevel", query = "SELECT m FROM MstSubUnit m WHERE m.level = :level")})
public class MstSubUnit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_sub_unit")
    private Integer idSubUnit;
    @Column(name = "code_sub_unit")
    private String codeSubUnit;
    @Column(name = "name_sub_unit")
    private String nameSubUnit;
    @Column(name = "description_sub_unit")
    private String descriptionSubUnit;
    @Column(name = "parent")
    private Short parent;
    @Column(name = "child")
    private Short child;
    @Column(name = "level")
    private Short level;
    @OneToMany(mappedBy = "idSubUnit")
    private List<TrsEmployee> trsEmployeeList;

    public MstSubUnit() {
    }

    public MstSubUnit(Integer idSubUnit) {
        this.idSubUnit = idSubUnit;
    }

    public Integer getIdSubUnit() {
        return idSubUnit;
    }

    public void setIdSubUnit(Integer idSubUnit) {
        this.idSubUnit = idSubUnit;
    }

    public String getCodeSubUnit() {
        return codeSubUnit;
    }

    public void setCodeSubUnit(String codeSubUnit) {
        this.codeSubUnit = codeSubUnit;
    }

    public String getNameSubUnit() {
        return nameSubUnit;
    }

    public void setNameSubUnit(String nameSubUnit) {
        this.nameSubUnit = nameSubUnit;
    }

    public String getDescriptionSubUnit() {
        return descriptionSubUnit;
    }

    public void setDescriptionSubUnit(String descriptionSubUnit) {
        this.descriptionSubUnit = descriptionSubUnit;
    }

    public Short getParent() {
        return parent;
    }

    public void setParent(Short parent) {
        this.parent = parent;
    }

    public Short getChild() {
        return child;
    }

    public void setChild(Short child) {
        this.child = child;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    @XmlTransient
    public List<TrsEmployee> getTrsEmployeeList() {
        return trsEmployeeList;
    }

    public void setTrsEmployeeList(List<TrsEmployee> trsEmployeeList) {
        this.trsEmployeeList = trsEmployeeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubUnit != null ? idSubUnit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstSubUnit)) {
            return false;
        }
        MstSubUnit other = (MstSubUnit) object;
        if ((this.idSubUnit == null && other.idSubUnit != null) || (this.idSubUnit != null && !this.idSubUnit.equals(other.idSubUnit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.MstSubUnit[ idSubUnit=" + idSubUnit + " ]";
    }
    
}
