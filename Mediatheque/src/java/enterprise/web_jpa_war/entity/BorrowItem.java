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
    private long itemCopyId;
   
    @Temporal(TemporalType.DATE)
    private Date expectedReturnDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Borrow borrow;
    
    @ManyToOne
    private ItemCopy itemCopy;

    public long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(long borrowId) {
        this.borrowId = borrowId;
    }

    public long getItemCopyId() {
        return itemCopyId;
    }

    public void setItemCopyId(long itemCopyId) {
        this.itemCopyId = itemCopyId;
    }
   
    public ItemCopy getItemCopy() {
        return itemCopy;
    }

    public void setItemCopy(ItemCopy itemCopy) {
        this.itemCopy = itemCopy;
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
