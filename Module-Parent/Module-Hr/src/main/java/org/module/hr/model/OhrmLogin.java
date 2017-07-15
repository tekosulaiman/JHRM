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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "ohrm_login", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmLogin.findAll", query = "SELECT o FROM OhrmLogin o"),
    @NamedQuery(name = "OhrmLogin.findById", query = "SELECT o FROM OhrmLogin o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmLogin.findByUserId", query = "SELECT o FROM OhrmLogin o WHERE o.userId = :userId"),
    @NamedQuery(name = "OhrmLogin.findByUserName", query = "SELECT o FROM OhrmLogin o WHERE o.userName = :userName"),
    @NamedQuery(name = "OhrmLogin.findByUserRolePredefined", query = "SELECT o FROM OhrmLogin o WHERE o.userRolePredefined = :userRolePredefined"),
    @NamedQuery(name = "OhrmLogin.findByLoginTime", query = "SELECT o FROM OhrmLogin o WHERE o.loginTime = :loginTime")})
public class OhrmLogin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "user_id")
    private long userId;
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @Lob
    @Column(name = "user_role_name")
    private String userRoleName;
    @Basic(optional = false)
    @Column(name = "user_role_predefined")
    private boolean userRolePredefined;
    @Basic(optional = false)
    @Column(name = "login_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginTime;

    public OhrmLogin() {
    }

    public OhrmLogin(Integer id) {
        this.id = id;
    }

    public OhrmLogin(Integer id, long userId, String userRoleName, boolean userRolePredefined, Date loginTime) {
        this.id = id;
        this.userId = userId;
        this.userRoleName = userRoleName;
        this.userRolePredefined = userRolePredefined;
        this.loginTime = loginTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public boolean getUserRolePredefined() {
        return userRolePredefined;
    }

    public void setUserRolePredefined(boolean userRolePredefined) {
        this.userRolePredefined = userRolePredefined;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
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
        if (!(object instanceof OhrmLogin)) {
            return false;
        }
        OhrmLogin other = (OhrmLogin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmLogin[ id=" + id + " ]";
    }
    
}
