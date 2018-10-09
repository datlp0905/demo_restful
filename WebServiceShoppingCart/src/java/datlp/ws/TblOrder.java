/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlp.ws;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DAT
 */
@Entity
@Table(name = "tblOrder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblOrder.findAll", query = "SELECT t FROM TblOrder t")
    , @NamedQuery(name = "TblOrder.findById", query = "SELECT t FROM TblOrder t WHERE t.id = :id")
    , @NamedQuery(name = "TblOrder.findByCreatedTime", query = "SELECT t FROM TblOrder t WHERE t.createdTime = :createdTime")
    , @NamedQuery(name = "TblOrder.findByTotal", query = "SELECT t FROM TblOrder t WHERE t.total = :total")})
public class TblOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "createdTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private TblUser username;
    @OneToMany(mappedBy = "orderId")
    private Collection<TblOrderDetail> tblOrderDetailCollection;

    public TblOrder() {
    }

    public TblOrder(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public TblUser getUsername() {
        return username;
    }

    public void setUsername(TblUser username) {
        this.username = username;
    }

    @XmlTransient
    public Collection<TblOrderDetail> getTblOrderDetailCollection() {
        return tblOrderDetailCollection;
    }

    public void setTblOrderDetailCollection(Collection<TblOrderDetail> tblOrderDetailCollection) {
        this.tblOrderDetailCollection = tblOrderDetailCollection;
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
        if (!(object instanceof TblOrder)) {
            return false;
        }
        TblOrder other = (TblOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datlp.ws.TblOrder[ id=" + id + " ]";
    }
    
}
