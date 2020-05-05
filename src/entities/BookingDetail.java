/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author trinh
 */
@Entity
@Table(name = "bookingDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookingDetail.findAll", query = "SELECT b FROM BookingDetail b")
    , @NamedQuery(name = "BookingDetail.findById", query = "SELECT b FROM BookingDetail b WHERE b.id = :id")
    , @NamedQuery(name = "BookingDetail.findByServicePrice", query = "SELECT b FROM BookingDetail b WHERE b.servicePrice = :servicePrice")
    , @NamedQuery(name = "BookingDetail.findByCreatedAt", query = "SELECT b FROM BookingDetail b WHERE b.createdAt = :createdAt")})
public class BookingDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "servicePrice")
    private double servicePrice;
    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "bookingId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Booking booking;
    @JoinColumn(name = "roomId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Room room;

    public BookingDetail() {
    }

    public BookingDetail(Integer id) {
        this.id = id;
    }

    public BookingDetail(Integer id, double servicePrice) {
        this.id = id;
        this.servicePrice = servicePrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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
        if (!(object instanceof BookingDetail)) {
            return false;
        }
        BookingDetail other = (BookingDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BookingDetail[ id=" + id + " ]";
    }

}
