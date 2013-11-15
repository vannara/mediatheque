/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enterprise.web_jpa_war.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author vannaraloch
 */
@Entity
public class Return implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long returnId;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date returnDate;
    
    @ManyToMany
    @JoinTable(
      name="Return_Item",
      joinColumns={@JoinColumn(name="itemCopyId", referencedColumnName="itemCopyId")},
      inverseJoinColumns={@JoinColumn(name="returnId", referencedColumnName="returnId")})
    private Collection<ItemCopy> itemCopies;

    @ManyToOne
    private Borrow borrow;

    public Borrow getBorrow() {
        return borrow;
    }
    

    public void setBorrows(Borrow borrows) {
        this.borrow = borrows;
    }
    
    public Collection<ItemCopy> getItemCopies() {
        return itemCopies;
    }

    public void setItemCopies(Collection<ItemCopy> itemCopies) {
        this.itemCopies = itemCopies;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    
    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }

   public Return(){
       
   }
    
}
