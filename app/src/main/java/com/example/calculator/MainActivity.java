package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private float lo, ro = 0;
    private char opa = '\0';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void num_pressed(char num) {
        TextView digit = findViewById(R.id.digit);
        if (digit.getText().equals("0")) {
            if (num != '0')
                digit.setText(num + "");
        } else {
            digit.setText(digit.getText().toString() + num);
        }
    }

    public void click1(View view) {
        num_pressed('1');
    }

    public void click2(View view) {
        num_pressed('2');
    }

    public void click3(View view) {
        num_pressed('3');
    }

    public void click4(View view) {
        num_pressed('4');
    }

    public void click5(View view) {
        num_pressed('5');
    }

    public void click6(View view) {
        num_pressed('6');
    }

    public void click7(View view) {
        num_pressed('7');
    }

    public void click8(View view) {
        num_pressed('8');
    }

    public void click9(View view) {
        num_pressed('9');
    }

    public void click0(View view) {
        num_pressed('0');
    }

    public void clickC(View view) {
        TextView digit = findViewById(R.id.digit);
        if (digit.getText().equals("0")) {
            lo = ro = 0;
            opa = '\0';
            display("");
        }
        else {
            digit.setText("0");
        }
    }
    @SuppressLint("SetTextI18n")
    private void display(String rr){
        TextView line = findViewById(R.id.line);
        line.setText(Float.toString(lo).replaceAll("\\.?0*$","") + opa + rr);
    }

    public void divi(View view) {
        opas('/');
    }

    public void subs(View view) {
        opas('-');
    }

    public void addi(View view) {
        opas('+');
    }

    public void equal(View view) {
        TextView digit = findViewById(R.id.digit);
        ro = Float.parseFloat(digit.getText().toString());
        operate();
    }
    private void opas(char o){
        TextView digit = findViewById(R.id.digit);
        //doted = false;
        if(opa == '\0') {
            opa = o;
            lo = Float.parseFloat(digit.getText().toString());
            digit.setText("0");
            display("");
        }
        else{
            ro = Float.parseFloat(digit.getText().toString());
            operate();
            opa = o;
            opas(o);
        }
    }
    @SuppressLint("SetTextI18n")
    private void operate(){
        TextView digit = findViewById(R.id.digit);
        display(Float.toString(ro).replaceAll("\\.?0*$","") );
        switch (opa){
            case '+':
                digit.setText(Float.toString(lo + ro).replaceAll("\\.?0*$","") );
                break;
            case '-':
                digit.setText(Float.toString(lo - ro).replaceAll("\\.?0*$","") );
                break;
            case '*':
                digit.setText(Float.toString(lo * ro).replaceAll("\\.?0*$","") );
                break;
            case '/':
                digit.setText(Float.toString(lo / ro).replaceAll("\\.?0*$","") );
                break;
        }
        ro = 0;
        opa = '\0';
    }

    public void dot(View view) {
        TextView digit = findViewById(R.id.digit);
        if(digit.getText().toString().indexOf('.') == -1) {
            digit.setText(digit.getText().toString() + ".");
        }
    }

    public void mult(View view) {
        opas('*');
    }
}