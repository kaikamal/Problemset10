package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.math.BigDecimal;
import java.math.MathContext;

public class TargetHeartRateCalculatorController {
    @FXML
    private TextField ageTextField;

    @FXML
    private TextField targetHeartRateRangeTextField;

    @FXML
    void calculateButtonPressed(ActionEvent event) {
        try{
            BigDecimal age = new BigDecimal(ageTextField.getText());
            if(age.compareTo(new BigDecimal(0))<=0){
                throw  new NumberFormatException();
            }
            BigDecimal maximumHeartRate = new BigDecimal(220).subtract(age);
            BigDecimal heartRateLower = maximumHeartRate.multiply(new BigDecimal(0.50)).round(new MathContext(4));
            BigDecimal heartRateUpper = maximumHeartRate.multiply(new BigDecimal(0.85)).round(new MathContext(4));
            String result = String.format("%s bpm - %s bpm",heartRateLower.toString(),heartRateUpper.toString());
            targetHeartRateRangeTextField.setText(result);
        }
        catch (NumberFormatException ex){
            ageTextField.setText("Enter your age");
            ageTextField.selectAll();
            ageTextField.requestFocus();
        }
    }
}
