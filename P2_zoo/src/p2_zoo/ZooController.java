package p2_zoo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZooController {
    public zoo_model model;
//    public zoogisticsView view;

    public ZooController() {
        this.model = new zoo_model();
    }

    public void performAction(ActionEvent e) {
        String str = e.getActionCommand();

    }

    public void addListener(ActionListener l) {

    }
}
