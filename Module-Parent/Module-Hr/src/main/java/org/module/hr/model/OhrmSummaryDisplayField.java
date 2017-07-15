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
@Table(name = "ohrm_summary_display_field", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmSummaryDisplayField.findAll", query = "SELECT o FROM OhrmSummaryDisplayField o"),
    @NamedQuery(name = "OhrmSummaryDisplayField.findBySummaryDisplayFieldId", query = "SELECT o FROM OhrmSummaryDisplayField o WHERE o.summaryDisplayFieldId = :summaryDisplayFieldId"),
    @NamedQuery(name = "OhrmSummaryDisplayField.findByFunction", query = "SELECT o FROM OhrmSummaryDisplayField o WHERE o.function = :function"),
    @NamedQuery(name = "OhrmSummaryDisplayField.findByLabel", query = "SELECT o FROM OhrmSummaryDisplayField o WHERE o.label = :label"),
    @NamedQuery(name = "OhrmSummaryDisplayField.findByFieldAlias", query = "SELECT o FROM OhrmSummaryDisplayField o WHERE o.fieldAlias = :fieldAlias"),
    @NamedQuery(name = "OhrmSummaryDisplayField.findByIsSortable", query = "SELECT o FROM OhrmSummaryDisplayField o WHERE o.isSortable = :isSortable"),
    @NamedQuery(name = "OhrmSummaryDisplayField.findBySortOrder", query = "SELECT o FROM OhrmSummaryDisplayField o WHERE o.sortOrder = :sortOrder"),
    @NamedQuery(name = "OhrmSummaryDisplayField.findBySortField", query = "SELECT o FROM OhrmSummaryDisplayField o WHERE o.sortField = :sortField"),
    @NamedQuery(name = "OhrmSummaryDisplayField.findByElementType", query = "SELECT o FROM OhrmSummaryDisplayField o WHERE o.elementType = :elementType"),
    @NamedQuery(name = "OhrmSummaryDisplayField.findByElementProperty", query = "SELECT o FROM OhrmSummaryDisplayField o WHERE o.elementProperty = :elementProperty"),
    @NamedQuery(name = "OhrmSummaryDisplayField.findByWidth", query = "SELECT o FROM OhrmSummaryDisplayField o WHERE o.width = :width"),
    @NamedQuery(name = "OhrmSummaryDisplayField.findByIsExportable", query = "SELECT o FROM OhrmSummaryDisplayField o WHERE o.isExportable = :isExportable"),
    @NamedQuery(name = "OhrmSummaryDisplayField.findByTextAlignmentStyle", query = "SELECT o FROM OhrmSummaryDisplayField o WHERE o.textAlignmentStyle = :textAlignmentStyle"),
    @NamedQuery(name = "OhrmSummaryDisplayField.findByIsValueList", query = "SELECT o FROM OhrmSummaryDisplayField o WHERE o.isValueList = :isValueList"),
    @NamedQuery(name = "OhrmSummaryDisplayField.findByDefaultValue", query = "SELECT o FROM OhrmSummaryDisplayField o WHERE o.defaultValue = :defaultValue")})
public class OhrmSummaryDisplayField implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "summary_display_field_id")
    private Long summaryDisplayFieldId;
    @Basic(optional = false)
    @Column(name = "function")
    private String function;
    @Basic(optional = false)
    @Column(name = "label")
    private String label;
    @Column(name = "field_alias")
    private String fieldAlias;
    @Basic(optional = false)
    @Column(name = "is_sortable")
    private String isSortable;
    @Column(name = "sort_order")
    private String sortOrder;
    @Column(name = "sort_field")
    private String sortField;
    @Basic(optional = false)
    @Column(name = "element_type")
    private String elementType;
    @Basic(optional = false)
    @Column(name = "element_property")
    private String elementProperty;
    @Basic(optional = false)
    @Column(name = "width")
    private String width;
    @Column(name = "is_exportable")
    private String isExportable;
    @Column(name = "text_alignment_style")
    private String textAlignmentStyle;
    @Basic(optional = false)
    @Column(name = "is_value_list")
    private boolean isValueList;
    @Column(name = "default_value")
    private String defaultValue;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ohrmSummaryDisplayField")
    private List<OhrmSelectedGroupField> ohrmSelectedGroupFieldList;
    @JoinColumn(name = "display_field_group_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmDisplayFieldGroup displayFieldGroupId;

    public OhrmSummaryDisplayField() {
    }

    public OhrmSummaryDisplayField(Long summaryDisplayFieldId) {
        this.summaryDisplayFieldId = summaryDisplayFieldId;
    }

    public OhrmSummaryDisplayField(Long summaryDisplayFieldId, String function, String label, String isSortable, String elementType, String elementProperty, String width, boolean isValueList) {
        this.summaryDisplayFieldId = summaryDisplayFieldId;
        this.function = function;
        this.label = label;
        this.isSortable = isSortable;
        this.elementType = elementType;
        this.elementProperty = elementProperty;
        this.width = width;
        this.isValueList = isValueList;
    }

    public Long getSummaryDisplayFieldId() {
        return summaryDisplayFieldId;
    }

    public void setSummaryDisplayFieldId(Long summaryDisplayFieldId) {
        this.summaryDisplayFieldId = summaryDisplayFieldId;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFieldAlias() {
        return fieldAlias;
    }

    public void setFieldAlias(String fieldAlias) {
        this.fieldAlias = fieldAlias;
    }

    public String getIsSortable() {
        return isSortable;
    }

    public void setIsSortable(String isSortable) {
        this.isSortable = isSortable;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getElementProperty() {
        return elementProperty;
    }

    public void setElementProperty(String elementProperty) {
        this.elementProperty = elementProperty;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getIsExportable() {
        return isExportable;
    }

    public void setIsExportable(String isExportable) {
        this.isExportable = isExportable;
    }

    public String getTextAlignmentStyle() {
        return textAlignmentStyle;
    }

    public void setTextAlignmentStyle(String textAlignmentStyle) {
        this.textAlignmentStyle = textAlignmentStyle;
    }

    public boolean getIsValueList() {
        return isValueList;
    }

    public void setIsValueList(boolean isValueList) {
        this.isValueList = isValueList;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @XmlTransient
    public List<OhrmSelectedGroupField> getOhrmSelectedGroupFieldList() {
        return ohrmSelectedGroupFieldList;
    }

    public void setOhrmSelectedGroupFieldList(List<OhrmSelectedGroupField> ohrmSelectedGroupFieldList) {
        this.ohrmSelectedGroupFieldList = ohrmSelectedGroupFieldList;
    }

    public OhrmDisplayFieldGroup getDisplayFieldGroupId() {
        return displayFieldGroupId;
    }

    public void setDisplayFieldGroupId(OhrmDisplayFieldGroup displayFieldGroupId) {
        this.displayFieldGroupId = displayFieldGroupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (summaryDisplayFieldId != null ? summaryDisplayFieldId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmSummaryDisplayField)) {
            return false;
        }
        OhrmSummaryDisplayField other = (OhrmSummaryDisplayField) object;
        if ((this.summaryDisplayFieldId == null && other.summaryDisplayFieldId != null) || (this.summaryDisplayFieldId != null && !this.summaryDisplayFieldId.equals(other.summaryDisplayFieldId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmSummaryDisplayField[ summaryDisplayFieldId=" + summaryDisplayFieldId + " ]";
    }
    
}
