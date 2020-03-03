package com.example.calculator;

import android.text.Editable;

import java.util.ArrayList;

public class Calculator {
    public static String calculation (Editable newEquation) {

        String eq = EquationHandler.toCorrectEquation(newEquation); // корректируем входное выражение: добавляем знаки *, обрабатываем отрицательные числа

        String[] reversePolishNotation = EquationHandler.toReversePolishNotation(eq); // преобразуем корректное выражение в обратную полькую нотацию

        ArrayList<String> dynamicReversePolishNotation = new ArrayList<>();
        for (int i = 0; i < reversePolishNotation.length; i++) { // преобразование массива строк в динамический массив строк
            dynamicReversePolishNotation.add(i, reversePolishNotation[i]);
        }

        for (int i = 0; i < dynamicReversePolishNotation.size() - 1; i++) { // последовательное вычисление по ОПН

            double firstNumber = 0.0;
            double secondNumber = 0.0;
            double resultNumber = 0.0;

            if (dynamicReversePolishNotation.get(i).equals("*") || dynamicReversePolishNotation.get(i).equals("/") || dynamicReversePolishNotation.get(i).equals("+") || dynamicReversePolishNotation.get(i).equals("-")) {
                firstNumber = Double.valueOf(dynamicReversePolishNotation.get(i - 2));
                secondNumber = Double.valueOf(dynamicReversePolishNotation.get(i - 1));
                if (dynamicReversePolishNotation.get(i).equals("*")) resultNumber = firstNumber * secondNumber;
                if (dynamicReversePolishNotation.get(i).equals("/")) resultNumber = firstNumber / secondNumber;
                if (dynamicReversePolishNotation.get(i).equals("+")) resultNumber = firstNumber + secondNumber;
                if (dynamicReversePolishNotation.get(i).equals("-")) resultNumber = firstNumber - secondNumber;

                dynamicReversePolishNotation.remove(i);
                dynamicReversePolishNotation.remove(i - 1);
                dynamicReversePolishNotation.set(i - 2, String.valueOf(resultNumber));

                i = 0;
            }
        }

        String resultString = dynamicReversePolishNotation.get(0);

        return resultString;
    }
}
