/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enterprise.web_jpa_war.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author vannaraloch
 */
@Entity
public class Borrow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long borrowId;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date borrowDate;
   
    @ManyToOne
    private Adherent adherent;
    
    @ManyToOne
    private Return returns;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "borrow")
    private Collection<BorrowItem> borrowItems;
       
    public Return getReturns() {
        return returns;
    }

    public void setReturns(Return returns) {
        this.returns = returns;
    }
 
    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }
   
    public Collection<BorrowItem> getborrowItems() {
        return borrowItems;
    }

    public void setItemCopies(Collection<BorrowItem> borrowItems) {
        this.borrowItems = borrowItems;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
    
    public Long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }
    
    public Borrow(){
        //this.borrowDate= new Date();
    }
}
