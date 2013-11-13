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
import javax.persistence.ManyToOne;
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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   
    private long orderId;

    @Temporal(TIMESTAMP)
    private Date orderDate;
    
    @ManyToOne
    private Supplier supplier;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
    @OneToMany(cascade = ALL, mappedBy = "order")
    private Collection<OrderContain> orderContainer;
    
    public Order() {
        this.orderDate = new Date();
        this.orderContainer = new ArrayList<OrderContain>();
    }
    
    public long getId() {
        return orderId;
    }

    public void setId(long id) {
        this.orderId = id;
    }

    public Date getLastUpdate() {
        return orderDate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.orderDate = lastUpdate;
    }
    
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
  
}
