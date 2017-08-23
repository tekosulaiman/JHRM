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
@Table(name = "mst_skill", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstSkill.findAll", query = "SELECT m FROM MstSkill m"),
    @NamedQuery(name = "MstSkill.findByIdSkill", query = "SELECT m FROM MstSkill m WHERE m.idSkill = :idSkill"),
    @NamedQuery(name = "MstSkill.findByNameSkill", query = "SELECT m FROM MstSkill m WHERE m.nameSkill = :nameSkill"),
    @NamedQuery(name = "MstSkill.findByDescriptionSkill", query = "SELECT m FROM MstSkill m WHERE m.descriptionSkill = :descriptionSkill")})
public class MstSkill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id_skill")
    private Integer idSkill;
    @Column(name = "name_skill")
    private String nameSkill;
    @Column(name = "description_skill")
    private String descriptionSkill;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSkill")
    private List<TrsEmployeeSkill> trsEmployeeSkillList;

    public MstSkill() {
    }

    public MstSkill(Integer idSkill) {
        this.idSkill = idSkill;
    }

    public Integer getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(Integer idSkill) {
        this.idSkill = idSkill;
    }

    public String getNameSkill() {
        return nameSkill;
    }

    public void setNameSkill(String nameSkill) {
        this.nameSkill = nameSkill;
    }

    public String getDescriptionSkill() {
        return descriptionSkill;
    }

    public void setDescriptionSkill(String descriptionSkill) {
        this.descriptionSkill = descriptionSkill;
    }

    @XmlTransient
    public List<TrsEmployeeSkill> getTrsEmployeeSkillList() {
        return trsEmployeeSkillList;
    }

    public void setTrsEmployeeSkillList(List<TrsEmployeeSkill> trsEmployeeSkillList) {
        this.trsEmployeeSkillList = trsEmployeeSkillList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSkill != null ? idSkill.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstSkill)) {
            return false;
        }
        MstSkill other = (MstSkill) object;
        if ((this.idSkill == null && other.idSkill != null) || (this.idSkill != null && !this.idSkill.equals(other.idSkill))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.MstSkill[ idSkill=" + idSkill + " ]";
    }
    
}
