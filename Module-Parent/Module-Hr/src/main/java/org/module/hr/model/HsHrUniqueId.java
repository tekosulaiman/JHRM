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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "hs_hr_unique_id", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrUniqueId.findAll", query = "SELECT h FROM HsHrUniqueId h"),
    @NamedQuery(name = "HsHrUniqueId.findById", query = "SELECT h FROM HsHrUniqueId h WHERE h.id = :id"),
    @NamedQuery(name = "HsHrUniqueId.findByLastId", query = "SELECT h FROM HsHrUniqueId h WHERE h.lastId = :lastId"),
    @NamedQuery(name = "HsHrUniqueId.findByTableName", query = "SELECT h FROM HsHrUniqueId h WHERE h.tableName = :tableName"),
    @NamedQuery(name = "HsHrUniqueId.findByFieldName", query = "SELECT h FROM HsHrUniqueId h WHERE h.fieldName = :fieldName")})
public class HsHrUniqueId implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "last_id")
    private int lastId;
    @Basic(optional = false)
    @Column(name = "table_name")
    private String tableName;
    @Basic(optional = false)
    @Column(name = "field_name")
    private String fieldName;

    public HsHrUniqueId() {
    }

    public HsHrUniqueId(Integer id) {
        this.id = id;
    }

    public HsHrUniqueId(Integer id, int lastId, String tableName, String fieldName) {
        this.id = id;
        this.lastId = lastId;
        this.tableName = tableName;
        this.fieldName = fieldName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLastId() {
        return lastId;
    }

    public void setLastId(int lastId) {
        this.lastId = lastId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrUniqueId)) {
            return false;
        }
        HsHrUniqueId other = (HsHrUniqueId) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrUniqueId[ id=" + id + " ]";
    }
    
}
