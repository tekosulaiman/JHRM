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
@Table(name = "ohrm_composite_display_field", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmCompositeDisplayField.findAll", query = "SELECT o FROM OhrmCompositeDisplayField o"),
    @NamedQuery(name = "OhrmCompositeDisplayField.findByCompositeDisplayFieldId", query = "SELECT o FROM OhrmCompositeDisplayField o WHERE o.compositeDisplayFieldId = :compositeDisplayFieldId"),
    @NamedQuery(name = "OhrmCompositeDisplayField.findByName", query = "SELECT o FROM OhrmCompositeDisplayField o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmCompositeDisplayField.findByLabel", query = "SELECT o FROM OhrmCompositeDisplayField o WHERE o.label = :label"),
    @NamedQuery(name = "OhrmCompositeDisplayField.findByFieldAlias", query = "SELECT o FROM OhrmCompositeDisplayField o WHERE o.fieldAlias = :fieldAlias"),
    @NamedQuery(name = "OhrmCompositeDisplayField.findByIsSortable", query = "SELECT o FROM OhrmCompositeDisplayField o WHERE o.isSortable = :isSortable"),
    @NamedQuery(name = "OhrmCompositeDisplayField.findBySortOrder", query = "SELECT o FROM OhrmCompositeDisplayField o WHERE o.sortOrder = :sortOrder"),
    @NamedQuery(name = "OhrmCompositeDisplayField.findBySortField", query = "SELECT o FROM OhrmCompositeDisplayField o WHERE o.sortField = :sortField"),
    @NamedQuery(name = "OhrmCompositeDisplayField.findByElementType", query = "SELECT o FROM OhrmCompositeDisplayField o WHERE o.elementType = :elementType"),
    @NamedQuery(name = "OhrmCompositeDisplayField.findByElementProperty", query = "SELECT o FROM OhrmCompositeDisplayField o WHERE o.elementProperty = :elementProperty"),
    @NamedQuery(name = "OhrmCompositeDisplayField.findByWidth", query = "SELECT o FROM OhrmCompositeDisplayField o WHERE o.width = :width"),
    @NamedQuery(name = "OhrmCompositeDisplayField.findByIsExportable", query = "SELECT o FROM OhrmCompositeDisplayField o WHERE o.isExportable = :isExportable"),
    @NamedQuery(name = "OhrmCompositeDisplayField.findByTextAlignmentStyle", query = "SELECT o FROM OhrmCompositeDisplayField o WHERE o.textAlignmentStyle = :textAlignmentStyle"),
    @NamedQuery(name = "OhrmCompositeDisplayField.findByIsValueList", query = "SELECT o FROM OhrmCompositeDisplayField o WHERE o.isValueList = :isValueList"),
    @NamedQuery(name = "OhrmCompositeDisplayField.findByDefaultValue", query = "SELECT o FROM OhrmCompositeDisplayField o WHERE o.defaultValue = :defaultValue"),
    @NamedQuery(name = "OhrmCompositeDisplayField.findByIsEncrypted", query = "SELECT o FROM OhrmCompositeDisplayField o WHERE o.isEncrypted = :isEncrypted"),
    @NamedQuery(name = "OhrmCompositeDisplayField.findByIsMeta", query = "SELECT o FROM OhrmCompositeDisplayField o WHERE o.isMeta = :isMeta")})
public class OhrmCompositeDisplayField implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "composite_display_field_id")
    private Long compositeDisplayFieldId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
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
    @Basic(optional = false)
    @Column(name = "is_encrypted")
    private boolean isEncrypted;
    @Basic(optional = false)
    @Column(name = "is_meta")
    private boolean isMeta;
    @JoinColumn(name = "report_group_id", referencedColumnName = "report_group_id")
    @ManyToOne(optional = false)
    private OhrmReportGroup reportGroupId;
    @JoinColumn(name = "display_field_group_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmDisplayFieldGroup displayFieldGroupId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ohrmCompositeDisplayField")
    private List<OhrmSelectedCompositeDisplayField> ohrmSelectedCompositeDisplayFieldList;

    public OhrmCompositeDisplayField() {
    }

    public OhrmCompositeDisplayField(Long compositeDisplayFieldId) {
        this.compositeDisplayFieldId = compositeDisplayFieldId;
    }

    public OhrmCompositeDisplayField(Long compositeDisplayFieldId, String name, String label, String isSortable, String elementType, String elementProperty, String width, boolean isValueList, boolean isEncrypted, boolean isMeta) {
        this.compositeDisplayFieldId = compositeDisplayFieldId;
        this.name = name;
        this.label = label;
        this.isSortable = isSortable;
        this.elementType = elementType;
        this.elementProperty = elementProperty;
        this.width = width;
        this.isValueList = isValueList;
        this.isEncrypted = isEncrypted;
        this.isMeta = isMeta;
    }

    public Long getCompositeDisplayFieldId() {
        return compositeDisplayFieldId;
    }

    public void setCompositeDisplayFieldId(Long compositeDisplayFieldId) {
        this.compositeDisplayFieldId = compositeDisplayFieldId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean getIsEncrypted() {
        return isEncrypted;
    }

    public void setIsEncrypted(boolean isEncrypted) {
        this.isEncrypted = isEncrypted;
    }

    public boolean getIsMeta() {
        return isMeta;
    }

    public void setIsMeta(boolean isMeta) {
        this.isMeta = isMeta;
    }

    public OhrmReportGroup getReportGroupId() {
        return reportGroupId;
    }

    public void setReportGroupId(OhrmReportGroup reportGroupId) {
        this.reportGroupId = reportGroupId;
    }

    public OhrmDisplayFieldGroup getDisplayFieldGroupId() {
        return displayFieldGroupId;
    }

    public void setDisplayFieldGroupId(OhrmDisplayFieldGroup displayFieldGroupId) {
        this.displayFieldGroupId = displayFieldGroupId;
    }

    @XmlTransient
    public List<OhrmSelectedCompositeDisplayField> getOhrmSelectedCompositeDisplayFieldList() {
        return ohrmSelectedCompositeDisplayFieldList;
    }

    public void setOhrmSelectedCompositeDisplayFieldList(List<OhrmSelectedCompositeDisplayField> ohrmSelectedCompositeDisplayFieldList) {
        this.ohrmSelectedCompositeDisplayFieldList = ohrmSelectedCompositeDisplayFieldList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compositeDisplayFieldId != null ? compositeDisplayFieldId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmCompositeDisplayField)) {
            return false;
        }
        OhrmCompositeDisplayField other = (OhrmCompositeDisplayField) object;
        if ((this.compositeDisplayFieldId == null && other.compositeDisplayFieldId != null) || (this.compositeDisplayFieldId != null && !this.compositeDisplayFieldId.equals(other.compositeDisplayFieldId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmCompositeDisplayField[ compositeDisplayFieldId=" + compositeDisplayFieldId + " ]";
    }
    
}
