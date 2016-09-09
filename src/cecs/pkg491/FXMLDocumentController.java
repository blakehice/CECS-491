/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecs.pkg491;

import java.io.IOException;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


/**
 *
 * @author Blake
 */
public class FXMLDocumentController extends AnchorPane{

    private final String fileName = "spreadSheet.xls";
    private ObservableList<String> people = FXCollections.observableArrayList();
    private ObservableList<String> sorter = FXCollections.observableArrayList();

    @FXML private ComboBox sortBy;
    @FXML private ComboBox filter;
    @FXML private TableView table;
    @FXML private ImageView maps;
    @FXML private Button searchButton;
    

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
    
    public void initializeTable(){
        
    }
    
    public void search(){
        
    }
    
    public void sort(){
        
    }
    
    private void updateMap(){
        
    }
    
    @FXML private void sortByChanged(){
        String selectedItem = (String)sortBy.getSelectionModel().getSelectedItem();
        
    } 
}
