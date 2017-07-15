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
@Table(name = "ohrm_emp_reporting_method", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmEmpReportingMethod.findAll", query = "SELECT o FROM OhrmEmpReportingMethod o"),
    @NamedQuery(name = "OhrmEmpReportingMethod.findByReportingMethodId", query = "SELECT o FROM OhrmEmpReportingMethod o WHERE o.reportingMethodId = :reportingMethodId"),
    @NamedQuery(name = "OhrmEmpReportingMethod.findByReportingMethodName", query = "SELECT o FROM OhrmEmpReportingMethod o WHERE o.reportingMethodName = :reportingMethodName")})
public class OhrmEmpReportingMethod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reporting_method_id")
    private Integer reportingMethodId;
    @Basic(optional = false)
    @Column(name = "reporting_method_name")
    private String reportingMethodName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ohrmEmpReportingMethod")
    private List<HsHrEmpReportto> hsHrEmpReporttoList;

    public OhrmEmpReportingMethod() {
    }

    public OhrmEmpReportingMethod(Integer reportingMethodId) {
        this.reportingMethodId = reportingMethodId;
    }

    public OhrmEmpReportingMethod(Integer reportingMethodId, String reportingMethodName) {
        this.reportingMethodId = reportingMethodId;
        this.reportingMethodName = reportingMethodName;
    }

    public Integer getReportingMethodId() {
        return reportingMethodId;
    }

    public void setReportingMethodId(Integer reportingMethodId) {
        this.reportingMethodId = reportingMethodId;
    }

    public String getReportingMethodName() {
        return reportingMethodName;
    }

    public void setReportingMethodName(String reportingMethodName) {
        this.reportingMethodName = reportingMethodName;
    }

    @XmlTransient
    public List<HsHrEmpReportto> getHsHrEmpReporttoList() {
        return hsHrEmpReporttoList;
    }

    public void setHsHrEmpReporttoList(List<HsHrEmpReportto> hsHrEmpReporttoList) {
        this.hsHrEmpReporttoList = hsHrEmpReporttoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportingMethodId != null ? reportingMethodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmEmpReportingMethod)) {
            return false;
        }
        OhrmEmpReportingMethod other = (OhrmEmpReportingMethod) object;
        if ((this.reportingMethodId == null && other.reportingMethodId != null) || (this.reportingMethodId != null && !this.reportingMethodId.equals(other.reportingMethodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmEmpReportingMethod[ reportingMethodId=" + reportingMethodId + " ]";
    }
    
}
