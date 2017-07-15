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
@Table(name = "ohrm_oauth_client", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmOauthClient.findAll", query = "SELECT o FROM OhrmOauthClient o"),
    @NamedQuery(name = "OhrmOauthClient.findByClientId", query = "SELECT o FROM OhrmOauthClient o WHERE o.clientId = :clientId"),
    @NamedQuery(name = "OhrmOauthClient.findByClientSecret", query = "SELECT o FROM OhrmOauthClient o WHERE o.clientSecret = :clientSecret"),
    @NamedQuery(name = "OhrmOauthClient.findByRedirectUri", query = "SELECT o FROM OhrmOauthClient o WHERE o.redirectUri = :redirectUri")})
public class OhrmOauthClient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "client_id")
    private String clientId;
    @Basic(optional = false)
    @Column(name = "client_secret")
    private String clientSecret;
    @Basic(optional = false)
    @Column(name = "redirect_uri")
    private String redirectUri;

    public OhrmOauthClient() {
    }

    public OhrmOauthClient(String clientId) {
        this.clientId = clientId;
    }

    public OhrmOauthClient(String clientId, String clientSecret, String redirectUri) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientId != null ? clientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmOauthClient)) {
            return false;
        }
        OhrmOauthClient other = (OhrmOauthClient) object;
        if ((this.clientId == null && other.clientId != null) || (this.clientId != null && !this.clientId.equals(other.clientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmOauthClient[ clientId=" + clientId + " ]";
    }
    
}
