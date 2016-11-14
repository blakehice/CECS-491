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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Blake
 */
public class FXMLDocumentController extends AnchorPane {

    private ObservableList<Person> people = FXCollections.observableArrayList();
    private ObservableList<String> sorter = FXCollections.observableArrayList();
    private ObservableList<String> firstNames = FXCollections.observableArrayList();
    private ObservableList<String> lastNames = FXCollections.observableArrayList();
    private ObservableList<String> practices = FXCollections.observableArrayList();
    private ObservableList<String> phones = FXCollections.observableArrayList();
    private ObservableList<String> emails = FXCollections.observableArrayList();
    private ObservableList<String> addresses = FXCollections.observableArrayList();
    private ObservableList<Person> filteredPeople = FXCollections.observableArrayList();

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
    @FXML
    private TableColumn firstNameCol;
    @FXML
    private TableColumn lastNameCol;
    @FXML
    private TableColumn practiceCol;
    @FXML
    private TableColumn phoneCol;
    @FXML
    private TableColumn emailCol;
    @FXML
    private TableColumn addressCol;

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
        try {
            readSpreadSheet();
        } catch (Exception e) {
            System.out.println("error reading spread sheet");
            e.printStackTrace();
        }
        initializeTable();
        initializeChoices();

        initializeSorter(sorter);
        sortBy.setItems(sorter);
    }

    //populate sorter with values in hashmap
    public void initializeSorter(ObservableList<String> sorter) {
        sorter.add("First Name");
        sorter.add("Last Name");
        sorter.add("Practice");
        sorter.add("Phone");
        sorter.add("Email");
        sorter.add("Address");
    }

    public void initializeLists(String name, ObservableList<String> list) {

    }

    public void initializeTable() {
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        practiceCol.setCellValueFactory(new PropertyValueFactory<Person, String>("practice"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
        addressCol.setCellValueFactory(new PropertyValueFactory<Person, String>("address"));

        table.setItems(people);
    }

    public void resetTable() {
        filteredPeople.clear();
    }

    public void updateTable() {
        resetTable();

        int selectedIndex = sortBy.getSelectionModel().getSelectedIndex();
        String filterItem = (String) filter.getSelectionModel().getSelectedItem();

        switch (selectedIndex) {
            case 0:
                for (int i = 0; i < people.size(); i++) {
                    if (people.get(i).getFirstName().equals(filterItem)) {
                        filteredPeople.add(people.get(i));
                    }
                }
                break;
            case 1:
                for (int i = 0; i < people.size(); i++) {
                    if (people.get(i).getLastName().equals(filterItem)) {
                        filteredPeople.add(people.get(i));
                    }
                }
                break;
            case 2:
                for (int i = 0; i < people.size(); i++) {
                    if (people.get(i).getPractice().equals(filterItem)) {
                        filteredPeople.add(people.get(i));
                    }
                }
                break;
            case 3:
                for (int i = 0; i < people.size(); i++) {
                    if (people.get(i).getPhone().equals(filterItem)) {
                        filteredPeople.add(people.get(i));
                    }
                }
            case 4:
                for (int i = 0; i < people.size(); i++) {
                    if (people.get(i).getEmail().equals(filterItem)) {
                        filteredPeople.add(people.get(i));
                    }
                }
                break;
            case 5:
                for (int i = 0; i < people.size(); i++) {
                    if (people.get(i).getAddress().equals(filterItem)) {
                        filteredPeople.add(people.get(i));
                    }
                }
                break;
        }
        sort();

    }

    public void sort() {
        //get the value the user picked to sort by and click that column name
        int column = sortBy.getSelectionModel().getSelectedIndex();

        if (!filteredPeople.isEmpty()) {
            table.setItems(filteredPeople);
            // to use next column to sort if they are same.
            if (column < sorter.size() - 1) {
                column += 1;
            }
        } else {
            table.setItems(people);
            
            
        }
        TableColumn c = (TableColumn) (table.getColumns().get(column));
        c.setSortType(TableColumn.SortType.ASCENDING);
        table.getSortOrder().add(c);
        System.out.println(c == emailCol);
        table.getSortOrder().remove(c);

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
        choices.put("Phone", phones);
        choices.put("Email", emails);
        choices.put("Address", addresses);

    }

    private void readSpreadSheet() throws Exception {
        String fileName = "test.xlsx";

        FileInputStream inputStream = new FileInputStream(new File(fileName));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = firstSheet.iterator();
        String fname = "", lname = "", prac = "", phone = "", email = "", address = "";
        while (rowIterator.hasNext()) {
            Row nextRow = rowIterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getColumnIndex()) {
                    case 0:
                        fname = cell.getStringCellValue();
                        if (!firstNames.contains(cell.getStringCellValue())) {
                            firstNames.add(fname);
                        }
                        break;
                    case 1:
                        lname = cell.getStringCellValue();
                        if (!lastNames.contains(cell.getStringCellValue())) {
                            lastNames.add(lname);
                        }
                        break;
                    case 2:
                        prac = cell.getStringCellValue();
                        if (!practices.contains(cell.getStringCellValue())) {
                            practices.add(prac);
                        }
                        break;
                    case 3:
                        phone = cell.getStringCellValue();
                        if (!phones.contains(cell.getStringCellValue())) {
                            phones.add(phone);
                        }
                        break;
                    case 4:
                        email = cell.getStringCellValue();
                        if (!emails.contains(cell.getStringCellValue())) {
                            emails.add(email);
                        }
                        break;
                    case 5:
                        address = cell.getStringCellValue();
                        if (!addresses.contains(cell.getStringCellValue())) {
                            addresses.add(address);
                        }
                        break;
                    default:
                        System.out.println("error");
                        break;
                }
            }
            people.add(new Person(fname, lname, prac, phone, email, address));

        }
        workbook.close();
        inputStream.close();
    }

    @FXML
    private void sortByChanged() {
        String selectedItem = (String) sortBy.getSelectionModel().getSelectedItem();
        System.out.println("selected = " + selectedItem);
        updateFilter(selectedItem);

    }

    @FXML
    private void buttonClick() {
        updateTable();
    }
}
