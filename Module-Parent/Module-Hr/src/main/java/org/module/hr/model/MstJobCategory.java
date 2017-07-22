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
@Table(name = "mst_job_category", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstJobCategory.findAll", query = "SELECT m FROM MstJobCategory m"),
    @NamedQuery(name = "MstJobCategory.findByIdJobCategory", query = "SELECT m FROM MstJobCategory m WHERE m.idJobCategory = :idJobCategory"),
    @NamedQuery(name = "MstJobCategory.findByJobCategoryName", query = "SELECT m FROM MstJobCategory m WHERE m.jobCategoryName = :jobCategoryName")})
public class MstJobCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_job_category")
    private Integer idJobCategory;
    @Column(name = "job_category_name")
    private String jobCategoryName;

    public MstJobCategory() {
    }

    public MstJobCategory(Integer idJobCategory) {
        this.idJobCategory = idJobCategory;
    }

    public Integer getIdJobCategory() {
        return idJobCategory;
    }

    public void setIdJobCategory(Integer idJobCategory) {
        this.idJobCategory = idJobCategory;
    }

    public String getJobCategoryName() {
        return jobCategoryName;
    }

    public void setJobCategoryName(String jobCategoryName) {
        this.jobCategoryName = jobCategoryName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJobCategory != null ? idJobCategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstJobCategory)) {
            return false;
        }
        MstJobCategory other = (MstJobCategory) object;
        if ((this.idJobCategory == null && other.idJobCategory != null) || (this.idJobCategory != null && !this.idJobCategory.equals(other.idJobCategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.MstJobCategory[ idJobCategory=" + idJobCategory + " ]";
    }
    
}
