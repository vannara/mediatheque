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

    private long itemCopyId;

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

    public int hashCode() {
        return (int) (borrowId + itemCopyId);
    }

    public boolean equals(Object object) {
        if (object instanceof BorrowItemKey) {
            BorrowItemKey otherId = (BorrowItemKey) object;
            return (otherId.borrowId == this.borrowId) && (otherId.itemCopyId == this.itemCopyId);
        }
        return false;
    }
}
