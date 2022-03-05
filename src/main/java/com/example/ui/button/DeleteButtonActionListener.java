package com.example.ui.button;

import java.awt.event.ActionEvent;

public class DeleteButtonActionListener extends ListTableActionListener{
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();

        if(selectedRow == -1) { // if no selected row
            return;
        } else if(table.isEditing()) { // if we are editing the table
            return;
        } else {
            list.remove(selectedRow);
            table.revalidate();
        }
    }
}
