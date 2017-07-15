/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_kpi", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmKpi.findAll", query = "SELECT o FROM OhrmKpi o"),
    @NamedQuery(name = "OhrmKpi.findById", query = "SELECT o FROM OhrmKpi o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmKpi.findByJobTitleCode", query = "SELECT o FROM OhrmKpi o WHERE o.jobTitleCode = :jobTitleCode"),
    @NamedQuery(name = "OhrmKpi.findByKpiIndicators", query = "SELECT o FROM OhrmKpi o WHERE o.kpiIndicators = :kpiIndicators"),
    @NamedQuery(name = "OhrmKpi.findByMinRating", query = "SELECT o FROM OhrmKpi o WHERE o.minRating = :minRating"),
    @NamedQuery(name = "OhrmKpi.findByMaxRating", query = "SELECT o FROM OhrmKpi o WHERE o.maxRating = :maxRating"),
    @NamedQuery(name = "OhrmKpi.findByDefaultKpi", query = "SELECT o FROM OhrmKpi o WHERE o.defaultKpi = :defaultKpi"),
    @NamedQuery(name = "OhrmKpi.findByDeletedAt", query = "SELECT o FROM OhrmKpi o WHERE o.deletedAt = :deletedAt")})
public class OhrmKpi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "job_title_code")
    private String jobTitleCode;
    @Column(name = "kpi_indicators")
    private String kpiIndicators;
    @Column(name = "min_rating")
    private Integer minRating;
    @Column(name = "max_rating")
    private Integer maxRating;
    @Column(name = "default_kpi")
    private Short defaultKpi;
    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    public OhrmKpi() {
    }

    public OhrmKpi(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitleCode() {
        return jobTitleCode;
    }

    public void setJobTitleCode(String jobTitleCode) {
        this.jobTitleCode = jobTitleCode;
    }

    public String getKpiIndicators() {
        return kpiIndicators;
    }

    public void setKpiIndicators(String kpiIndicators) {
        this.kpiIndicators = kpiIndicators;
    }

    public Integer getMinRating() {
        return minRating;
    }

    public void setMinRating(Integer minRating) {
        this.minRating = minRating;
    }

    public Integer getMaxRating() {
        return maxRating;
    }

    public void setMaxRating(Integer maxRating) {
        this.maxRating = maxRating;
    }

    public Short getDefaultKpi() {
        return defaultKpi;
    }

    public void setDefaultKpi(Short defaultKpi) {
        this.defaultKpi = defaultKpi;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
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
        if (!(object instanceof OhrmKpi)) {
            return false;
        }
        OhrmKpi other = (OhrmKpi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmKpi[ id=" + id + " ]";
    }
    
}
