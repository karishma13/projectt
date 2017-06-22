/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADMIN;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
@Table(name = "VIEW_ORDERS", catalog = "", schema = "SYSTEM")
@NamedQueries({
    @NamedQuery(name = "ViewOrders.findAll", query = "SELECT v FROM ViewOrders v"),
    @NamedQuery(name = "ViewOrders.findByName", query = "SELECT v FROM ViewOrders v WHERE v.name = :name"),
    @NamedQuery(name = "ViewOrders.findByContact", query = "SELECT v FROM ViewOrders v WHERE v.contact = :contact"),
    @NamedQuery(name = "ViewOrders.findByOrderDetails", query = "SELECT v FROM ViewOrders v WHERE v.orderDetails = :orderDetails"),
    @NamedQuery(name = "ViewOrders.findByAddress", query = "SELECT v FROM ViewOrders v WHERE v.address = :address"),
    @NamedQuery(name = "ViewOrders.findByLoginId", query = "SELECT v FROM ViewOrders v WHERE v.loginId = :loginId")})
public class ViewOrders implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Column(name = "NAME")
    private String name;
    @Id
    @Basic(optional = false)
    @Column(name = "CONTACT")
    private String contact;
    @Column(name = "ORDER_DETAILS")
    private String orderDetails;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "LOGIN_ID")
    private String loginId;

    public ViewOrders() {
    }

    public ViewOrders(String contact) {
        this.contact = contact;
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

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        String oldOrderDetails = this.orderDetails;
        this.orderDetails = orderDetails;
        changeSupport.firePropertyChange("orderDetails", oldOrderDetails, orderDetails);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        String oldLoginId = this.loginId;
        this.loginId = loginId;
        changeSupport.firePropertyChange("loginId", oldLoginId, loginId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contact != null ? contact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewOrders)) {
            return false;
        }
        ViewOrders other = (ViewOrders) object;
        if ((this.contact == null && other.contact != null) || (this.contact != null && !this.contact.equals(other.contact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ADMIN.ViewOrders[ contact=" + contact + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
