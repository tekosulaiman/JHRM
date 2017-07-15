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
@Table(name = "ohrm_email_configuration", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmEmailConfiguration.findAll", query = "SELECT o FROM OhrmEmailConfiguration o"),
    @NamedQuery(name = "OhrmEmailConfiguration.findById", query = "SELECT o FROM OhrmEmailConfiguration o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmEmailConfiguration.findByMailType", query = "SELECT o FROM OhrmEmailConfiguration o WHERE o.mailType = :mailType"),
    @NamedQuery(name = "OhrmEmailConfiguration.findBySentAs", query = "SELECT o FROM OhrmEmailConfiguration o WHERE o.sentAs = :sentAs"),
    @NamedQuery(name = "OhrmEmailConfiguration.findBySendmailPath", query = "SELECT o FROM OhrmEmailConfiguration o WHERE o.sendmailPath = :sendmailPath"),
    @NamedQuery(name = "OhrmEmailConfiguration.findBySmtpHost", query = "SELECT o FROM OhrmEmailConfiguration o WHERE o.smtpHost = :smtpHost"),
    @NamedQuery(name = "OhrmEmailConfiguration.findBySmtpPort", query = "SELECT o FROM OhrmEmailConfiguration o WHERE o.smtpPort = :smtpPort"),
    @NamedQuery(name = "OhrmEmailConfiguration.findBySmtpUsername", query = "SELECT o FROM OhrmEmailConfiguration o WHERE o.smtpUsername = :smtpUsername"),
    @NamedQuery(name = "OhrmEmailConfiguration.findBySmtpPassword", query = "SELECT o FROM OhrmEmailConfiguration o WHERE o.smtpPassword = :smtpPassword"),
    @NamedQuery(name = "OhrmEmailConfiguration.findBySmtpAuthType", query = "SELECT o FROM OhrmEmailConfiguration o WHERE o.smtpAuthType = :smtpAuthType"),
    @NamedQuery(name = "OhrmEmailConfiguration.findBySmtpSecurityType", query = "SELECT o FROM OhrmEmailConfiguration o WHERE o.smtpSecurityType = :smtpSecurityType")})
public class OhrmEmailConfiguration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "mail_type")
    private String mailType;
    @Basic(optional = false)
    @Column(name = "sent_as")
    private String sentAs;
    @Column(name = "sendmail_path")
    private String sendmailPath;
    @Column(name = "smtp_host")
    private String smtpHost;
    @Column(name = "smtp_port")
    private Integer smtpPort;
    @Column(name = "smtp_username")
    private String smtpUsername;
    @Column(name = "smtp_password")
    private String smtpPassword;
    @Column(name = "smtp_auth_type")
    private String smtpAuthType;
    @Column(name = "smtp_security_type")
    private String smtpSecurityType;

    public OhrmEmailConfiguration() {
    }

    public OhrmEmailConfiguration(Integer id) {
        this.id = id;
    }

    public OhrmEmailConfiguration(Integer id, String sentAs) {
        this.id = id;
        this.sentAs = sentAs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMailType() {
        return mailType;
    }

    public void setMailType(String mailType) {
        this.mailType = mailType;
    }

    public String getSentAs() {
        return sentAs;
    }

    public void setSentAs(String sentAs) {
        this.sentAs = sentAs;
    }

    public String getSendmailPath() {
        return sendmailPath;
    }

    public void setSendmailPath(String sendmailPath) {
        this.sendmailPath = sendmailPath;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public Integer getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(Integer smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getSmtpUsername() {
        return smtpUsername;
    }

    public void setSmtpUsername(String smtpUsername) {
        this.smtpUsername = smtpUsername;
    }

    public String getSmtpPassword() {
        return smtpPassword;
    }

    public void setSmtpPassword(String smtpPassword) {
        this.smtpPassword = smtpPassword;
    }

    public String getSmtpAuthType() {
        return smtpAuthType;
    }

    public void setSmtpAuthType(String smtpAuthType) {
        this.smtpAuthType = smtpAuthType;
    }

    public String getSmtpSecurityType() {
        return smtpSecurityType;
    }

    public void setSmtpSecurityType(String smtpSecurityType) {
        this.smtpSecurityType = smtpSecurityType;
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
        if (!(object instanceof OhrmEmailConfiguration)) {
            return false;
        }
        OhrmEmailConfiguration other = (OhrmEmailConfiguration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmEmailConfiguration[ id=" + id + " ]";
    }
    
}
