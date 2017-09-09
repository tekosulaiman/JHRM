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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "mst_education", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstEducation.findAll", query = "SELECT m FROM MstEducation m"),
    @NamedQuery(name = "MstEducation.findByIdEducation", query = "SELECT m FROM MstEducation m WHERE m.idEducation = :idEducation"),
    @NamedQuery(name = "MstEducation.findByEducationName", query = "SELECT m FROM MstEducation m WHERE m.educationName = :educationName")})
public class MstEducation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="MstEducation_idEducation_GENERATOR", sequenceName="SCHEMA_HR.MstEducation_idEducation_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MstEducation_idEducation_GENERATOR")
    @Column(name = "id_education")
    private Integer idEducation;
    @Column(name = "education_name")
    private String educationName;
    @OneToMany(mappedBy = "idEducation")
    private List<TrsEmployeeEducation> trsEmployeeEducationList;

    public MstEducation() {
    }

    public MstEducation(Integer idEducation) {
        this.idEducation = idEducation;
    }

    public Integer getIdEducation() {
        return idEducation;
    }

    public void setIdEducation(Integer idEducation) {
        this.idEducation = idEducation;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    @XmlTransient
    public List<TrsEmployeeEducation> getTrsEmployeeEducationList() {
        return trsEmployeeEducationList;
    }

    public void setTrsEmployeeEducationList(List<TrsEmployeeEducation> trsEmployeeEducationList) {
        this.trsEmployeeEducationList = trsEmployeeEducationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEducation != null ? idEducation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstEducation)) {
            return false;
        }
        MstEducation other = (MstEducation) object;
        if ((this.idEducation == null && other.idEducation != null) || (this.idEducation != null && !this.idEducation.equals(other.idEducation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.MstEducation[ idEducation=" + idEducation + " ]";
    }
    
}
