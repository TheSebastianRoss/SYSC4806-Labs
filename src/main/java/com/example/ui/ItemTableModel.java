package com.example.ui;

import com.example.addressBook.BuddyInfo;
import com.example.addressBook.AddressBook;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ItemTableModel extends AbstractTableModel {
    private List<List<Object>> itemList;
    private AddressBook addressBook;

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public int getColumnCount() {
        return 2;
    }

    public String getColumnName(int column) {
        switch(column) {
            case(0):
                return "Name";
            case(1):
                return "Phone Number";
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    public void setItemList(List<List<Object>> itemList) {
        this.itemList = itemList;
        this.addressBook = new AddressBook();
        for(List<Object> buddy: itemList) {
            BuddyInfo buddyInfo = new BuddyInfo((String) buddy.get(0), (String) buddy.get(1));
            this.addressBook.addBuddy(buddyInfo);
        }
    }

    public int getRowCount() {
        return this.itemList.size();
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case(0):
                this.itemList.get(rowIndex).set(columnIndex, value);
                if(rowIndex >= addressBook.getNumBuddies()) {
                    this.addressBook.addBuddy(new BuddyInfo("", ""));
                }
                this.addressBook.getBuddyAtIndex(rowIndex).setName((String) value);
                break;
            case(1):
                this.itemList.get(rowIndex).set(columnIndex, value);
                if(rowIndex >= addressBook.getNumBuddies()) {
                    this.addressBook.addBuddy(new BuddyInfo("", ""));
                }
                this.addressBook.getBuddyAtIndex(rowIndex).setPhoneNumber((String) value);
                break;
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.itemList.get(rowIndex).get(columnIndex);
    }
}
