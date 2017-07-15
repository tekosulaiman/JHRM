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
@Table(name = "ohrm_selected_composite_display_field", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmSelectedCompositeDisplayField.findAll", query = "SELECT o FROM OhrmSelectedCompositeDisplayField o"),
    @NamedQuery(name = "OhrmSelectedCompositeDisplayField.findById", query = "SELECT o FROM OhrmSelectedCompositeDisplayField o WHERE o.ohrmSelectedCompositeDisplayFieldPK.id = :id"),
    @NamedQuery(name = "OhrmSelectedCompositeDisplayField.findByCompositeDisplayFieldId", query = "SELECT o FROM OhrmSelectedCompositeDisplayField o WHERE o.ohrmSelectedCompositeDisplayFieldPK.compositeDisplayFieldId = :compositeDisplayFieldId"),
    @NamedQuery(name = "OhrmSelectedCompositeDisplayField.findByReportId", query = "SELECT o FROM OhrmSelectedCompositeDisplayField o WHERE o.ohrmSelectedCompositeDisplayFieldPK.reportId = :reportId")})
public class OhrmSelectedCompositeDisplayField implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OhrmSelectedCompositeDisplayFieldPK ohrmSelectedCompositeDisplayFieldPK;
    @JoinColumn(name = "report_id", referencedColumnName = "report_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OhrmReport ohrmReport;
    @JoinColumn(name = "composite_display_field_id", referencedColumnName = "composite_display_field_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OhrmCompositeDisplayField ohrmCompositeDisplayField;

    public OhrmSelectedCompositeDisplayField() {
    }

    public OhrmSelectedCompositeDisplayField(OhrmSelectedCompositeDisplayFieldPK ohrmSelectedCompositeDisplayFieldPK) {
        this.ohrmSelectedCompositeDisplayFieldPK = ohrmSelectedCompositeDisplayFieldPK;
    }

    public OhrmSelectedCompositeDisplayField(long id, long compositeDisplayFieldId, long reportId) {
        this.ohrmSelectedCompositeDisplayFieldPK = new OhrmSelectedCompositeDisplayFieldPK(id, compositeDisplayFieldId, reportId);
    }

    public OhrmSelectedCompositeDisplayFieldPK getOhrmSelectedCompositeDisplayFieldPK() {
        return ohrmSelectedCompositeDisplayFieldPK;
    }

    public void setOhrmSelectedCompositeDisplayFieldPK(OhrmSelectedCompositeDisplayFieldPK ohrmSelectedCompositeDisplayFieldPK) {
        this.ohrmSelectedCompositeDisplayFieldPK = ohrmSelectedCompositeDisplayFieldPK;
    }

    public OhrmReport getOhrmReport() {
        return ohrmReport;
    }

    public void setOhrmReport(OhrmReport ohrmReport) {
        this.ohrmReport = ohrmReport;
    }

    public OhrmCompositeDisplayField getOhrmCompositeDisplayField() {
        return ohrmCompositeDisplayField;
    }

    public void setOhrmCompositeDisplayField(OhrmCompositeDisplayField ohrmCompositeDisplayField) {
        this.ohrmCompositeDisplayField = ohrmCompositeDisplayField;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ohrmSelectedCompositeDisplayFieldPK != null ? ohrmSelectedCompositeDisplayFieldPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmSelectedCompositeDisplayField)) {
            return false;
        }
        OhrmSelectedCompositeDisplayField other = (OhrmSelectedCompositeDisplayField) object;
        if ((this.ohrmSelectedCompositeDisplayFieldPK == null && other.ohrmSelectedCompositeDisplayFieldPK != null) || (this.ohrmSelectedCompositeDisplayFieldPK != null && !this.ohrmSelectedCompositeDisplayFieldPK.equals(other.ohrmSelectedCompositeDisplayFieldPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmSelectedCompositeDisplayField[ ohrmSelectedCompositeDisplayFieldPK=" + ohrmSelectedCompositeDisplayFieldPK + " ]";
    }
    
}
