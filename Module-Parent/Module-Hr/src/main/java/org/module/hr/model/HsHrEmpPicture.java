/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "hs_hr_emp_picture", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrEmpPicture.findAll", query = "SELECT h FROM HsHrEmpPicture h"),
    @NamedQuery(name = "HsHrEmpPicture.findByEmpNumber", query = "SELECT h FROM HsHrEmpPicture h WHERE h.empNumber = :empNumber"),
    @NamedQuery(name = "HsHrEmpPicture.findByEpicFilename", query = "SELECT h FROM HsHrEmpPicture h WHERE h.epicFilename = :epicFilename"),
    @NamedQuery(name = "HsHrEmpPicture.findByEpicType", query = "SELECT h FROM HsHrEmpPicture h WHERE h.epicType = :epicType"),
    @NamedQuery(name = "HsHrEmpPicture.findByEpicFileSize", query = "SELECT h FROM HsHrEmpPicture h WHERE h.epicFileSize = :epicFileSize"),
    @NamedQuery(name = "HsHrEmpPicture.findByEpicFileWidth", query = "SELECT h FROM HsHrEmpPicture h WHERE h.epicFileWidth = :epicFileWidth"),
    @NamedQuery(name = "HsHrEmpPicture.findByEpicFileHeight", query = "SELECT h FROM HsHrEmpPicture h WHERE h.epicFileHeight = :epicFileHeight")})
public class HsHrEmpPicture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "emp_number")
    private Integer empNumber;
    @Lob
    @Column(name = "epic_picture")
    private byte[] epicPicture;
    @Column(name = "epic_filename")
    private String epicFilename;
    @Column(name = "epic_type")
    private String epicType;
    @Column(name = "epic_file_size")
    private String epicFileSize;
    @Column(name = "epic_file_width")
    private String epicFileWidth;
    @Column(name = "epic_file_height")
    private String epicFileHeight;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private HsHrEmployee hsHrEmployee;

    public HsHrEmpPicture() {
    }

    public HsHrEmpPicture(Integer empNumber) {
        this.empNumber = empNumber;
    }

    public Integer getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(Integer empNumber) {
        this.empNumber = empNumber;
    }

    public byte[] getEpicPicture() {
        return epicPicture;
    }

    public void setEpicPicture(byte[] epicPicture) {
        this.epicPicture = epicPicture;
    }

    public String getEpicFilename() {
        return epicFilename;
    }

    public void setEpicFilename(String epicFilename) {
        this.epicFilename = epicFilename;
    }

    public String getEpicType() {
        return epicType;
    }

    public void setEpicType(String epicType) {
        this.epicType = epicType;
    }

    public String getEpicFileSize() {
        return epicFileSize;
    }

    public void setEpicFileSize(String epicFileSize) {
        this.epicFileSize = epicFileSize;
    }

    public String getEpicFileWidth() {
        return epicFileWidth;
    }

    public void setEpicFileWidth(String epicFileWidth) {
        this.epicFileWidth = epicFileWidth;
    }

    public String getEpicFileHeight() {
        return epicFileHeight;
    }

    public void setEpicFileHeight(String epicFileHeight) {
        this.epicFileHeight = epicFileHeight;
    }

    public HsHrEmployee getHsHrEmployee() {
        return hsHrEmployee;
    }

    public void setHsHrEmployee(HsHrEmployee hsHrEmployee) {
        this.hsHrEmployee = hsHrEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empNumber != null ? empNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpPicture)) {
            return false;
        }
        HsHrEmpPicture other = (HsHrEmpPicture) object;
        if ((this.empNumber == null && other.empNumber != null) || (this.empNumber != null && !this.empNumber.equals(other.empNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpPicture[ empNumber=" + empNumber + " ]";
    }
    
}
