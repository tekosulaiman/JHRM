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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ohrm_emp_education", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmEmpEducation.findAll", query = "SELECT o FROM OhrmEmpEducation o"),
    @NamedQuery(name = "OhrmEmpEducation.findById", query = "SELECT o FROM OhrmEmpEducation o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmEmpEducation.findByInstitute", query = "SELECT o FROM OhrmEmpEducation o WHERE o.institute = :institute"),
    @NamedQuery(name = "OhrmEmpEducation.findByMajor", query = "SELECT o FROM OhrmEmpEducation o WHERE o.major = :major"),
    @NamedQuery(name = "OhrmEmpEducation.findByYear", query = "SELECT o FROM OhrmEmpEducation o WHERE o.year = :year"),
    @NamedQuery(name = "OhrmEmpEducation.findByScore", query = "SELECT o FROM OhrmEmpEducation o WHERE o.score = :score"),
    @NamedQuery(name = "OhrmEmpEducation.findByStartDate", query = "SELECT o FROM OhrmEmpEducation o WHERE o.startDate = :startDate"),
    @NamedQuery(name = "OhrmEmpEducation.findByEndDate", query = "SELECT o FROM OhrmEmpEducation o WHERE o.endDate = :endDate")})
public class OhrmEmpEducation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "institute")
    private String institute;
    @Column(name = "major")
    private String major;
    @Column(name = "year")
    private Short year;
    @Column(name = "score")
    private String score;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number")
    @ManyToOne(optional = false)
    private HsHrEmployee empNumber;
    @JoinColumn(name = "education_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmEducation educationId;

    public OhrmEmpEducation() {
    }

    public OhrmEmpEducation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public HsHrEmployee getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(HsHrEmployee empNumber) {
        this.empNumber = empNumber;
    }

    public OhrmEducation getEducationId() {
        return educationId;
    }

    public void setEducationId(OhrmEducation educationId) {
        this.educationId = educationId;
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
        if (!(object instanceof OhrmEmpEducation)) {
            return false;
        }
        OhrmEmpEducation other = (OhrmEmpEducation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmEmpEducation[ id=" + id + " ]";
    }
    
}
