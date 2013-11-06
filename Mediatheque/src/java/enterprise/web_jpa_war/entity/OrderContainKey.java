/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enterprise.web_jpa_war.entity;

import java.io.Serializable;

/**
 *
 * @author EmmanuelleDALLEAU
 */
public class OrderContainKey implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer orderNumber;
    private int id;
    
    public OrderContainKey(){
        
    }
    @Override
    public String toString() {
        return "" + getOrderNumber() + "-" + getOrderContainId();
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer order) {
        this.orderNumber = order;
    }

    public int getOrderContainId() {
        return id;
    }

    public void setOrderContainId(int newId) {
        this.id = newId;
    }

   @Override
    public int hashCode() {
        return (((this.getOrderNumber() == null) ? 0 : this.getOrderNumber()
                                                     .hashCode())
        ^ ((int) this.getOrderContainId()));
    }

    @Override
    public boolean equals(Object otherOb) {
        if (this == otherOb) {
            return true;
        }

        if (!(otherOb instanceof OrderContainKey)) {
            return false;
        }

        OrderContainKey other = (OrderContainKey) otherOb;

        return (((this.getOrderNumber() == null) ? (other.getOrderNumber() == null)
                                           : this.getOrderNumber()
                                                 .equals(other.getOrderNumber()))
        && (this.getOrderContainId() == other.getOrderContainId()));
    }
    
//    @Override
//    public String toString() {
//        return "" + getOrderNumber() + "-" + getItemId();
//    }
    
}
