/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author trinh
 */
@Entity
@Table(name = "bookings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
    , @NamedQuery(name = "Booking.findById", query = "SELECT b FROM Booking b WHERE b.id = :id")
    , @NamedQuery(name = "Booking.findByCheckin", query = "SELECT b FROM Booking b WHERE b.checkin = :checkin")
    , @NamedQuery(name = "Booking.findByCheckout", query = "SELECT b FROM Booking b WHERE b.checkout = :checkout")
    , @NamedQuery(name = "Booking.findByStatus", query = "SELECT b FROM Booking b WHERE b.status = :status")
    , @NamedQuery(name = "Booking.findByCreatedAt", query = "SELECT b FROM Booking b WHERE b.createdAt = :createdAt")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "checkin")
    @Temporal(TemporalType.DATE)
    private Date checkin;
    @Column(name = "checkout")
    @Temporal(TemporalType.DATE)
    private Date checkout;
    @Basic(optional = false)
    @Column(name = "status")
    private short status;
    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Customer customer;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingId")
    private Collection<BookingDetail> bookingDetailCollection;

    public Booking() {
    }

    public Booking(String id) {
        this.id = id;
    }

    public Booking(String id, Date checkin, short status) {
        this.id = id;
        this.checkin = checkin;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @XmlTransient
    public Collection<BookingDetail> getBookingDetailCollection() {
        return bookingDetailCollection;
    }

    public void setBookingDetailCollection(Collection<BookingDetail> bookingDetailCollection) {
        this.bookingDetailCollection = bookingDetailCollection;
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
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Booking[ id=" + id + " ]";
    }
    
}
