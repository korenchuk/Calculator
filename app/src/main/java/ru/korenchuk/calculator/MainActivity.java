package ru.korenchuk.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8,
            button9, buttonDot, buttonPlus, buttonMinus, buttonDivide, buttonMultiple,
            buttonEquals;
    String operationType;
    TextView calcWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDot = findViewById(R.id.buttonDot);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonMultiple = findViewById(R.id.buttonMultiple);
        buttonEquals = findViewById(R.id.buttonEquals);

        calcWindow = findViewById(R.id.calcWindow);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        float firstArgument = 0;
        float secondArgument = 0;
        float result = 0;

        switch (view.getId()) {
            case R.id.buttonPlus:
                operationType = "+";
                result = firstArgument + secondArgument;
                break;
            case R.id.buttonMinus:
                operationType = "-";
                result = firstArgument - secondArgument;
                break;
            case R.id.buttonMultiple:
                operationType = "*";
                result = firstArgument * secondArgument;
                break;
            case R.id.buttonDivide:
                operationType = "/";
                result = firstArgument / secondArgument;
                break;
            default:
                break;
        }
        calcWindow.setText(firstArgument + " " + operationType + " " + secondArgument + " = " + result);

    }

}