package p2_zoo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

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
    
    public void searchAnimal(KeyEvent k, String txt) {
        ArrayList<zoo_model.Animal> AnimalsList = model.getAnimalList();
        
        for(int i = 0; i < AnimalsList.size(); i++) {
            AnimalsList.get(i);
        }
    }
}
