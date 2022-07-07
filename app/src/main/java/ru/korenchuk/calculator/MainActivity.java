package ru.korenchuk.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator;
    private TextView calcWindow;
    private Button buttonOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] numberIds = new int[]{
                R.id.button0,
                R.id.button1,
                R.id.button2,
                R.id.button3,
                R.id.button4,
                R.id.button5,
                R.id.button6,
                R.id.button7,
                R.id.button8,
                R.id.button9
        };

        int[] operatorIds = new int[]{
                R.id.buttonPlus,
                R.id.buttonMinus,
                R.id.buttonMultiple,
                R.id.buttonDivide,
                R.id.buttonEquals
        };
        calcWindow = findViewById(R.id.calcWindow);
        calculator = new Calculator();
        buttonOptions = findViewById(R.id.buttonOptions);


        View.OnClickListener numberButtonsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onNumberPressed(view.getId());
                calcWindow.setText(calculator.getText());
            }
        };

        View.OnClickListener operatorButtonsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onOperatorPressed(view.getId());
                calcWindow.setText(calculator.getText());
            }
        };

        buttonOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
                startActivity(intent);
            }
        });

        for (int numberId : numberIds) {
            findViewById(numberId).setOnClickListener(numberButtonsClickListener);
        }
        for (int operatorId : operatorIds) {
            findViewById(operatorId).setOnClickListener(operatorButtonsClickListener);
        }
    }
}