/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.web_jpa_war.entity;

import java.io.Serializable;

/**
 *
 * @author vannaraloch
 */
public class BorrowItemKey implements Serializable {

    private long borrowId;

    private long itemId;

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

    public int hashCode() {
        return (int) (borrowId + itemId);
    }

    public boolean equals(Object object) {
        if (object instanceof BorrowItemKey) {
            BorrowItemKey otherId = (BorrowItemKey) object;
            return (otherId.borrowId == this.borrowId) && (otherId.itemId == this.itemId);
        }
        return false;
    }
}
