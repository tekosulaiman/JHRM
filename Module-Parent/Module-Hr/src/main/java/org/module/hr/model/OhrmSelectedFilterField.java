/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_selected_filter_field", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmSelectedFilterField.findAll", query = "SELECT o FROM OhrmSelectedFilterField o"),
    @NamedQuery(name = "OhrmSelectedFilterField.findByReportId", query = "SELECT o FROM OhrmSelectedFilterField o WHERE o.ohrmSelectedFilterFieldPK.reportId = :reportId"),
    @NamedQuery(name = "OhrmSelectedFilterField.findByFilterFieldId", query = "SELECT o FROM OhrmSelectedFilterField o WHERE o.ohrmSelectedFilterFieldPK.filterFieldId = :filterFieldId"),
    @NamedQuery(name = "OhrmSelectedFilterField.findByFilterFieldOrder", query = "SELECT o FROM OhrmSelectedFilterField o WHERE o.filterFieldOrder = :filterFieldOrder"),
    @NamedQuery(name = "OhrmSelectedFilterField.findByValue1", query = "SELECT o FROM OhrmSelectedFilterField o WHERE o.value1 = :value1"),
    @NamedQuery(name = "OhrmSelectedFilterField.findByValue2", query = "SELECT o FROM OhrmSelectedFilterField o WHERE o.value2 = :value2"),
    @NamedQuery(name = "OhrmSelectedFilterField.findByWhereCondition", query = "SELECT o FROM OhrmSelectedFilterField o WHERE o.whereCondition = :whereCondition"),
    @NamedQuery(name = "OhrmSelectedFilterField.findByType", query = "SELECT o FROM OhrmSelectedFilterField o WHERE o.type = :type")})
public class OhrmSelectedFilterField implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OhrmSelectedFilterFieldPK ohrmSelectedFilterFieldPK;
    @Basic(optional = false)
    @Column(name = "filter_field_order")
    private long filterFieldOrder;
    @Column(name = "value1")
    private String value1;
    @Column(name = "value2")
    private String value2;
    @Column(name = "where_condition")
    private String whereCondition;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "report_id", referencedColumnName = "report_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OhrmReport ohrmReport;
    @JoinColumn(name = "filter_field_id", referencedColumnName = "filter_field_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OhrmFilterField ohrmFilterField;

    public OhrmSelectedFilterField() {
    }

    public OhrmSelectedFilterField(OhrmSelectedFilterFieldPK ohrmSelectedFilterFieldPK) {
        this.ohrmSelectedFilterFieldPK = ohrmSelectedFilterFieldPK;
    }

    public OhrmSelectedFilterField(OhrmSelectedFilterFieldPK ohrmSelectedFilterFieldPK, long filterFieldOrder, String type) {
        this.ohrmSelectedFilterFieldPK = ohrmSelectedFilterFieldPK;
        this.filterFieldOrder = filterFieldOrder;
        this.type = type;
    }

    public OhrmSelectedFilterField(long reportId, long filterFieldId) {
        this.ohrmSelectedFilterFieldPK = new OhrmSelectedFilterFieldPK(reportId, filterFieldId);
    }

    public OhrmSelectedFilterFieldPK getOhrmSelectedFilterFieldPK() {
        return ohrmSelectedFilterFieldPK;
    }

    public void setOhrmSelectedFilterFieldPK(OhrmSelectedFilterFieldPK ohrmSelectedFilterFieldPK) {
        this.ohrmSelectedFilterFieldPK = ohrmSelectedFilterFieldPK;
    }

    public long getFilterFieldOrder() {
        return filterFieldOrder;
    }

    public void setFilterFieldOrder(long filterFieldOrder) {
        this.filterFieldOrder = filterFieldOrder;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getWhereCondition() {
        return whereCondition;
    }

    public void setWhereCondition(String whereCondition) {
        this.whereCondition = whereCondition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public OhrmReport getOhrmReport() {
        return ohrmReport;
    }

    public void setOhrmReport(OhrmReport ohrmReport) {
        this.ohrmReport = ohrmReport;
    }

    public OhrmFilterField getOhrmFilterField() {
        return ohrmFilterField;
    }

    public void setOhrmFilterField(OhrmFilterField ohrmFilterField) {
        this.ohrmFilterField = ohrmFilterField;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ohrmSelectedFilterFieldPK != null ? ohrmSelectedFilterFieldPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmSelectedFilterField)) {
            return false;
        }
        OhrmSelectedFilterField other = (OhrmSelectedFilterField) object;
        if ((this.ohrmSelectedFilterFieldPK == null && other.ohrmSelectedFilterFieldPK != null) || (this.ohrmSelectedFilterFieldPK != null && !this.ohrmSelectedFilterFieldPK.equals(other.ohrmSelectedFilterFieldPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmSelectedFilterField[ ohrmSelectedFilterFieldPK=" + ohrmSelectedFilterFieldPK + " ]";
    }
    
}
