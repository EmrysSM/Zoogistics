/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_zoo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author escottmurrell
 */
public class ZooController {
    zoo_model model;
    long date;
    public ZooController() {
        model = new zoo_model();
        model.getConnection();
    }
    
    public void submitLog(JRadioButton logFeed, JRadioButton logMedication, JTextField searchAnimal) throws SQLException {
        
        if (logFeed.isSelected() && logMedication.isSelected()) {
            model.update("main_tb", "Next_Activity", "Feeding and Medication","Name", searchAnimal.getText());
        } else if (logFeed.isSelected()) {
            model.update("main_tb", "Next_Activity", "Feeding","Name", searchAnimal.getText());
        } else if (logMedication.isSelected()) {
            model.update("main_tb", "Next_Activity", "Medication","Name", searchAnimal.getText());
        }
    }
    
    public void submitMove(JTextField animalSearch2,JTextField exhibitSearch) throws SQLException {
        // String currentLocation = model.select();
        // model.update("isfull", currentLocation, "0", "Name", animalSearch2.getText());
        // model.update("isfull", exhibitSearch + "_isFull", "1", "Name", animalSearch2.getText());
        model.update("main_tb", "IsFull_Location", exhibitSearch.getText(),"Name", animalSearch2.getText());
    }
    
    public void submitAnimal(JTextField jTfType, JTextField jTfSex, JTextField jTfName, JTextField jTfExhibit, JTextField jTfFeed, JTextField jTfNxtAct) throws SQLException {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(jTfName.getText(), jTfSex.getText(), jTfNxtAct.getText(), jTfFeed.getText(), jTfType.getText(), jTfExhibit.getText()));
        model.insert("main_tb", list);
    }
    
    
    
}
