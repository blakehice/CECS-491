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
   private ObservableList<String> companies = FXCollections.observableArrayList();
   private ObservableList<String> practices = FXCollections.observableArrayList();
   private ObservableList<String> phones = FXCollections.observableArrayList();
   private ObservableList<String> emails = FXCollections.observableArrayList();
   private ObservableList<String> addresses = FXCollections.observableArrayList();
   private ObservableList<String> states = FXCollections.observableArrayList();
   private ObservableList<String> cities = FXCollections.observableArrayList();
   private ObservableList<String> zips = FXCollections.observableArrayList();
   private ObservableList<String> suites = FXCollections.observableArrayList();
   private ObservableList<Integer> attorneys = FXCollections.observableArrayList();
   private ObservableList<Integer> years = FXCollections.observableArrayList();
   private ObservableList<Double> miles = FXCollections.observableArrayList();
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
   private TableColumn companyCol;
   @FXML
   private TableColumn streetCol;
   @FXML
   private TableColumn suiteCol;
   @FXML
   private TableColumn cityCol;
   @FXML
   private TableColumn stateCol;
   @FXML
   private TableColumn zipCol;
   @FXML
   private TableColumn phoneCol;
   @FXML
   private TableColumn practiceCol;
   @FXML
   private TableColumn emailCol;
   @FXML
   private TableColumn milesCol;
   @FXML
   private TableColumn yearsCol;
   @FXML
   private TableColumn attorneyCol;
   @FXML
   private TextField searchBar;

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
      sorter.add("Company");
      sorter.add("Street Address");
      sorter.add("Suite");
      sorter.add("City");
      sorter.add("State");
      sorter.add("Zip");
      sorter.add("Phone");
      sorter.add("Practice");
      sorter.add("Email");
      sorter.add("Miles");
      sorter.add("Years");
      sorter.add("Attorneys");
   }

   public void initializeLists(String name, ObservableList<String> list) {

   }

   public void initializeTable() {
      firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
      lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
      companyCol.setCellValueFactory(new PropertyValueFactory<Person, String>("company"));
      streetCol.setCellValueFactory(new PropertyValueFactory<Person, String>("address"));
      suiteCol.setCellValueFactory(new PropertyValueFactory<Person, String>("suite"));
      cityCol.setCellValueFactory(new PropertyValueFactory<Person, String>("city"));
      stateCol.setCellValueFactory(new PropertyValueFactory<Person, String>("state"));
<<<<<<< HEAD
      zipCol.setCellValueFactory(new PropertyValueFactory<Person, String>("ZIP"));
      phoneCol.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));
      practiceCol.setCellValueFactory(new PropertyValueFactory<Person, String>("practice"));
      emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
      milesCol.setCellValueFactory(new PropertyValueFactory<Person, String>("miles"));
      yearsCol.setCellValueFactory(new PropertyValueFactory<Person, String>("years"));
      attorneyCol.setCellValueFactory(new PropertyValueFactory<Person, String>("attorneys"));
=======
      zipCol.setCellValueFactory(new PropertyValueFactory<Person, String>("Zipcode"));
      phoneCol.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));
      practiceCol.setCellValueFactory(new PropertyValueFactory<Person, String>("practice"));
      emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
      milesCol.setCellValueFactory(new PropertyValueFactory<Person, Double>("miles"));
      yearsCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("years"));
      attorneyCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("Attorneys"));
      
      milesCol.setStyle( "-fx-alignment: CENTER-RIGHT;");
      yearsCol.setStyle( "-fx-alignment: CENTER-RIGHT;");
      attorneyCol.setStyle( "-fx-alignment: CENTER-RIGHT;");
