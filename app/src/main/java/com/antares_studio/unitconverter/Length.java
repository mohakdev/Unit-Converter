package com.antares_studio.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Length extends AppCompatActivity {
    EditText UserAnswer;
    Spinner firstSpinner;
    Spinner SecondSpinner;
    TextView answerTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        firstSpinner = findViewById(R.id.length_firstSpinner);
        SecondSpinner = findViewById(R.id.length_SecondSpinner);
        UserAnswer = findViewById(R.id.length_UserAnswer);
        answerTxt = findViewById(R.id.Length_txt);
        //initializing both arrays
        ArrayList<String> secondSpinnerItems = new ArrayList<>();
        ArrayList<String> firstSpinnerItems = new ArrayList<>();
        //Adding items to both arrays
        firstSpinnerItems.add("Centimeter");
        firstSpinnerItems.add("Millimeter");
        firstSpinnerItems.add("Meter");
        firstSpinnerItems.add("Kilometer");
        secondSpinnerItems.add("Centimeter");
        secondSpinnerItems.add("Millimeter");
        secondSpinnerItems.add("Meter");
        secondSpinnerItems.add("Kilometer");
        //Making array adapters for both arrays
        ArrayAdapter<String> secondSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,secondSpinnerItems);
        ArrayAdapter<String> firstSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,firstSpinnerItems);
        firstSpinner.setAdapter(firstSpinnerAdapter);
        SecondSpinner.setAdapter(secondSpinnerAdapter);
    }
    public void lengthToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    @SuppressLint("SetTextI18n")
    public void Calculate(View view) {
        //If by chance user enter a string we will catch it by using try catch
        try {
            //Defining all the important values
            Calculate cal = new Calculate();
            String first_val = firstSpinner.getSelectedItem().toString();
            String second_val = SecondSpinner.getSelectedItem().toString();
            Integer ans_into_int = Integer.valueOf(UserAnswer.getText().toString());
            if (first_val.equals("Millimeter")){
                switch(second_val){
                    case "Millimeter":{
                        answerTxt.setText(UserAnswer.getText().toString());
                        break;
                    }
                    case "Centimeter": {
                        Integer ans = cal.calculate(ans_into_int, "divide", 10);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                    case "Meter":{
                        Integer ans = cal.calculate(ans_into_int, "divide", 1000);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                    case "Kilometer":{
                        Integer ans = cal.calculate(ans_into_int, "divide", 1000000);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                }
            }
            if (first_val.equals("Centimeter")){
                switch (second_val) {
                    case "Millimeter": {
                        Integer ans = cal.calculate(ans_into_int, "multiply", 10);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                    case "Centimeter": {
                        answerTxt.setText(UserAnswer.getText().toString());
                        break;
                    }
                    case "Meter": {
                        Integer ans = cal.calculate(ans_into_int, "divide", 100);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                    case "Kilometer": {
                        Integer ans = cal.calculate(ans_into_int, "divide", 100000);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                }
            }
            if (first_val.equals("Meter")){
                switch (second_val) {
                    case "Millimeter": {
                        Integer ans = cal.calculate(ans_into_int, "multiply", 1000);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                    case "Centimeter": {
                        Integer ans = cal.calculate(ans_into_int, "multiply", 100);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                    case "Meter": {
                        answerTxt.setText(UserAnswer.getText().toString());
                        break;
                    }
                    case "Kilometer": {
                        Integer ans = cal.calculate(ans_into_int, "divide", 1000);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                }
            }
            if (first_val.equals("Kilometer")){
                switch (second_val) {
                    case "Millimeter": {
                        Integer ans = cal.calculate(ans_into_int, "multiply", 1000000);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                    case "Centimeter": {
                        Integer ans = cal.calculate(ans_into_int, "multiply", 100);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                    case "Meter": {
                        Integer ans = cal.calculate(ans_into_int, "multiply", 1000);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                    case "Kilometer": {
                        answerTxt.setText(UserAnswer.getText().toString());
                        break;
                    }
                }
            }

        }
        catch(Exception e){
            Toast.makeText(this, "TextBox does not contain any numbers", Toast.LENGTH_SHORT).show();
        }
    }
}