package org.module.hr.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
*
* @author tekosulaiman@yahoo.com
*/
@Entity
@Table(name = "mst_leave_type", catalog = "dbhr", schema = "schema_hr")
public class MstLeaveType implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_leave_type")
    private Integer idLeaveType;
    
    @Column(name = "type")
    private String type;
    
    @OneToMany(mappedBy = "idLeaveType")
    private List<TrsLeave> trsLeaveList;

    public MstLeaveType() {
    }

    public MstLeaveType(Integer idLeaveType) {
        this.idLeaveType = idLeaveType;
    }

    public Integer getIdLeaveType() {
        return idLeaveType;
    }

    public void setIdLeaveType(Integer idLeaveType) {
        this.idLeaveType = idLeaveType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public List<TrsLeave> getTrsLeaveList() {
        return trsLeaveList;
    }

    public void setTrsLeaveList(List<TrsLeave> trsLeaveList) {
        this.trsLeaveList = trsLeaveList;
    }
}