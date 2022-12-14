package com.jairocuevas.controllers.admin;

import com.jairocuevas.App;
import com.jairocuevas.models.Employee;
import com.jairocuevas.models.TimeOffRequest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class AdminEmployeeController {
    @FXML
    private AnchorPane adminEmployeePane;
    @FXML
    private TextField employeeNameLabel;
    @FXML
    private Button backButton;
    @FXML
    private Button acceptButton;
    @FXML
    private Button denyButton;
    @FXML
    private TextField lastName;
    @FXML
    private Label responseLabel;
    
    TimeOffRequest reqe;
    

    public void setEmployeeName(String firstName, String lastNames){
    	System.out.println("yabbado");
        employeeNameLabel.setText(firstName);
        lastName.setText(lastNames);
        
    }
    @FXML
    public void accept() throws IOException{
    	responseLabel.setText(reqe.getEmployee().getName()+" Has been approved");
    	reqe.setApproveDeny("Aprove");
    }
    @FXML
    public void deny() throws IOException{
    	responseLabel.setText(reqe.getEmployee().getName()+" Has been denied");
    	reqe.setApproveDeny("Deny");
    }

    @FXML
    public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("admin.fxml"));
        Parent root = loader.load();

        Window window = backButton.getScene().getWindow();

        if (window instanceof Stage) {
            Scene scene =  new Scene(root);
            Stage stage = (Stage) window ;
            stage.setTitle("Admin Panel");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }

    }

	public void init(TimeOffRequest req) {
		// TODO Auto-generated method stub
		System.out.println(req.getEmployee().getName());
		reqe=req;
	}

}
