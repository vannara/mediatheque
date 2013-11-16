/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enterprise.web_jpa_war.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author vannaraloch
 */
@Entity
@IdClass(BorrowItemKey.class)
public class BorrowItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private long borrowId;

    @Id
    private long itemId;
   
    @Temporal(TemporalType.DATE)
    private Date expectedReturnDate;

    @ManyToOne
    private Borrow borrow;
    
    @ManyToOne
    private Item item;

    public long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(long borrowId) {
        this.borrowId = borrowId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }
   
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }
    
    public void setExpectedReturnDate(Date expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }
    
   public Date getExpectedReturnDate() {
        return expectedReturnDate;
    }

  
    
    public BorrowItem(){
         
    }
}
