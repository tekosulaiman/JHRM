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
public class OhrmSelectedGroupFieldPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "group_field_id")
    private long groupFieldId;
    @Basic(optional = false)
    @Column(name = "summary_display_field_id")
    private long summaryDisplayFieldId;
    @Basic(optional = false)
    @Column(name = "report_id")
    private long reportId;

    public OhrmSelectedGroupFieldPK() {
    }

    public OhrmSelectedGroupFieldPK(long groupFieldId, long summaryDisplayFieldId, long reportId) {
        this.groupFieldId = groupFieldId;
        this.summaryDisplayFieldId = summaryDisplayFieldId;
        this.reportId = reportId;
    }

    public long getGroupFieldId() {
        return groupFieldId;
    }

    public void setGroupFieldId(long groupFieldId) {
        this.groupFieldId = groupFieldId;
    }

    public long getSummaryDisplayFieldId() {
        return summaryDisplayFieldId;
    }

    public void setSummaryDisplayFieldId(long summaryDisplayFieldId) {
        this.summaryDisplayFieldId = summaryDisplayFieldId;
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
        hash += (int) groupFieldId;
        hash += (int) summaryDisplayFieldId;
        hash += (int) reportId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmSelectedGroupFieldPK)) {
            return false;
        }
        OhrmSelectedGroupFieldPK other = (OhrmSelectedGroupFieldPK) object;
        if (this.groupFieldId != other.groupFieldId) {
            return false;
        }
        if (this.summaryDisplayFieldId != other.summaryDisplayFieldId) {
            return false;
        }
        if (this.reportId != other.reportId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmSelectedGroupFieldPK[ groupFieldId=" + groupFieldId + ", summaryDisplayFieldId=" + summaryDisplayFieldId + ", reportId=" + reportId + " ]";
    }
    
}
