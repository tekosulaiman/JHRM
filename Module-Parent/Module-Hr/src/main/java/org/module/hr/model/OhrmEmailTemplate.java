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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_email_template", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmEmailTemplate.findAll", query = "SELECT o FROM OhrmEmailTemplate o"),
    @NamedQuery(name = "OhrmEmailTemplate.findById", query = "SELECT o FROM OhrmEmailTemplate o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmEmailTemplate.findByLocale", query = "SELECT o FROM OhrmEmailTemplate o WHERE o.locale = :locale"),
    @NamedQuery(name = "OhrmEmailTemplate.findByPerformerRole", query = "SELECT o FROM OhrmEmailTemplate o WHERE o.performerRole = :performerRole"),
    @NamedQuery(name = "OhrmEmailTemplate.findByRecipientRole", query = "SELECT o FROM OhrmEmailTemplate o WHERE o.recipientRole = :recipientRole"),
    @NamedQuery(name = "OhrmEmailTemplate.findBySubject", query = "SELECT o FROM OhrmEmailTemplate o WHERE o.subject = :subject")})
public class OhrmEmailTemplate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "locale")
    private String locale;
    @Column(name = "performer_role")
    private String performerRole;
    @Column(name = "recipient_role")
    private String recipientRole;
    @Column(name = "subject")
    private String subject;
    @Lob
    @Column(name = "body")
    private String body;
    @JoinColumn(name = "email_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmEmail emailId;

    public OhrmEmailTemplate() {
    }

    public OhrmEmailTemplate(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getPerformerRole() {
        return performerRole;
    }

    public void setPerformerRole(String performerRole) {
        this.performerRole = performerRole;
    }

    public String getRecipientRole() {
        return recipientRole;
    }

    public void setRecipientRole(String recipientRole) {
        this.recipientRole = recipientRole;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public OhrmEmail getEmailId() {
        return emailId;
    }

    public void setEmailId(OhrmEmail emailId) {
        this.emailId = emailId;
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
        if (!(object instanceof OhrmEmailTemplate)) {
            return false;
        }
        OhrmEmailTemplate other = (OhrmEmailTemplate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmEmailTemplate[ id=" + id + " ]";
    }
    
}
