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
public class OhrmSelectedDisplayFieldPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @Column(name = "display_field_id")
    private long displayFieldId;
    @Basic(optional = false)
    @Column(name = "report_id")
    private long reportId;

    public OhrmSelectedDisplayFieldPK() {
    }

    public OhrmSelectedDisplayFieldPK(long id, long displayFieldId, long reportId) {
        this.id = id;
        this.displayFieldId = displayFieldId;
        this.reportId = reportId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDisplayFieldId() {
        return displayFieldId;
    }

    public void setDisplayFieldId(long displayFieldId) {
        this.displayFieldId = displayFieldId;
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
        hash += (int) displayFieldId;
        hash += (int) reportId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmSelectedDisplayFieldPK)) {
            return false;
        }
        OhrmSelectedDisplayFieldPK other = (OhrmSelectedDisplayFieldPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.displayFieldId != other.displayFieldId) {
            return false;
        }
        if (this.reportId != other.reportId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmSelectedDisplayFieldPK[ id=" + id + ", displayFieldId=" + displayFieldId + ", reportId=" + reportId + " ]";
    }
    
}
