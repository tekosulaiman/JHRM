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
@Table(name = "ohrm_oauth_authorization_code", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmOauthAuthorizationCode.findAll", query = "SELECT o FROM OhrmOauthAuthorizationCode o"),
    @NamedQuery(name = "OhrmOauthAuthorizationCode.findByAuthorizationCode", query = "SELECT o FROM OhrmOauthAuthorizationCode o WHERE o.authorizationCode = :authorizationCode"),
    @NamedQuery(name = "OhrmOauthAuthorizationCode.findByClientId", query = "SELECT o FROM OhrmOauthAuthorizationCode o WHERE o.clientId = :clientId"),
    @NamedQuery(name = "OhrmOauthAuthorizationCode.findByUserId", query = "SELECT o FROM OhrmOauthAuthorizationCode o WHERE o.userId = :userId"),
    @NamedQuery(name = "OhrmOauthAuthorizationCode.findByRedirectUri", query = "SELECT o FROM OhrmOauthAuthorizationCode o WHERE o.redirectUri = :redirectUri"),
    @NamedQuery(name = "OhrmOauthAuthorizationCode.findByExpires", query = "SELECT o FROM OhrmOauthAuthorizationCode o WHERE o.expires = :expires"),
    @NamedQuery(name = "OhrmOauthAuthorizationCode.findByScope", query = "SELECT o FROM OhrmOauthAuthorizationCode o WHERE o.scope = :scope")})
public class OhrmOauthAuthorizationCode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "authorization_code")
    private String authorizationCode;
    @Basic(optional = false)
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "user_id")
    private String userId;
    @Basic(optional = false)
    @Column(name = "redirect_uri")
    private String redirectUri;
    @Basic(optional = false)
    @Column(name = "expires")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expires;
    @Column(name = "scope")
    private String scope;

    public OhrmOauthAuthorizationCode() {
    }

    public OhrmOauthAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public OhrmOauthAuthorizationCode(String authorizationCode, String clientId, String redirectUri, Date expires) {
        this.authorizationCode = authorizationCode;
        this.clientId = clientId;
        this.redirectUri = redirectUri;
        this.expires = expires;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authorizationCode != null ? authorizationCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmOauthAuthorizationCode)) {
            return false;
        }
        OhrmOauthAuthorizationCode other = (OhrmOauthAuthorizationCode) object;
        if ((this.authorizationCode == null && other.authorizationCode != null) || (this.authorizationCode != null && !this.authorizationCode.equals(other.authorizationCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmOauthAuthorizationCode[ authorizationCode=" + authorizationCode + " ]";
    }
    
}
