/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecs.pkg491;


import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 *
 * @author Blake
 */
public class CECS491 extends Application {

    public CECS491() {
        
    }
   
   @Override
   public void start(Stage stage) throws Exception {
      final ObservableList <String> sorter = FXCollections.observableArrayList();
      sorter.add("First Name");
      sorter.add("Last Name");
      sorter.add("Practice");
      sorter.add("Email");
      sorter.add("Address");
      Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
      
      Scene scene = new Scene(root);
      
      ComboBox choice = (ComboBox)scene.lookup("#comboBox1");
      choice.setItems(sorter);
      stage.setScene(scene);
      stage.setTitle("Attorney Lookup");
      stage.show();
      
   }

   
   public static void main(String[] args) {
     
     
      launch(args);
      
   }
   
  
}
