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
    private long orderId;
    private long oeuvreId;
    
    public OrderContainKey(){
        
    }
    @Override
    public String toString() {
        return "" + getOrderNumber() + "-" + getOrderContainId();
    }

    public long getOrderNumber() {
        return orderId;
    }

    public void setOrderNumber(long order) {
        this.orderId = order;
    }

    public long getOrderContainId() {
        return oeuvreId;
    }

    public void setOrderContainId(int newId) {
        this.oeuvreId = newId;
    } 
}
