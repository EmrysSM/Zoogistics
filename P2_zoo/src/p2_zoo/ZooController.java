package p2_zoo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZooController {
    public ZooModel model;
    public ZooView view;

    public ZooController(ZooModel model, ZooView view) {
        this.model = model;
        this.view = view;
    }

    public void actionPerformed(ActionEvent e) {

    }

    public void addListener(ActionListener l) {

    }
}
