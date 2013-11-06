/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enterprise.web_jpa_war.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;

/**
 *
 * @author EmmanuelleDALLEAU
 */
@Entity
@Table(name = "PERSISTENCE_ORDER_ORDER")
@NamedQuery(name = "findAllOrders", query = "SELECT o FROM Order o "
+ "ORDER BY o.orderId")
public class Order implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Date orderDate;
    private Supplier nameSupplier;

    public Supplier getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(Supplier nameSupplier) {
        this.nameSupplier = nameSupplier;
    }
    private Collection<OrderContain> orderContainer;
    
     public Order() {
        this.orderDate = new Date();
        this.orderContainer = new ArrayList<OrderContain>();
    }
    
    private Integer orderId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return orderId;
    }

    public void setId(Integer id) {
        this.orderId = id;
    }

    @Temporal(TIMESTAMP)
    public Date getLastUpdate() {
        return orderDate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.orderDate = lastUpdate;
    }
    
    @OneToMany(cascade = ALL, mappedBy = "order")
    public Collection<OrderContain> getOrderContain() {
        return orderContainer;
    }

    public void setOrderContain(Collection<OrderContain> newOrderContainer) {
        this.orderContainer = newOrderContainer;
    }
    
//    public double calculateAmmount() {
//        double ammount = 0;
//        Collection<OrderContaine> items = getOrderContain();
//
//        for (Iterator it = items.iterator(); it.hasNext();) {
//           orderContaine item = (orderContaine) it.next();
//            ammount += (part.getPrice() * item.getQuantity());
//        }
//
//        return (ammount / 100);
//    }
//
//    public void addLineItem(OrderContain lineItem) {
//        this.getOrderContain()
//            .add(lineItem);
////    }
//
//    @Transient
//    public int getNextId() {
//        return this.lineItems.size() + 1;
//    }
    //Code généré
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enterprise.web_jpa_war.entity.Order[ id=" + orderId + " ]";
    }
}
