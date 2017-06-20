/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADMIN;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author G50-70
 */
@Entity
@Table(name = "CUSTOMER_DETAILS", catalog = "", schema = "SYSTEM")
@NamedQueries({
    @NamedQuery(name = "CustomerDetails.findAll", query = "SELECT c FROM CustomerDetails c"),
    @NamedQuery(name = "CustomerDetails.findByName", query = "SELECT c FROM CustomerDetails c WHERE c.name = :name"),
    @NamedQuery(name = "CustomerDetails.findByContact", query = "SELECT c FROM CustomerDetails c WHERE c.contact = :contact"),
    @NamedQuery(name = "CustomerDetails.findByEmail", query = "SELECT c FROM CustomerDetails c WHERE c.email = :email"),
    @NamedQuery(name = "CustomerDetails.findByAddress", query = "SELECT c FROM CustomerDetails c WHERE c.address = :address"),
    @NamedQuery(name = "CustomerDetails.findByLogin", query = "SELECT c FROM CustomerDetails c WHERE c.login = :login"),
    @NamedQuery(name = "CustomerDetails.findByPassword", query = "SELECT c FROM CustomerDetails c WHERE c.password = :password")})
public class CustomerDetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CONTACT")
    private String contact;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ADDRESS")
    private String address;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "LOGIN")
    private BigDecimal login;
    @Column(name = "PASSWORD")
    private String password;

    public CustomerDetails() {
    }

    public CustomerDetails(BigDecimal login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        String oldContact = this.contact;
        this.contact = contact;
        changeSupport.firePropertyChange("contact", oldContact, contact);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public BigDecimal getLogin() {
        return login;
    }

    public void setLogin(BigDecimal login) {
        BigDecimal oldLogin = this.login;
        this.login = login;
        changeSupport.firePropertyChange("login", oldLogin, login);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerDetails)) {
            return false;
        }
        CustomerDetails other = (CustomerDetails) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ADMIN.CustomerDetails[ login=" + login + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    }
