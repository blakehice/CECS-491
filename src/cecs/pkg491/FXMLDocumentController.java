/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecs.pkg491;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Blake
 */
public class FXMLDocumentController extends AnchorPane{

    private final String fileName = "spreadSheet.xls";
    private ObservableList<String> firstNames = FXCollections.observableArrayList();
    private ObservableList<String> lastNames = FXCollections.observableArrayList();
    private ObservableList<String> practices = FXCollections.observableArrayList();
    private ObservableList<String> sorter = FXCollections.observableArrayList();

    @FXML private ComboBox sortBy;
    @FXML private ComboBox values;

    public FXMLDocumentController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

 
    public void init() {
        initializeSorter(sorter);
        sortBy.setItems(sorter);
    }

    public void initializeSorter(ObservableList<String> sorter) {
        sorter.add("First Name");
        sorter.add("Last Name");
        sorter.add("Practice");
        sorter.add("Email");
        sorter.add("Address");
    }

    public void initializeLists(String name, ObservableList<String> list) {

    }

}
