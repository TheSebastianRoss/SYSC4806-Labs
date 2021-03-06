package com.example.ui;

import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
    public void init() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new Dimension(600, 400));

        setVisible(true);
        setState(Frame.NORMAL);
        show();
        // ^ Tutorial says to use this, but it's deprecated
        // and the replacement is apparently setVisible(boolean),
        // which we just used
    }
}
