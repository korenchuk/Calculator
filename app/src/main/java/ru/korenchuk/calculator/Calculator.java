package ru.korenchuk.calculator;

import android.annotation.SuppressLint;

public class Calculator {

    int firstArgument, secondArgument;
    StringBuilder str = new StringBuilder();
    private State state;
    private int selectedOperator;

    public Calculator() {
        state = State.firstArgument;
    }

    @SuppressLint("NonConstantResourceId")
    public void onNumberPressed(int buttonId) {

        if (state == State.showResult) {
            state = State.firstArgument;
        }

        if (str.length() < 9) {
            switch (buttonId) {
                case R.id.button0:
                    if (str.length() != 0)
                        str.append(0);
                    break;
                case R.id.button1:
                    str.append(1);
                    break;
                case R.id.button2:
                    str.append(2);
                    break;
                case R.id.button3:
                    str.append(3);
                    break;
                case R.id.button4:
                    str.append(4);
                    break;
                case R.id.button5:
                    str.append(5);
                    break;
                case R.id.button6:
                    str.append(6);
                    break;
                case R.id.button7:
                    str.append(7);
                    break;
                case R.id.button8:
                    str.append(8);
                    break;
                case R.id.button9:
                    str.append(9);
                    break;
            }
        }
    }

    @SuppressLint("NonConstantResourceId")
    public void onOperatorPressed(int buttonId) {
        if (buttonId == R.id.buttonEquals && state == State.secondArgument) {
            secondArgument = Integer.parseInt(str.toString());
            state = State.showResult;
            str.setLength(0);
            switch (selectedOperator) {
                case R.id.buttonPlus:
                    str.append(firstArgument + secondArgument);
                    break;
                case R.id.buttonMinus:
                    str.append(firstArgument - secondArgument);
                    break;
                case R.id.buttonMultiple:
                    str.append(firstArgument * secondArgument);
                    break;
                case R.id.buttonDivide:
                    str.append(firstArgument / secondArgument);
                    break;
            }
        } else if (str.length() > 0 && state == State.firstArgument) {
            firstArgument = Integer.parseInt(str.toString());
            state = State.secondArgument;
            str.setLength(0);
            switch (buttonId) {
                case R.id.buttonPlus:
                    selectedOperator = R.id.buttonPlus;
                    break;
                case R.id.buttonMinus:
                    selectedOperator = R.id.buttonMinus;
                    break;
                case R.id.buttonMultiple:
                    selectedOperator = R.id.buttonMultiple;
                    break;
                case R.id.buttonDivide:
                    selectedOperator = R.id.buttonDivide;
                    break;
                case R.id.buttonEquals:
                    selectedOperator = R.id.buttonEquals;
                    break;
            }
        }
    }

    public String getText() {
        return str.toString();
    }

    private enum State {firstArgument, secondArgument, showResult}
}
