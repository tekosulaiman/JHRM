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
@Table(name = "ohrm_oauth_user", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmOauthUser.findAll", query = "SELECT o FROM OhrmOauthUser o"),
    @NamedQuery(name = "OhrmOauthUser.findByUsername", query = "SELECT o FROM OhrmOauthUser o WHERE o.username = :username"),
    @NamedQuery(name = "OhrmOauthUser.findByPassword", query = "SELECT o FROM OhrmOauthUser o WHERE o.password = :password"),
    @NamedQuery(name = "OhrmOauthUser.findByFirstName", query = "SELECT o FROM OhrmOauthUser o WHERE o.firstName = :firstName"),
    @NamedQuery(name = "OhrmOauthUser.findByLastName", query = "SELECT o FROM OhrmOauthUser o WHERE o.lastName = :lastName")})
public class OhrmOauthUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public OhrmOauthUser() {
    }

    public OhrmOauthUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmOauthUser)) {
            return false;
        }
        OhrmOauthUser other = (OhrmOauthUser) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmOauthUser[ username=" + username + " ]";
    }
    
}
