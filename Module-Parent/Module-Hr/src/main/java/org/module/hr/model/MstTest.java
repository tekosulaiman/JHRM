/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "mst_test", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstTest.findAll", query = "SELECT m FROM MstTest m"),
    @NamedQuery(name = "MstTest.findById", query = "SELECT m FROM MstTest m WHERE m.id = :id"),
    @NamedQuery(name = "MstTest.findByName", query = "SELECT m FROM MstTest m WHERE m.name = :name"),
    @NamedQuery(name = "MstTest.findByDob", query = "SELECT m FROM MstTest m WHERE m.dob = :dob"),
    @NamedQuery(name = "MstTest.findBySex", query = "SELECT m FROM MstTest m WHERE m.sex = :sex"),
    @NamedQuery(name = "MstTest.findByAddress", query = "SELECT m FROM MstTest m WHERE m.address = :address")})
public class MstTest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "sex")
    private Character sex;
    @Column(name = "address")
    private String address;

    public MstTest() {
    }

    public MstTest(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        if (!(object instanceof MstTest)) {
            return false;
        }
        MstTest other = (MstTest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.MstTest[ id=" + id + " ]";
    }
    
}
