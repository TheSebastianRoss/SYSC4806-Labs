package com.example.ui.button;

import java.awt.event.ActionEvent;
import java.util.Arrays;

public class AddNewButtonActionListener extends ListTableActionListener {
    public void actionPerformed(ActionEvent e) {
        list.add(Arrays.asList(new String[]{"New Name", "New Number"}));
        table.revalidate();
    }
}
