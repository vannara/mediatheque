/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enterprise.web_jpa_war.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author vannaraloch
 */
@Entity
public class Card implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private String login;
    private boolean isLost;
    private double guaranteeAmt;
    private double annualFee;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isIsLost() {
        return isLost;
    }

    public void setIsLost(boolean isLost) {
        this.isLost = isLost;
    }

    public double getGuaranteeAmt() {
        return guaranteeAmt;
    }

    public void setGuaranteeAmt(double guaranteeAmt) {
        this.guaranteeAmt = guaranteeAmt;
    }

    public double getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(double annualFee) {
        this.annualFee = annualFee;
    }
            
    public String getId() {
        return login;
    }

    public void setId(String login) {
        this.login = login;
    }

    public Card(){
        
    }
    
}
