/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlp.ws;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DAT
 */
@Entity
@Table(name = "tblOrderDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblOrderDetail.findAll", query = "SELECT t FROM TblOrderDetail t")
    , @NamedQuery(name = "TblOrderDetail.findById", query = "SELECT t FROM TblOrderDetail t WHERE t.id = :id")
    , @NamedQuery(name = "TblOrderDetail.findByQuantity", query = "SELECT t FROM TblOrderDetail t WHERE t.quantity = :quantity")})
public class TblOrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    @ManyToOne
    private TblOrder orderId;
    @JoinColumn(name = "productId", referencedColumnName = "id")
    @ManyToOne
    private TblProduct productId;

    public TblOrderDetail() {
    }

    public TblOrderDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public TblOrder getOrderId() {
        return orderId;
    }

    public void setOrderId(TblOrder orderId) {
        this.orderId = orderId;
    }

    public TblProduct getProductId() {
        return productId;
    }

    public void setProductId(TblProduct productId) {
        this.productId = productId;
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
        if (!(object instanceof TblOrderDetail)) {
            return false;
        }
        TblOrderDetail other = (TblOrderDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datlp.ws.TblOrderDetail[ id=" + id + " ]";
    }
    
}
