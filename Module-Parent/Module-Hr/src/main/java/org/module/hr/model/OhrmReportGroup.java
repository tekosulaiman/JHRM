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
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "ohrm_report_group", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmReportGroup.findAll", query = "SELECT o FROM OhrmReportGroup o"),
    @NamedQuery(name = "OhrmReportGroup.findByReportGroupId", query = "SELECT o FROM OhrmReportGroup o WHERE o.reportGroupId = :reportGroupId"),
    @NamedQuery(name = "OhrmReportGroup.findByName", query = "SELECT o FROM OhrmReportGroup o WHERE o.name = :name")})
public class OhrmReportGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "report_group_id")
    private Long reportGroupId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "core_sql")
    private String coreSql;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportGroupId")
    private List<OhrmCompositeDisplayField> ohrmCompositeDisplayFieldList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportGroupId")
    private List<OhrmFilterField> ohrmFilterFieldList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportGroupId")
    private List<OhrmDisplayFieldGroup> ohrmDisplayFieldGroupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportGroupId")
    private List<OhrmDisplayField> ohrmDisplayFieldList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportGroupId")
    private List<OhrmReport> ohrmReportList;

    public OhrmReportGroup() {
    }

    public OhrmReportGroup(Long reportGroupId) {
        this.reportGroupId = reportGroupId;
    }

    public OhrmReportGroup(Long reportGroupId, String name, String coreSql) {
        this.reportGroupId = reportGroupId;
        this.name = name;
        this.coreSql = coreSql;
    }

    public Long getReportGroupId() {
        return reportGroupId;
    }

    public void setReportGroupId(Long reportGroupId) {
        this.reportGroupId = reportGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoreSql() {
        return coreSql;
    }

    public void setCoreSql(String coreSql) {
        this.coreSql = coreSql;
    }

    @XmlTransient
    public List<OhrmCompositeDisplayField> getOhrmCompositeDisplayFieldList() {
        return ohrmCompositeDisplayFieldList;
    }

    public void setOhrmCompositeDisplayFieldList(List<OhrmCompositeDisplayField> ohrmCompositeDisplayFieldList) {
        this.ohrmCompositeDisplayFieldList = ohrmCompositeDisplayFieldList;
    }

    @XmlTransient
    public List<OhrmFilterField> getOhrmFilterFieldList() {
        return ohrmFilterFieldList;
    }

    public void setOhrmFilterFieldList(List<OhrmFilterField> ohrmFilterFieldList) {
        this.ohrmFilterFieldList = ohrmFilterFieldList;
    }

    @XmlTransient
    public List<OhrmDisplayFieldGroup> getOhrmDisplayFieldGroupList() {
        return ohrmDisplayFieldGroupList;
    }

    public void setOhrmDisplayFieldGroupList(List<OhrmDisplayFieldGroup> ohrmDisplayFieldGroupList) {
        this.ohrmDisplayFieldGroupList = ohrmDisplayFieldGroupList;
    }

    @XmlTransient
    public List<OhrmDisplayField> getOhrmDisplayFieldList() {
        return ohrmDisplayFieldList;
    }

    public void setOhrmDisplayFieldList(List<OhrmDisplayField> ohrmDisplayFieldList) {
        this.ohrmDisplayFieldList = ohrmDisplayFieldList;
    }

    @XmlTransient
    public List<OhrmReport> getOhrmReportList() {
        return ohrmReportList;
    }

    public void setOhrmReportList(List<OhrmReport> ohrmReportList) {
        this.ohrmReportList = ohrmReportList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportGroupId != null ? reportGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmReportGroup)) {
            return false;
        }
        OhrmReportGroup other = (OhrmReportGroup) object;
        if ((this.reportGroupId == null && other.reportGroupId != null) || (this.reportGroupId != null && !this.reportGroupId.equals(other.reportGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmReportGroup[ reportGroupId=" + reportGroupId + " ]";
    }
    
}
