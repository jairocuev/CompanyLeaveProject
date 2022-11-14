package com.jairocuevas.controllers.employee;

import com.jairocuevas.App;
import com.jairocuevas.controllers.admin.AdminController;
import com.jairocuevas.models.Employee;
import com.jairocuevas.models.TimeOffRequest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable{
    @FXML private Label employeeNameLabel;
    @FXML private Label employeePtoBalanceLabel;
    @FXML private Button manageEmployeeRequestButton;
    @FXML private Button logoutButton;
    @FXML private Button requestTimeOffButton;
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker endDatePicker;
    @FXML private ChoiceBox ptoChoiceBox;

    private Object timeOffType;

    @Override
    public void initialize(URL url, ResourceBundle rb){
    	//this is just to set the login in page buttons and name of user to show up and days off. looks in the app.java for the current employee
    	
    	 employeeNameLabel.setText(App.currentEmployee.getName());
         employeePtoBalanceLabel.setText(String.valueOf(App.currentEmployee.getAccruedTime()));
         manageEmployeeRequestButton.setVisible(App.currentEmployee.isAdmin());
    }

    @SuppressWarnings("unchecked")
	public void init(Employee e){
    	System.out.println("we in the option box");
        if(e.getEmployeeType() == 0) ptoChoiceBox.getItems().add("Sick Leave");
        else if(e.getEmployeeType() == 1){
        	System.out.println("we in the option box123");
            ptoChoiceBox.getItems().add("Sick Leave");
            ptoChoiceBox.getItems().add("Maternity Leave");
            ptoChoiceBox.getItems().add("PTO");
            ptoChoiceBox.getItems().add("Emergency Leave");
        }


        ptoChoiceBox.setOnAction((event) -> {
            int selectedIndex = ptoChoiceBox.getSelectionModel().getSelectedIndex();
            Object selectedItem = ptoChoiceBox.getSelectionModel().getSelectedItem();

            timeOffType = selectedItem;
        });
    }

    @FXML
    public void logOut() throws IOException{
            FXMLLoader loader = new FXMLLoader(App.class.getResource("login.fxml"));
            Parent root = loader.load();

            Window window = logoutButton.getScene().getWindow();
            App.currentEmployee = null;

            if (window instanceof Stage) {
                Scene scene =  new Scene(root);
                Stage stage = (Stage) window ;
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            }
    }
    
    // code will be use if button is is visible, line 41 (if user is admin)

    @FXML
    public void manageEmployeeRequests() throws IOException{
        FXMLLoader loader = new FXMLLoader(App.class.getResource("admin.fxml"));
        Parent root = loader.load();

        Window window = logoutButton.getScene().getWindow();

        if (window instanceof Stage) {
            Scene scene =  new Scene(root);
            Stage stage = (Stage) window ;
            stage.setTitle("Admin Panel");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
    }

    @FXML
    public void requestTimeOff() throws IOException{
    	
    	//later will add to database
    	
    	AdminController.dayOffRequests.add(new TimeOffRequest(7,App.currentEmployee,startDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
    			endDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),timeOffType.toString()));
    	
    	
//        System.out.println("Start: "+ startDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//        System.out.println("End: "+ endDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//        System.out.println("Type: " + timeOffType);
    }

}
