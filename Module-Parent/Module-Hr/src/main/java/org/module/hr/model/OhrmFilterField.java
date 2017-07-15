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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "ohrm_filter_field", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmFilterField.findAll", query = "SELECT o FROM OhrmFilterField o"),
    @NamedQuery(name = "OhrmFilterField.findByFilterFieldId", query = "SELECT o FROM OhrmFilterField o WHERE o.filterFieldId = :filterFieldId"),
    @NamedQuery(name = "OhrmFilterField.findByName", query = "SELECT o FROM OhrmFilterField o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmFilterField.findByFilterFieldWidget", query = "SELECT o FROM OhrmFilterField o WHERE o.filterFieldWidget = :filterFieldWidget"),
    @NamedQuery(name = "OhrmFilterField.findByConditionNo", query = "SELECT o FROM OhrmFilterField o WHERE o.conditionNo = :conditionNo"),
    @NamedQuery(name = "OhrmFilterField.findByRequired", query = "SELECT o FROM OhrmFilterField o WHERE o.required = :required")})
public class OhrmFilterField implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "filter_field_id")
    private Long filterFieldId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "where_clause_part")
    private String whereClausePart;
    @Column(name = "filter_field_widget")
    private String filterFieldWidget;
    @Basic(optional = false)
    @Column(name = "condition_no")
    private int conditionNo;
    @Column(name = "required")
    private String required;
    @JoinColumn(name = "report_group_id", referencedColumnName = "report_group_id")
    @ManyToOne(optional = false)
    private OhrmReportGroup reportGroupId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ohrmFilterField")
    private List<OhrmSelectedFilterField> ohrmSelectedFilterFieldList;

    public OhrmFilterField() {
    }

    public OhrmFilterField(Long filterFieldId) {
        this.filterFieldId = filterFieldId;
    }

    public OhrmFilterField(Long filterFieldId, String name, String whereClausePart, int conditionNo) {
        this.filterFieldId = filterFieldId;
        this.name = name;
        this.whereClausePart = whereClausePart;
        this.conditionNo = conditionNo;
    }

    public Long getFilterFieldId() {
        return filterFieldId;
    }

    public void setFilterFieldId(Long filterFieldId) {
        this.filterFieldId = filterFieldId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWhereClausePart() {
        return whereClausePart;
    }

    public void setWhereClausePart(String whereClausePart) {
        this.whereClausePart = whereClausePart;
    }

    public String getFilterFieldWidget() {
        return filterFieldWidget;
    }

    public void setFilterFieldWidget(String filterFieldWidget) {
        this.filterFieldWidget = filterFieldWidget;
    }

    public int getConditionNo() {
        return conditionNo;
    }

    public void setConditionNo(int conditionNo) {
        this.conditionNo = conditionNo;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public OhrmReportGroup getReportGroupId() {
        return reportGroupId;
    }

    public void setReportGroupId(OhrmReportGroup reportGroupId) {
        this.reportGroupId = reportGroupId;
    }

    @XmlTransient
    public List<OhrmSelectedFilterField> getOhrmSelectedFilterFieldList() {
        return ohrmSelectedFilterFieldList;
    }

    public void setOhrmSelectedFilterFieldList(List<OhrmSelectedFilterField> ohrmSelectedFilterFieldList) {
        this.ohrmSelectedFilterFieldList = ohrmSelectedFilterFieldList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filterFieldId != null ? filterFieldId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmFilterField)) {
            return false;
        }
        OhrmFilterField other = (OhrmFilterField) object;
        if ((this.filterFieldId == null && other.filterFieldId != null) || (this.filterFieldId != null && !this.filterFieldId.equals(other.filterFieldId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmFilterField[ filterFieldId=" + filterFieldId + " ]";
    }
    
}
