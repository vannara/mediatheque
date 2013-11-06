/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enterprise.web_jpa_war.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author EmmanuelleDALLEAU
 */
@Entity
@Table(name = "PERSISTENCE_ORDER_LINEITEM")
public class OrderContain implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Order orderNumber;
    private Oeuvre currentOeuvre;
    private int quantity;
    private Integer id;
    private float unitePrice;
    
    public OrderContain(){
        
    }
    @Id
    public int getOrderContainId() {
        return id;
    }

    public void setOrderContainId(int newId) {
        this.id = newId;
    }
    @Id
    @ManyToOne
    @JoinColumn(name = "ORDERID")
    public Order getOrderNumber() {
        return orderNumber;
    }

    public void setOrder(Order newOrder) {
        this.orderNumber = newOrder;
    }

    @ManyToOne
    @JoinColumn(name = "OEUVREID")
    public Oeuvre getOeuvre() {
        return currentOeuvre;
    }

    public void setOeuvre(Oeuvre currentOeuvre) {
        this.currentOeuvre = currentOeuvre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(float unitePrice) {
        this.unitePrice = unitePrice;
    }
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderContain)) {
            return false;
        }
        OrderContain other = (OrderContain) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enterprise.web_jpa_war.entity.OrderContain[ id=" + id + " ]";
    }
    
}
