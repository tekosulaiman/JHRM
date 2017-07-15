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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "hs_hr_custom_fields", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrCustomFields.findAll", query = "SELECT h FROM HsHrCustomFields h"),
    @NamedQuery(name = "HsHrCustomFields.findByFieldNum", query = "SELECT h FROM HsHrCustomFields h WHERE h.fieldNum = :fieldNum"),
    @NamedQuery(name = "HsHrCustomFields.findByName", query = "SELECT h FROM HsHrCustomFields h WHERE h.name = :name"),
    @NamedQuery(name = "HsHrCustomFields.findByType", query = "SELECT h FROM HsHrCustomFields h WHERE h.type = :type"),
    @NamedQuery(name = "HsHrCustomFields.findByScreen", query = "SELECT h FROM HsHrCustomFields h WHERE h.screen = :screen"),
    @NamedQuery(name = "HsHrCustomFields.findByExtraData", query = "SELECT h FROM HsHrCustomFields h WHERE h.extraData = :extraData")})
public class HsHrCustomFields implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "field_num")
    private Integer fieldNum;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "type")
    private int type;
    @Column(name = "screen")
    private String screen;
    @Column(name = "extra_data")
    private String extraData;

    public HsHrCustomFields() {
    }

    public HsHrCustomFields(Integer fieldNum) {
        this.fieldNum = fieldNum;
    }

    public HsHrCustomFields(Integer fieldNum, String name, int type) {
        this.fieldNum = fieldNum;
        this.name = name;
        this.type = type;
    }

    public Integer getFieldNum() {
        return fieldNum;
    }

    public void setFieldNum(Integer fieldNum) {
        this.fieldNum = fieldNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fieldNum != null ? fieldNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrCustomFields)) {
            return false;
        }
        HsHrCustomFields other = (HsHrCustomFields) object;
        if ((this.fieldNum == null && other.fieldNum != null) || (this.fieldNum != null && !this.fieldNum.equals(other.fieldNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrCustomFields[ fieldNum=" + fieldNum + " ]";
    }
    
}
