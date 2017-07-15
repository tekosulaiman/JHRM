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
@Table(name = "ohrm_selected_display_field", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmSelectedDisplayField.findAll", query = "SELECT o FROM OhrmSelectedDisplayField o"),
    @NamedQuery(name = "OhrmSelectedDisplayField.findById", query = "SELECT o FROM OhrmSelectedDisplayField o WHERE o.ohrmSelectedDisplayFieldPK.id = :id"),
    @NamedQuery(name = "OhrmSelectedDisplayField.findByDisplayFieldId", query = "SELECT o FROM OhrmSelectedDisplayField o WHERE o.ohrmSelectedDisplayFieldPK.displayFieldId = :displayFieldId"),
    @NamedQuery(name = "OhrmSelectedDisplayField.findByReportId", query = "SELECT o FROM OhrmSelectedDisplayField o WHERE o.ohrmSelectedDisplayFieldPK.reportId = :reportId")})
public class OhrmSelectedDisplayField implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OhrmSelectedDisplayFieldPK ohrmSelectedDisplayFieldPK;
    @JoinColumn(name = "report_id", referencedColumnName = "report_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OhrmReport ohrmReport;
    @JoinColumn(name = "display_field_id", referencedColumnName = "display_field_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OhrmDisplayField ohrmDisplayField;

    public OhrmSelectedDisplayField() {
    }

    public OhrmSelectedDisplayField(OhrmSelectedDisplayFieldPK ohrmSelectedDisplayFieldPK) {
        this.ohrmSelectedDisplayFieldPK = ohrmSelectedDisplayFieldPK;
    }

    public OhrmSelectedDisplayField(long id, long displayFieldId, long reportId) {
        this.ohrmSelectedDisplayFieldPK = new OhrmSelectedDisplayFieldPK(id, displayFieldId, reportId);
    }

    public OhrmSelectedDisplayFieldPK getOhrmSelectedDisplayFieldPK() {
        return ohrmSelectedDisplayFieldPK;
    }

    public void setOhrmSelectedDisplayFieldPK(OhrmSelectedDisplayFieldPK ohrmSelectedDisplayFieldPK) {
        this.ohrmSelectedDisplayFieldPK = ohrmSelectedDisplayFieldPK;
    }

    public OhrmReport getOhrmReport() {
        return ohrmReport;
    }

    public void setOhrmReport(OhrmReport ohrmReport) {
        this.ohrmReport = ohrmReport;
    }

    public OhrmDisplayField getOhrmDisplayField() {
        return ohrmDisplayField;
    }

    public void setOhrmDisplayField(OhrmDisplayField ohrmDisplayField) {
        this.ohrmDisplayField = ohrmDisplayField;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ohrmSelectedDisplayFieldPK != null ? ohrmSelectedDisplayFieldPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmSelectedDisplayField)) {
            return false;
        }
        OhrmSelectedDisplayField other = (OhrmSelectedDisplayField) object;
        if ((this.ohrmSelectedDisplayFieldPK == null && other.ohrmSelectedDisplayFieldPK != null) || (this.ohrmSelectedDisplayFieldPK != null && !this.ohrmSelectedDisplayFieldPK.equals(other.ohrmSelectedDisplayFieldPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmSelectedDisplayField[ ohrmSelectedDisplayFieldPK=" + ohrmSelectedDisplayFieldPK + " ]";
    }
    
}
