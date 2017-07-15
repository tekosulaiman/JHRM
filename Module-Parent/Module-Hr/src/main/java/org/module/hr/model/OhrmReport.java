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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ohrm_report", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmReport.findAll", query = "SELECT o FROM OhrmReport o"),
    @NamedQuery(name = "OhrmReport.findByReportId", query = "SELECT o FROM OhrmReport o WHERE o.reportId = :reportId"),
    @NamedQuery(name = "OhrmReport.findByName", query = "SELECT o FROM OhrmReport o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmReport.findByUseFilterField", query = "SELECT o FROM OhrmReport o WHERE o.useFilterField = :useFilterField"),
    @NamedQuery(name = "OhrmReport.findByType", query = "SELECT o FROM OhrmReport o WHERE o.type = :type")})
public class OhrmReport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "report_id")
    private Long reportId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "use_filter_field")
    private boolean useFilterField;
    @Column(name = "type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ohrmReport")
    private List<OhrmSelectedGroupField> ohrmSelectedGroupFieldList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ohrmReport")
    private List<OhrmSelectedFilterField> ohrmSelectedFilterFieldList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportId")
    private List<OhrmSelectedDisplayFieldGroup> ohrmSelectedDisplayFieldGroupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ohrmReport")
    private List<OhrmSelectedCompositeDisplayField> ohrmSelectedCompositeDisplayFieldList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ohrmReport")
    private List<OhrmSelectedDisplayField> ohrmSelectedDisplayFieldList;
    @JoinColumn(name = "report_group_id", referencedColumnName = "report_group_id")
    @ManyToOne(optional = false)
    private OhrmReportGroup reportGroupId;

    public OhrmReport() {
    }

    public OhrmReport(Long reportId) {
        this.reportId = reportId;
    }

    public OhrmReport(Long reportId, String name, boolean useFilterField) {
        this.reportId = reportId;
        this.name = name;
        this.useFilterField = useFilterField;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getUseFilterField() {
        return useFilterField;
    }

    public void setUseFilterField(boolean useFilterField) {
        this.useFilterField = useFilterField;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public List<OhrmSelectedGroupField> getOhrmSelectedGroupFieldList() {
        return ohrmSelectedGroupFieldList;
    }

    public void setOhrmSelectedGroupFieldList(List<OhrmSelectedGroupField> ohrmSelectedGroupFieldList) {
        this.ohrmSelectedGroupFieldList = ohrmSelectedGroupFieldList;
    }

    @XmlTransient
    public List<OhrmSelectedFilterField> getOhrmSelectedFilterFieldList() {
        return ohrmSelectedFilterFieldList;
    }

    public void setOhrmSelectedFilterFieldList(List<OhrmSelectedFilterField> ohrmSelectedFilterFieldList) {
        this.ohrmSelectedFilterFieldList = ohrmSelectedFilterFieldList;
    }

    @XmlTransient
    public List<OhrmSelectedDisplayFieldGroup> getOhrmSelectedDisplayFieldGroupList() {
        return ohrmSelectedDisplayFieldGroupList;
    }

    public void setOhrmSelectedDisplayFieldGroupList(List<OhrmSelectedDisplayFieldGroup> ohrmSelectedDisplayFieldGroupList) {
        this.ohrmSelectedDisplayFieldGroupList = ohrmSelectedDisplayFieldGroupList;
    }

    @XmlTransient
    public List<OhrmSelectedCompositeDisplayField> getOhrmSelectedCompositeDisplayFieldList() {
        return ohrmSelectedCompositeDisplayFieldList;
    }

    public void setOhrmSelectedCompositeDisplayFieldList(List<OhrmSelectedCompositeDisplayField> ohrmSelectedCompositeDisplayFieldList) {
        this.ohrmSelectedCompositeDisplayFieldList = ohrmSelectedCompositeDisplayFieldList;
    }

    @XmlTransient
    public List<OhrmSelectedDisplayField> getOhrmSelectedDisplayFieldList() {
        return ohrmSelectedDisplayFieldList;
    }

    public void setOhrmSelectedDisplayFieldList(List<OhrmSelectedDisplayField> ohrmSelectedDisplayFieldList) {
        this.ohrmSelectedDisplayFieldList = ohrmSelectedDisplayFieldList;
    }

    public OhrmReportGroup getReportGroupId() {
        return reportGroupId;
    }

    public void setReportGroupId(OhrmReportGroup reportGroupId) {
        this.reportGroupId = reportGroupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportId != null ? reportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmReport)) {
            return false;
        }
        OhrmReport other = (OhrmReport) object;
        if ((this.reportId == null && other.reportId != null) || (this.reportId != null && !this.reportId.equals(other.reportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmReport[ reportId=" + reportId + " ]";
    }
    
}
