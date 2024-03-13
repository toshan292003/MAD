package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button btnAdd,btnSub,btnMul,btnDiv,btnEqual,btnDot,btnClear;
    EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0=(Button) findViewById(R.id.btn0);
        btn1=(Button) findViewById(R.id.btn1);
        btnAdd =(Button) findViewById(R.id.btnA);
        btnClear=(Button) findViewById(R.id.btnC);
        btnEqual=(Button) findViewById(R.id.btnE);
        display =(EditText)findViewById(R.id.Disp);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                display.append("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                display.append("1");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.append("+");
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("");
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = display.getText().toString();
                if(data.contains("-")){
                    String operands[] = data.split("-");
                    double op1 = Double.parseDouble(operands[0]);
                    double op2 = Double.parseDouble(operands[1]);
                    double res = op1-op2; display.setText(String.valueOf(res));}
                if(data.contains("x")){
                    String operands[] = data.split("x");
                    double op1 = Double.parseDouble(operands[0]);
                    double op2 = Double.parseDouble(operands[1]);
                    double res = op1*op2;
                    display.setText(String.valueOf(res));
                }
                if(data.contains("/")){


                    String operands[] = data.split("/");
                    double op1 = Double.parseDouble(operands[0]);
                    double op2 = Double.parseDouble(operands[1]);


                    if(op2==0){
                        Toast.makeText(MainActivity.this,

                                "Divide by zero is not possible", Toast.LENGTH_SHORT).show();
                    }
                    double res = op1/op2;
                    display.setText(String.valueOf(res));
                }

                if(data.contains("+")){


                    String operands[] =data.split(Pattern.quote("+"));
                    double op1 = Double.parseDouble(operands[0]);
                    double op2 = Double.parseDouble(operands[1]);
                    double res = op1+op2;
                    display.setText(String.valueOf(res));


                }
            }
        });






    }
}