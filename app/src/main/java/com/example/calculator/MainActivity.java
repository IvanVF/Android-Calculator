package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  {

    EditText monitorField;

    boolean isButtonDotUsed = false,
            isButtonNegativeNumberUsed = false,
            isButtonPlusUsed = true,
            isButtonMinusUsed = true,
            isButtonDivisionUsed = true,
            isButtonMultiplicationUsed = true,
            isButtonBracketOpenUsed = false;



    int numberOfOpenBracket = 0,
        numberOfStillOpenBracket = 0,
        numberOfClosedBracket = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monitorField = (EditText) findViewById(R.id.monitorField);
    }

    public void onButtonDeleteClick (View view)
    {
        Button buttonDelete = (Button)view;
        Editable newEquation = monitorField.getText(); // считываем введённое выражение
        String eq = newEquation.toString();
        if(!eq.equals(""))
        {
            char[] equation = eq.toCharArray();
            String correctedEquation = "";
            for (int i = 0; i < equation.length - 1; i++) correctedEquation = correctedEquation + equation[i];
            monitorField.setText(correctedEquation);

            if (equation[equation.length - 1] == '/' || equation[equation.length - 1] == '*' || equation[equation.length - 1] == '+' || equation[equation.length - 1] == '-') {
                isButtonPlusUsed = false;
                isButtonMinusUsed = false;
                isButtonDivisionUsed = false;
                isButtonNegativeNumberUsed = false;
                isButtonMultiplicationUsed = false;
            }

            if (equation[equation.length - 1] == '.') isButtonDotUsed = false;
            if (equation[equation.length - 1] == ')') numberOfClosedBracket--;
            if (equation[equation.length - 1] == '(') {
                numberOfOpenBracket--;
                numberOfStillOpenBracket--;
            }
        }
    }

    public void onButtonZeroClick (View view) {
        Button buttonZero = (Button)view;
        monitorField.append(buttonZero.getText());
        isButtonPlusUsed = false;
        isButtonMinusUsed = false;
        isButtonDivisionUsed = false;
        isButtonNegativeNumberUsed = false;
        isButtonMultiplicationUsed = false;
        isButtonBracketOpenUsed = false;
    }

    public void onButton1Click (View view){
        Button button1 = (Button)view;
        monitorField.append(button1.getText());
        isButtonPlusUsed = false;
        isButtonMinusUsed = false;
        isButtonDivisionUsed = false;
        isButtonNegativeNumberUsed = false;
        isButtonMultiplicationUsed = false;
        isButtonBracketOpenUsed = false;
    }

    public void onButton2Click (View view){
        Button button2 = (Button)view;
        monitorField.append(button2.getText());
        isButtonPlusUsed = false;
        isButtonMinusUsed = false;
        isButtonDivisionUsed = false;
        isButtonNegativeNumberUsed = false;
        isButtonMultiplicationUsed = false;
        isButtonBracketOpenUsed = false;
    }

    public void onButton3Click (View view){
        Button button3 = (Button)view;
        monitorField.append(button3.getText());
        isButtonPlusUsed = false;
        isButtonMinusUsed = false;
        isButtonDivisionUsed = false;
        isButtonNegativeNumberUsed = false;
        isButtonMultiplicationUsed = false;
        isButtonBracketOpenUsed = false;
    }

    public void onButton4Click (View view){
        Button button4 = (Button)view;
        monitorField.append(button4.getText());
        isButtonPlusUsed = false;
        isButtonMinusUsed = false;
        isButtonDivisionUsed = false;
        isButtonNegativeNumberUsed = false;
        isButtonMultiplicationUsed = false;
        isButtonBracketOpenUsed = false;
    }

    public void onButton5Click (View view) {
        Button button5 = (Button)view;
        monitorField.append(button5.getText());
        isButtonPlusUsed = false;
        isButtonMinusUsed = false;
        isButtonDivisionUsed = false;
        isButtonNegativeNumberUsed = false;
        isButtonMultiplicationUsed = false;
        isButtonBracketOpenUsed = false;
    }

    public void onButton6Click (View view) {
        Button button6 = (Button)view;
        monitorField.append(button6.getText());
        isButtonPlusUsed = false;
        isButtonMinusUsed = false;
        isButtonDivisionUsed = false;
        isButtonNegativeNumberUsed = false;
        isButtonMultiplicationUsed = false;
        isButtonBracketOpenUsed = false;
    }

    public void onButton7Click (View view) {
        Button button7 = (Button)view;
        monitorField.append(button7.getText());
        isButtonPlusUsed = false;
        isButtonMinusUsed = false;
        isButtonDivisionUsed = false;
        isButtonNegativeNumberUsed = false;
        isButtonMultiplicationUsed = false;
        isButtonBracketOpenUsed = false;
    }

    public void onButton8Click (View view) {
        Button button8 = (Button)view;
        monitorField.append(button8.getText());
        isButtonPlusUsed = false;
        isButtonMinusUsed = false;
        isButtonDivisionUsed = false;
        isButtonNegativeNumberUsed = false;
        isButtonMultiplicationUsed = false;
        isButtonBracketOpenUsed = false;
    }

    public void onButton9Click (View view) {
        Button button9 = (Button)view;
        monitorField.append(button9.getText());
        isButtonPlusUsed = false;
        isButtonMinusUsed = false;
        isButtonDivisionUsed = false;
        isButtonNegativeNumberUsed = false;
        isButtonMultiplicationUsed = false;
        isButtonBracketOpenUsed = false;
    }

    public void onButtonBracketOpenClick (View view){
        Button buttonBracketOpen = (Button)view;
        monitorField.append(buttonBracketOpen.getText());
        numberOfOpenBracket++;
        numberOfStillOpenBracket++;
        isButtonBracketOpenUsed = true;
        isButtonNegativeNumberUsed = false;
    }

    public void onButtonBracketCloseClick (View view) {
        Button buttonBracketClose = (Button)view;
        Editable newEquation = monitorField.getText();
        String eq = newEquation.toString();
        char[] equation = eq.toCharArray();
        if (numberOfStillOpenBracket > 0) {
            if (equation[equation.length - 1] == ')' || equation[equation.length - 1] == '1' || equation[equation.length - 1] == '2' || equation[equation.length - 1] == '3' || equation[equation.length - 1] == '4' || equation[equation.length - 1] == '5' || equation[equation.length - 1] == '6' || equation[equation.length - 1] == '7' || equation[equation.length - 1] == '8' || equation[equation.length - 1] == '9' || equation[equation.length - 1] == '0') {
                monitorField.append(buttonBracketClose.getText());
                numberOfStillOpenBracket--;
                numberOfClosedBracket++;
            }
        }
    }

    public void onButtonClearClick (View view) {
        Button buttonClear = (Button)view;
        monitorField.setText("");
        numberOfOpenBracket = 0;
        numberOfClosedBracket = 0;
        numberOfStillOpenBracket = 0;
        isButtonDotUsed = false;

        isButtonPlusUsed = true;
        isButtonMinusUsed = true;
        isButtonDivisionUsed = true;
        isButtonMultiplicationUsed = true;
        isButtonNegativeNumberUsed = false;
        isButtonBracketOpenUsed = false;
    }

    public void onButtonNegativeNumberClick (View view) {
        Button buttonNegativeNumber = (Button)view;
        if (isButtonNegativeNumberUsed == false) {
            monitorField.append("-");
            isButtonNegativeNumberUsed = true;

            isButtonPlusUsed = true;
            isButtonMinusUsed = true;
            isButtonDivisionUsed = true;
            isButtonMultiplicationUsed = true;

        }
    }

    public void onButtonDivisionClick (View view) {
        Button buttonDivision = (Button)view;
        if ((isButtonDivisionUsed == false) & (isButtonBracketOpenUsed == false)) {
            monitorField.append(buttonDivision.getText());
            isButtonDotUsed = false;

            isButtonPlusUsed = true;
            isButtonMinusUsed = true;
            isButtonDivisionUsed = true;
            isButtonMultiplicationUsed = true;
            isButtonNegativeNumberUsed = true;


        }
    }

    public void onButtonMultiplicationClick (View view) {
        Button buttonMultiplication = (Button)view;
        if ((isButtonMultiplicationUsed == false) && (isButtonBracketOpenUsed == false)) {
            monitorField.append(buttonMultiplication.getText());
            isButtonDotUsed = false;

            isButtonPlusUsed = true;
            isButtonMinusUsed = true;
            isButtonDivisionUsed = true;
            isButtonMultiplicationUsed = true;
            isButtonNegativeNumberUsed = true;
        }
    }

    public void onButtonMinusClick (View view) {
        Button buttonMinus = (Button)view;
        if ((isButtonMinusUsed == false) && (isButtonBracketOpenUsed == false)) {
            monitorField.append(buttonMinus.getText());
            isButtonDotUsed = false;

            isButtonPlusUsed = true;
            isButtonMinusUsed = true;
            isButtonDivisionUsed = true;
            isButtonMultiplicationUsed = true;
            isButtonNegativeNumberUsed = true;
        }
    }

    public void onButtonPlusClick (View view) {
        Button buttonPlus = (Button)view;
        if ((isButtonPlusUsed == false) && (isButtonBracketOpenUsed == false))
        monitorField.append(buttonPlus.getText());
        isButtonDotUsed = false;

        isButtonPlusUsed = true;
        isButtonMinusUsed = true;
        isButtonDivisionUsed = true;
        isButtonMultiplicationUsed = true;
        isButtonNegativeNumberUsed = true;
    }

    public void onButtonDotClick (View view) {
        Button buttonDot = (Button)view;
        if (isButtonDotUsed == false){
            monitorField.append(buttonDot.getText());
            isButtonDotUsed = true;

            isButtonPlusUsed = true;
            isButtonMinusUsed = true;
            isButtonDivisionUsed = true;
            isButtonMultiplicationUsed = true;
            isButtonNegativeNumberUsed = true;
        }

    }

    public void onButtonCalculationClick (View view) {
        Button buttonCalculation = (Button)view;

        if (numberOfOpenBracket != numberOfClosedBracket){
            monitorField.setText("Ошибка скобок");
            numberOfOpenBracket = 0;
            numberOfClosedBracket = 0;
            numberOfStillOpenBracket = 0;

        } else {
            Editable equation = monitorField.getText();

            String result = Calculator.calculation(equation);

            monitorField.setText(result);

            isButtonDotUsed = false;


        }
    }


}

