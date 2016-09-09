/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecs.pkg491;

import javafx.application.Application;


import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Blake
 */
public class CECS491 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
      FXMLDocumentController customControl = new FXMLDocumentController();
        customControl.init();
        
        stage.setScene(new Scene(customControl));
        stage.setTitle("Attorney Lookup");
        
        stage.show();

        

    }

    public static void main(String[] args) {

        launch(args);

    }

}
