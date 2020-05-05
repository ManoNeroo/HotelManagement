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
@Table(name = "serviceDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceDetail.findAll", query = "SELECT s FROM ServiceDetail s")
    , @NamedQuery(name = "ServiceDetail.findById", query = "SELECT s FROM ServiceDetail s WHERE s.id = :id")
    , @NamedQuery(name = "ServiceDetail.findByAmount", query = "SELECT s FROM ServiceDetail s WHERE s.amount = :amount")
    , @NamedQuery(name = "ServiceDetail.findByCreatedDate", query = "SELECT s FROM ServiceDetail s WHERE s.createdDate = :createdDate")})
public class ServiceDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "amount")
    private int amount;
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "bookingDetailId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BookingDetail bookingDetail;
    @JoinColumn(name = "serviceId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Service service;

    public ServiceDetail() {
    }

    public ServiceDetail(Integer id) {
        this.id = id;
    }

    public ServiceDetail(Integer id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public BookingDetail getBookingDetail() {
        return bookingDetail;
    }

    public void setBookingDetail(BookingDetail bookingDetail) {
        this.bookingDetail = bookingDetail;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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
        if (!(object instanceof ServiceDetail)) {
            return false;
        }
        ServiceDetail other = (ServiceDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ServiceDetail[ id=" + id + " ]";
    }
    
}
