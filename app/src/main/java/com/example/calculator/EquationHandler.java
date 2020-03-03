package com.example.calculator;

//Добавляет 0 перед отрицательными числами
//Добавляет знаки умножения перед открывающимися скобками

import android.text.Editable;

import java.util.ArrayList;

public class EquationHandler {
    public static String toCorrectEquation (Editable nonCorrectEquation) {
        String correctEquation="";
        String equationStringWithZ = nonCorrectEquation.toString() + 'Z';
        char[] equationCharWithZ = equationStringWithZ.toCharArray();
        char[] equationCorrectionCharWithZ = new char[equationCharWithZ.length * 2];
        int countNew = 1;

//добавить 0, если в начале выражения стоит отрицательное число
        if (equationCharWithZ[0] == '-') {
            equationCorrectionCharWithZ[0] = '0';
            equationCorrectionCharWithZ[1] = '-';
            countNew = 2;

        }
        else equationCorrectionCharWithZ[0] = equationCharWithZ[0];

//Добаить * перед открывающеся скобкой
        for (int countOld = 1; countOld < equationCharWithZ.length; countOld++) {
            if ((equationCharWithZ[countOld] == '(') && (equationCharWithZ[countOld-1] == ')' || equationCharWithZ[countOld-1] == '0' || equationCharWithZ[countOld-1] == '1' || equationCharWithZ[countOld-1] == '2' || equationCharWithZ[countOld-1] == '3' || equationCharWithZ[countOld-1] == '4' || equationCharWithZ[countOld-1] == '5' || equationCharWithZ[countOld-1] == '6' || equationCharWithZ[countOld-1] == '7' || equationCharWithZ[countOld-1] == '8' || equationCharWithZ[countOld-1] == '9')) {
                equationCorrectionCharWithZ[countNew] = '*';
                countNew++;
                equationCorrectionCharWithZ[countNew] = equationCharWithZ[countOld];
                countNew++;
            }

//Добавить 0 перед отрицательным числом
            else if ((equationCharWithZ[countOld] == '-') && (equationCharWithZ[countOld-1] == '(')) {
                equationCorrectionCharWithZ[countNew] = '0';
                countNew++;
                equationCorrectionCharWithZ[countNew] = '-';
                countNew++;
            }

            else {
                equationCorrectionCharWithZ[countNew] = equationCharWithZ[countOld];
                countNew++;
            }

        }

        for (int i = 0; i < countNew - 1; i++) correctEquation = correctEquation + equationCorrectionCharWithZ[i];

        return correctEquation;
    }

