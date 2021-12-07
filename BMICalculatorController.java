package com.example.demo2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BMICalculatorController {

    @FXML
    private TextField heightTextField;

    @FXML
    private TextField resultTextField;

    @FXML
    private TextField weightTextField;

    @FXML
    void metricUnitsButtonPressed(ActionEvent event) {
        try{
            double weight = Double.parseDouble(weightTextField.getText());
            double height = Double.parseDouble(heightTextField.getText());
            double value = (weight/Math.pow(height,2));


            if(value<18.5){
                resultTextField.setText("Underweight");
            }
            else if(value>=18.5 && value<= 24.9){
                resultTextField.setText("Normal");
            }
            else if(value>=25 && value<= 29.9){
                resultTextField.setText("Overweight");
            }
            else{
                resultTextField.setText("Obese");
            }
        }
        catch (NumberFormatException ex){
            weightTextField.setText("Enter weight");
            heightTextField.setText("Enter height");
            weightTextField.selectAll();
            weightTextField.requestFocus();
        }
    }
    @FXML
    void englishUnitsButtonPressed(ActionEvent event) {
        try{
            double weight = Double.parseDouble(weightTextField.getText());
            double height = Double.parseDouble(heightTextField.getText());
            double value = 703 * (weight/Math.pow(height,2));
            if(value<0){
                throw new NumberFormatException();
            }
            if(value<18.5){
                resultTextField.setText("Underweight");            }
            else if(value>=18.5 && value<= 24.9){
                resultTextField.setText("Normal");
            }
            else if(value>=25 && value<= 29.9){
                resultTextField.setText("Overweight");
            }
            else{
                resultTextField.setText("Obese");
            }

        }
        catch (NumberFormatException ex){
            weightTextField.setText("Enter weight");
            heightTextField.setText("Enter height");
            weightTextField.selectAll();
            weightTextField.requestFocus();
        }
    }

}
