package com.example.ui;
import java.awt.Component;
import java.util.Iterator;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
public class BoxLayoutPanel extends JPanel {
    private List panelComponents;
    private int axis;

    public void setAxis(int axis) {
        this.axis = axis;
    }
    public void setPanelComponents(List panelComponents) {
        this.panelComponents = panelComponents;
    }
    public void init() {
        setLayout(new BoxLayout(this, axis));

        for (Iterator i = panelComponents.iterator(); i.hasNext();) {
            Component component = (Component) i.next();
            add(component);
        }
    }
}