    public static String[] toReversePolishNotation (String correctEquation) { // преобразование инфиксной нотации в обратную польскую (ОПН)

        String[] reversePolishNotationLong = new String[correctEquation.length()];

        ArrayList<Character> stackOfAct = new ArrayList<>(); // стек знаков () +- */
        int countStackOfAct = 0;

        String currentNumber = ""; //число будет формироваться из цифр идущих подряд в выражении

        int countReversePolishNotation = 0;


        correctEquation = correctEquation + 'Z'; // Метка конца выражения
        char[] equationChar = correctEquation.toCharArray();

        for (int i = 0; i < equationChar.length; i++) { // последовательный проход по всему выражению
            if (equationChar[i] == '1' || equationChar[i] == '2' || equationChar[i] == '3' || equationChar[i] == '4' || equationChar[i] == '5' || equationChar[i] == '6' || equationChar[i] == '7' || equationChar[i] == '8' || equationChar[i] == '9' || equationChar[i] == '0' || equationChar[i] == '.') { //считывание цифр в массив числа
                currentNumber = currentNumber + equationChar[i]; //формируем число из цифр
            }
            else {

                if (currentNumber != "" && (equationChar[i] == '(' || equationChar[i] == ')' || equationChar[i] == '-' || equationChar[i] == '/' || equationChar[i] == '*' || equationChar[i] == '+' || equationChar[i] == 'Z')) {
                    reversePolishNotationLong[countReversePolishNotation] = currentNumber; // запись числа в стек обратной Польской Нотации
                    countReversePolishNotation++;
                    currentNumber = "";
                }

                if (equationChar[i] == '(' || equationChar[i] == ')' || equationChar[i] == '-' || equationChar[i] == '/' || equationChar[i] == '*' || equationChar[i] == '+'){
                    if (countStackOfAct == 0) { // если стек операций пуст, просто записываем туда операцию
                        stackOfAct.add(countStackOfAct, equationChar[i]);
                        countStackOfAct++;
                    }

                    else {
                        if ((stackOfAct.get(countStackOfAct - 1) == '*' || stackOfAct.get(countStackOfAct - 1) == '/') && (equationChar[i] == '+' || equationChar[i] == '-')) { //если приоритет текущего действия ниже предыдущего, перекидываем предыдущее в стек ОПН
                            reversePolishNotationLong[countReversePolishNotation] = String.valueOf(stackOfAct.get(countStackOfAct - 1));
                            countReversePolishNotation++;
                            countStackOfAct--;
                            stackOfAct.set(countStackOfAct, null); // удаление знака из стека действий
                            i--;
                        }

                        else if (equationChar[i] == ')') { //если закрылась скобка, перекидываем все действия из стека действий в стек ОПН пока не встретится открывающаяся скобка
                            while (stackOfAct.get(countStackOfAct - 1) != '(')  {
                                reversePolishNotationLong[countReversePolishNotation] = String.valueOf(stackOfAct.get(countStackOfAct - 1));
                                countReversePolishNotation++;
                                countStackOfAct--;
                                stackOfAct.set(countStackOfAct, null); // удаление знака из стека действий
                            }
                            if (stackOfAct.get(countStackOfAct - 1) == '(') { // удаляем открывающуюся скобку
                                stackOfAct.set(countStackOfAct - 1, null);
                                countStackOfAct--;
                            }
                        }

                        else if ( (equationChar[i] == '+' && stackOfAct.get(countStackOfAct - 1) == '+') || (equationChar[i] == '-' && stackOfAct.get(countStackOfAct - 1) == '-') || (equationChar[i] == '+' && stackOfAct.get(countStackOfAct - 1) == '-') || (equationChar[i] == '-' && stackOfAct.get(countStackOfAct - 1) == '+') || (equationChar[i] == '*' && stackOfAct.get(countStackOfAct - 1) == '/') || (equationChar[i] == '/' && stackOfAct.get(countStackOfAct - 1) == '*') || (equationChar[i] == '/' && stackOfAct.get(countStackOfAct - 1) == '/') || (equationChar[i] == '*' && stackOfAct.get(countStackOfAct - 1) == '*') ) { //если приоритет текущего и предыдущего действий одинаковый, предыдущее записываем в стек ОПН
                            reversePolishNotationLong[countReversePolishNotation] = String.valueOf(stackOfAct.get(countStackOfAct - 1)); // записываем в  стек ОПН предыдущее действие
                            countReversePolishNotation++;
                            stackOfAct.set(countStackOfAct - 1, equationChar[i]); // на место предыдущего действия в стек знаков ставим текущее действие
                        }

                        else {
                            stackOfAct.add(countStackOfAct, equationChar[i]);
                            countStackOfAct++;
                        }
                    }
                }
            }

            if (equationChar[i] == 'Z') { // перекидываем оставшиеся в стеке действий операции в стек ОПН
                for (; countStackOfAct > 0; countStackOfAct--) {
                    reversePolishNotationLong[countReversePolishNotation] = String.valueOf(stackOfAct.get(countStackOfAct - 1));
                    countReversePolishNotation++;
                }
            }
        }


        String[] reversePolishNotation = new String[countReversePolishNotation + 1];
        for (int i = 0; i < countReversePolishNotation; i++) { // сокращаем длину стека ОПН
            reversePolishNotation[i] = reversePolishNotationLong[i];
        }

        return reversePolishNotation;
    }
}
