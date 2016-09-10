/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecs.pkg491;

import java.io.*;
import java.util.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Blake
 */
public class FXMLDocumentController extends AnchorPane {

    private ObservableList<String> people = FXCollections.observableArrayList();
    private ObservableList<String> sorter = FXCollections.observableArrayList();
    private ObservableList<String> firstNames = FXCollections.observableArrayList();
    private ObservableList<String> lastNames = FXCollections.observableArrayList();
    private ObservableList<String> practices = FXCollections.observableArrayList();
    private ObservableList<String> emails = FXCollections.observableArrayList();
    private ObservableList<String> addresses = FXCollections.observableArrayList();

    private HashMap choices;
    @FXML
    private ComboBox sortBy;
    @FXML
    private ComboBox filter;
    @FXML
    private TableView table;
    @FXML
    private ImageView maps;
    @FXML
    private Button searchButton;

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

    //load spreadsheet gather all info from it and pass it to variables
    public void init() {
        readSpreadSheet();
        initializeChoices();

        initializeSorter(sorter);
        sortBy.setItems(sorter);
    }

    //populate sorter with values in hashmap
    public void initializeSorter(ObservableList<String> sorter) {
        sorter.add("First Name");
        sorter.add("Last Name");
        sorter.add("Practice");
        sorter.add("Email");
        sorter.add("Address");
    }

    public void initializeLists(String name, ObservableList<String> list) {

    }

    public void initializeTable() {

    }

    public void updateTable() {

    }

    public void sort() {

    }

    private void updateMap() {

    }

    public void updateFilter(String selected) {
        Iterator i = choices.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry item = (Map.Entry) i.next();
            if (selected.equals(item.getKey())) {
                filter.setItems((ObservableList) item.getValue());
            }
        }
    }

    private void initializeChoices() {
        choices = new HashMap();
        choices.put("First Name", firstNames);
        choices.put("Last Name", lastNames);
        choices.put("Practice", practices);
        choices.put("Email", emails);
        choices.put("Address", addresses);
    }

    private void openSpreadSheet() {
        String fileName = "test.xlsx";
        
        try {
            FileInputStream inputStream = new FileInputStream(new File(fileName));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
        } catch (Exception ex) {

        }

    }

    private void readSpreadSheet() {
        
        String line = "", fname, lname, practice, email, address;

    }

    @FXML
    private void sortByChanged() {
        String selectedItem = (String) sortBy.getSelectionModel().getSelectedItem();
        updateFilter(selectedItem);

    }
}
