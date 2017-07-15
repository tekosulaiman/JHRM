/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
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
@Table(name = "ohrm_selected_group_field", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmSelectedGroupField.findAll", query = "SELECT o FROM OhrmSelectedGroupField o"),
    @NamedQuery(name = "OhrmSelectedGroupField.findByGroupFieldId", query = "SELECT o FROM OhrmSelectedGroupField o WHERE o.ohrmSelectedGroupFieldPK.groupFieldId = :groupFieldId"),
    @NamedQuery(name = "OhrmSelectedGroupField.findBySummaryDisplayFieldId", query = "SELECT o FROM OhrmSelectedGroupField o WHERE o.ohrmSelectedGroupFieldPK.summaryDisplayFieldId = :summaryDisplayFieldId"),
    @NamedQuery(name = "OhrmSelectedGroupField.findByReportId", query = "SELECT o FROM OhrmSelectedGroupField o WHERE o.ohrmSelectedGroupFieldPK.reportId = :reportId")})
public class OhrmSelectedGroupField implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OhrmSelectedGroupFieldPK ohrmSelectedGroupFieldPK;
    @JoinColumn(name = "report_id", referencedColumnName = "report_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OhrmReport ohrmReport;
    @JoinColumn(name = "group_field_id", referencedColumnName = "group_field_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OhrmGroupField ohrmGroupField;
    @JoinColumn(name = "summary_display_field_id", referencedColumnName = "summary_display_field_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OhrmSummaryDisplayField ohrmSummaryDisplayField;

    public OhrmSelectedGroupField() {
    }

    public OhrmSelectedGroupField(OhrmSelectedGroupFieldPK ohrmSelectedGroupFieldPK) {
        this.ohrmSelectedGroupFieldPK = ohrmSelectedGroupFieldPK;
    }

    public OhrmSelectedGroupField(long groupFieldId, long summaryDisplayFieldId, long reportId) {
        this.ohrmSelectedGroupFieldPK = new OhrmSelectedGroupFieldPK(groupFieldId, summaryDisplayFieldId, reportId);
    }

    public OhrmSelectedGroupFieldPK getOhrmSelectedGroupFieldPK() {
        return ohrmSelectedGroupFieldPK;
    }

    public void setOhrmSelectedGroupFieldPK(OhrmSelectedGroupFieldPK ohrmSelectedGroupFieldPK) {
        this.ohrmSelectedGroupFieldPK = ohrmSelectedGroupFieldPK;
    }

    public OhrmReport getOhrmReport() {
        return ohrmReport;
    }

    public void setOhrmReport(OhrmReport ohrmReport) {
        this.ohrmReport = ohrmReport;
    }

    public OhrmGroupField getOhrmGroupField() {
        return ohrmGroupField;
    }

    public void setOhrmGroupField(OhrmGroupField ohrmGroupField) {
        this.ohrmGroupField = ohrmGroupField;
    }

    public OhrmSummaryDisplayField getOhrmSummaryDisplayField() {
        return ohrmSummaryDisplayField;
    }

    public void setOhrmSummaryDisplayField(OhrmSummaryDisplayField ohrmSummaryDisplayField) {
        this.ohrmSummaryDisplayField = ohrmSummaryDisplayField;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ohrmSelectedGroupFieldPK != null ? ohrmSelectedGroupFieldPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmSelectedGroupField)) {
            return false;
        }
        OhrmSelectedGroupField other = (OhrmSelectedGroupField) object;
        if ((this.ohrmSelectedGroupFieldPK == null && other.ohrmSelectedGroupFieldPK != null) || (this.ohrmSelectedGroupFieldPK != null && !this.ohrmSelectedGroupFieldPK.equals(other.ohrmSelectedGroupFieldPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmSelectedGroupField[ ohrmSelectedGroupFieldPK=" + ohrmSelectedGroupFieldPK + " ]";
    }
    
}
