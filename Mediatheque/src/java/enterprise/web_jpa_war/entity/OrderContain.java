/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enterprise.web_jpa_war.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author EmmanuelleDALLEAU
 */
@Entity
@Table(name = "PERSISTENCE_ORDER_LINEITEM")
@IdClass (OrderContainKey.class)
public class OrderContain implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    private long orderId;

    @Id
    private long oeuvreId;
    
    @ManyToOne
    private Order order;
    @ManyToOne
    private Oeuvre oeuvre;
    
    private int quantityOeuvresOrder;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Oeuvre getOeuvre() {
        return oeuvre;
    }

    public void setOeuvre(Oeuvre oeuvre) {
        this.oeuvre = oeuvre;
    }

    private float unitePrice;
    
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getOeuvreId() {
        return oeuvreId;
    }

    public void setOeuvreId(long oeuvreId) {
        this.oeuvreId = oeuvreId;
    }

    public OrderContain(){
        
    }

    public int getQuantityOeuvresOrder() {
        return quantityOeuvresOrder;
    }

    public void setQuantityOeuvresOrder(int quantityOeuvresOrder) {
        this.quantityOeuvresOrder = quantityOeuvresOrder;
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
}
