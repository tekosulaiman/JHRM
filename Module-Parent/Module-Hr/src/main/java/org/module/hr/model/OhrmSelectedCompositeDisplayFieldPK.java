/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Tom
 */
@Embeddable
public class OhrmSelectedCompositeDisplayFieldPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @Column(name = "composite_display_field_id")
    private long compositeDisplayFieldId;
    @Basic(optional = false)
    @Column(name = "report_id")
    private long reportId;

    public OhrmSelectedCompositeDisplayFieldPK() {
    }

    public OhrmSelectedCompositeDisplayFieldPK(long id, long compositeDisplayFieldId, long reportId) {
        this.id = id;
        this.compositeDisplayFieldId = compositeDisplayFieldId;
        this.reportId = reportId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCompositeDisplayFieldId() {
        return compositeDisplayFieldId;
    }

    public void setCompositeDisplayFieldId(long compositeDisplayFieldId) {
        this.compositeDisplayFieldId = compositeDisplayFieldId;
    }

    public long getReportId() {
        return reportId;
    }

    public void setReportId(long reportId) {
        this.reportId = reportId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) compositeDisplayFieldId;
        hash += (int) reportId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmSelectedCompositeDisplayFieldPK)) {
            return false;
        }
        OhrmSelectedCompositeDisplayFieldPK other = (OhrmSelectedCompositeDisplayFieldPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.compositeDisplayFieldId != other.compositeDisplayFieldId) {
            return false;
        }
        if (this.reportId != other.reportId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmSelectedCompositeDisplayFieldPK[ id=" + id + ", compositeDisplayFieldId=" + compositeDisplayFieldId + ", reportId=" + reportId + " ]";
    }
    
}