>>>>>>> 3528108f3e35bc15b2d4bf3fc4db48887725791a

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
               if (people.get(i).getCompany().equals(filterItem)) {
                  filteredPeople.add(people.get(i));
               }
            }
            break;
         case 3:
            for (int i = 0; i < people.size(); i++) {
               if (people.get(i).getAddress().equals(filterItem)) {
                  filteredPeople.add(people.get(i));
               }
            }
         case 4:
            for (int i = 0; i < people.size(); i++) {
               if (people.get(i).getSuite().equals(filterItem)) {
                  filteredPeople.add(people.get(i));
               }
            }
            break;
         case 5:
            for (int i = 0; i < people.size(); i++) {
               if (people.get(i).getCity().equals(filterItem)) {
                  filteredPeople.add(people.get(i));
               }
            }
            break;

         case 6:
            for (int i = 0; i < people.size(); i++) {
               if (people.get(i).getState().equals(filterItem)) {
                  filteredPeople.add(people.get(i));
               }
            }
            break;

         case 7:
            for (int i = 0; i < people.size(); i++) {
               if (people.get(i).getZipcode().equals(filterItem)) {
                  filteredPeople.add(people.get(i));
               }
            }
            break;

         case 8:
            for (int i = 0; i < people.size(); i++) {
               if (people.get(i).getPhone().equals(filterItem)) {
                  filteredPeople.add(people.get(i));
               }
            }
            break;

         case 9:
            for (int i = 0; i < people.size(); i++) {
               if (people.get(i).getPractice().equals(filterItem)) {
                  filteredPeople.add(people.get(i));
               }
            }
            break;

         case 10:
            for (int i = 0; i < people.size(); i++) {
               if (people.get(i).getEmail().equals(filterItem)) {
                  filteredPeople.add(people.get(i));
               }
            }
            break;

         case 11:
            for (int i = 0; i < people.size(); i++) {
               if (people.get(i).getMiles()== (Double.valueOf(filterItem))) {
                  filteredPeople.add(people.get(i));
               }
            }
            break;

         case 12:
            for (int i = 0; i < people.size(); i++) {
               if (people.get(i).getYears()==(Integer.valueOf(filterItem))) {
                  filteredPeople.add(people.get(i));
               }
            }
            break;

         case 13:
            for (int i = 0; i < people.size(); i++) {
               if (people.get(i).getAttorneys()== Integer.valueOf(filterItem)) {
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
      }
      else {
         table.setItems(people);

      }


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
   //items that can be searched for/ sorted by

   private void initializeChoices() {
      choices = new HashMap();
      choices.put("First Name", firstNames);
      choices.put("Last Name", lastNames);
      choices.put("Company",companies);
      choices.put("Street Address",addresses);
      choices.put("Suite",suites);
      choices.put("City",cities);
      choices.put("State",states);
      choices.put("Zip",zips);
      choices.put("Phone",phones);
      choices.put("Practice",practices);
      choices.put("Email",emails);
      choices.put("Miles",miles);
      choices.put("Years",years);
      choices.put("Attorneys",attorneys);
   }

   private void readSpreadSheet() throws Exception {
      String fileName = "B List.xlsx";

      FileInputStream inputStream = new FileInputStream(new File(fileName));
      Workbook workbook = new XSSFWorkbook(inputStream);
      Sheet firstSheet = workbook.getSheetAt(0);
      Iterator<Row> rowIterator = firstSheet.iterator();
      String[] peeps = new String[11];
      int time = 0, atts = 0;
      double dist = 0;
      rowIterator.next();
      while (rowIterator.hasNext()) {
         Row nextRow = rowIterator.next();
         Iterator<Cell> cellIterator = nextRow.cellIterator();
         while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            switch (cell.getColumnIndex()) {
               case 0:
                  peeps[0] = cell.getStringCellValue();
                  if (!firstNames.contains(cell.getStringCellValue())) {
                     firstNames.add(peeps[0]);
                  }
                  break;
               case 1:
                  peeps[1] = cell.getStringCellValue();
                  if (!lastNames.contains(cell.getStringCellValue())) {
                     lastNames.add(peeps[1]);
                  }
                  break;
               case 2:
                  peeps[2] = cell.getStringCellValue();
                  if (!companies.contains(cell.getStringCellValue())) {
                     companies.add(peeps[2]);
                  }
                  break;
               case 3:
                  peeps[3] = cell.getStringCellValue();
                  if (!addresses.contains(cell.getStringCellValue())) {
                     addresses.add(peeps[3]);
                  }
                  break;
               case 4:
                  peeps[4] = cell.getStringCellValue();
                  if (!suites.contains(cell.getStringCellValue())) {
                     suites.add(peeps[4]);
                  }
                  break;
               case 5:
                  peeps[5] = cell.getStringCellValue();
                  if (!cities.contains(cell.getStringCellValue())) {
                     cities.add(peeps[5]);
                  }
                  break;

               case 6:
                  peeps[6] = cell.getStringCellValue();
                  if (!states.contains(cell.getStringCellValue())) {
                     states.add(peeps[6]);
                  }
                  break;
               
               case 7:
<<<<<<< HEAD
                  peeps[7] = String.valueOf((int)cell.getNumericCellValue());
                  if (!zips.contains(String.valueOf((int)cell.getNumericCellValue()))) {
=======
                  
                  peeps[7] = String.valueOf((int)cell.getNumericCellValue());
                  if (!zips.contains(String.valueOf(cell.getNumericCellValue()))) {
>>>>>>> 3528108f3e35bc15b2d4bf3fc4db48887725791a
                     zips.add(peeps[7]);
                  }
                  break;
               
               case 8:
                  peeps[8] = cell.getStringCellValue();
                  if (!phones.contains(cell.getStringCellValue())) {
                     phones.add(peeps[8]);
                  }
                  break;
               
               case 9:
                  peeps[9] = cell.getStringCellValue();
                  if (!practices.contains(cell.getStringCellValue())) {
                     practices.add(peeps[9]);
                  }
                  break;
               
               case 10:
                  peeps[10] = cell.getStringCellValue();
                  if (!emails.contains(cell.getStringCellValue())) {
                     emails.add(peeps[10]);
                  }
                  break;
               
               case 11:
                  dist = cell.getNumericCellValue();
                  if (!miles.contains(cell.getNumericCellValue())) {
                     miles.add(dist);
                  }
                  break;
               
               case 12:
                  time = (int) cell.getNumericCellValue();
                  if (!years.contains((int)cell.getNumericCellValue())) {
                     years.add(time);
                  }
                  break;
               
               case 13:
                  atts = (int) cell.getNumericCellValue();
                  if (!attorneys.contains((int)cell.getNumericCellValue())) {
                     attorneys.add(atts);
                  }
                  break;
               default:
                  System.out.println("error =" + cell.getColumnIndex());
                  break;
            }
         }
         
         people.add(new Person(peeps[0],peeps[1],peeps[2],peeps[3],peeps[4],peeps[5],
         peeps[6],peeps[7],peeps[8],peeps[9],peeps[10],dist,time,atts));
         

      }
      workbook.close();
      inputStream.close();
   }

   @FXML
   private void sortByChanged() {
      String selectedItem = (String) sortBy.getSelectionModel().getSelectedItem();
      updateFilter(selectedItem);

   }

   @FXML
   private void buttonClick() {
      updateTable();
   }
   
   @FXML
   private void refineSearch(){
      String word = searchBar.getText();
      System.out.println("word = " + word);
      
      // define a searching method that looks through all of a person's shit and 
      // sees if anypart of the word matches that, add them to the 
      //filtered people and set to table
      
      
   }
}
