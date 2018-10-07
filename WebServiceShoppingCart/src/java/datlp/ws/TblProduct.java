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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DAT
 */
@Entity
@Table(name = "tblProduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProduct.findAll", query = "SELECT t FROM TblProduct t")
    , @NamedQuery(name = "TblProduct.findById", query = "SELECT t FROM TblProduct t WHERE t.id = :id")
    , @NamedQuery(name = "TblProduct.findByName", query = "SELECT t FROM TblProduct t WHERE t.name = :name")
    , @NamedQuery(name = "TblProduct.findByDescription", query = "SELECT t FROM TblProduct t WHERE t.description = :description")
    , @NamedQuery(name = "TblProduct.findByPrice", query = "SELECT t FROM TblProduct t WHERE t.price = :price")
    , @NamedQuery(name = "TblProduct.findByQuantity", query = "SELECT t FROM TblProduct t WHERE t.quantity = :quantity")
    , @NamedQuery(name = "TblProduct.findByImage", query = "SELECT t FROM TblProduct t WHERE t.image = :image")})
public class TblProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "image")
    private String image;

    public TblProduct() {
    }

    public TblProduct(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        if (!(object instanceof TblProduct)) {
            return false;
        }
        TblProduct other = (TblProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datlp.ws.TblProduct[ id=" + id + " ]";
    }
    
}
