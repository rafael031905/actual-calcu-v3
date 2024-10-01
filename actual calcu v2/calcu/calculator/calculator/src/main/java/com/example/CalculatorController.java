package com.example;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Group Name: Group Ampalaya
 * Group Members: 
 * Benipayo, Rafael Andrei
 * Constantino, Mary Julia 
 * Granada, Dustin Joaquin
 * Manaog, Ron Denzel
 * Marcelino, Marcus Dhenzel
 * Nicolas, Annjela Kristy
 * Course/Section: CSS124L/BM1
 */

public class CalculatorController {

// current num, previous num, and ops
    private double currentNumber = 0;
    private double previousNumber = 0;
    private String currentOperation = "";
    private boolean startNewNumber = true;
    private boolean hasDecimal = false;
//

    @FXML Label calcDisplay;
    @FXML Button calcPad1;
    @FXML Button calcPad2;
    @FXML Button calcPad3;
    @FXML Button calcPad4;
    @FXML Button calcPad5;
    @FXML Button calcPad6;
    @FXML Button calcPad7;
    @FXML Button calcPad8;
    @FXML Button calcPad9;
    @FXML Button calcPad0;
    @FXML Button calcPadAdd;
    @FXML Button calcPadMinus;
    @FXML Button calcPadMultiply;
    @FXML Button calcPadDivide;
    @FXML Button calcPadDot;
    @FXML Button calcPadEquals;
    @FXML Button calcPadClear;
    @FXML Button calcPadNegative;
    @FXML Button calcPadDelete;
    @FXML Button calcPadCE;

//To update the display
    private void updateDisplay(String value) {
        if (startNewNumber) {
            calcDisplay.setText(value);
            startNewNumber = false;
        } else {
            calcDisplay.setText(calcDisplay.getText() + value);
        }
    }

///////////////////////////////////////////
    @FXML
    private void handleCalcPad1() {
        updateDisplay("1");    }

    @FXML
    private void handleCalcPad2() {
        updateDisplay("2");    }

    @FXML
    private void handleCalcPad3() {
        updateDisplay("3");    }

    @FXML
    private void handleCalcPad4() {
        updateDisplay("4");    }

    @FXML
    private void handleCalcPad5() {
        updateDisplay("5");    }

    @FXML
    private void handleCalcPad6() {
        updateDisplay("6");    }

    @FXML
    private void handleCalcPad7() {
        updateDisplay("7");    }

    @FXML
    private void handleCalcPad8() {
        updateDisplay("8");    }

    @FXML
    private void handleCalcPad9() {
        updateDisplay("9");    }

    @FXML
    private void handleCalcPad0() {
        updateDisplay("0");    }
///////////////////////////////////////////

//Add
    @FXML
    private void handleCalcPadAdd() {
        
        currentOperation = "+";
        previousNumber = Double.parseDouble(calcDisplay.getText());
        startNewNumber = true;   
        hasDecimal = false; }

//Minus
    @FXML
    private void handleCalcPadMinus() {
        
        currentOperation = "-";
        previousNumber = Double.parseDouble(calcDisplay.getText());
        startNewNumber = true;   
        hasDecimal = false; }

//Multip
    @FXML
    private void handleCalcPadMultiply() {
        
        currentOperation = "*";
        previousNumber = Double.parseDouble(calcDisplay.getText());
        startNewNumber = true;   
        hasDecimal = false; }

//Div
    @FXML
    private void handleCalcPadDivide() {
        
        currentOperation = "/";
        previousNumber = Double.parseDouble(calcDisplay.getText());
        startNewNumber = true;   
        hasDecimal = false; }

//Dot
    @FXML
    private void handleCalcPadDot() { 
        if (hasDecimal == false) {
            updateDisplay(".");
            hasDecimal = true;  
        }
    }

//Eq
    @FXML
    private void handleCalcPadEquals() {
        calculate();
        currentOperation = "";    }

//C
    @FXML
    private void handleCalcPadClear() {
        currentNumber = 0;
        calcDisplay.setText("0");
        startNewNumber = true;    
        hasDecimal = false;
    }

//Nega
    @FXML
    private void handleCalcPadNegative() {
        String currentText = calcDisplay.getText();

        // If the display is '0' or empty, just show the negative sign and wait for input
        if (currentText.equals("0") || currentText.isEmpty()) {
            calcDisplay.setText("-");
            startNewNumber = false;  // Allow the user to keep typing after pressing the negative button
        } else {
            // Toggle the sign of the current number
            double currentValue = Double.parseDouble(currentText);
            calcDisplay.setText(String.valueOf(currentValue * -1));
        }
    }

//Del
    @FXML
    private void handleCalcPadDelete() {
        String text = calcDisplay.getText();
        if (text.length() > 1) {
            calcDisplay.setText(text.substring(0, text.length() - 1));
        } else {
            calcDisplay.setText("0");
            startNewNumber = true;
        }
    }

//CE
    @FXML
    private void handleCalcPadCE() {
        currentNumber = 0;
        previousNumber = 0;
        currentOperation = "";
        calcDisplay.setText("0");
        startNewNumber = true;    
        hasDecimal = false;
    }

//Calcu
private void calculate() {
    if (!currentOperation.isEmpty()) {
        currentNumber = Double.parseDouble(calcDisplay.getText());

        switch (currentOperation) {
            case "+":
                currentNumber = previousNumber + currentNumber;
                break;

            case "-":
                currentNumber = previousNumber - currentNumber;
                break;

            case "*":
                currentNumber = previousNumber * currentNumber;
                break;

            case "/":
                if (currentNumber != 0) {
                    currentNumber = previousNumber / currentNumber;
                } else {
                    calcDisplay.setText("Syntax Error");
                    return;
                }
                break;
        }

//Decimals
        if (currentNumber == (long) currentNumber) {
            calcDisplay.setText(String.valueOf((long) currentNumber));  //Whole numbers
        } else {
            calcDisplay.setText(String.valueOf(currentNumber));  //Non-whole numbers
        }

        startNewNumber = true;    }
}
}