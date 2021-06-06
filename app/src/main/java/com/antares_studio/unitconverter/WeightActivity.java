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

public class WeightActivity extends AppCompatActivity {
    EditText UserAnswer;
    Spinner firstSpinner;
    Spinner SecondSpinner;
    TextView answerTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        firstSpinner = findViewById(R.id.Weight_firstSpinner);
        SecondSpinner = findViewById(R.id.Weight_SecondSpinner);
        UserAnswer = findViewById(R.id.Weight_UserAnswer);
        answerTxt = findViewById(R.id.Weight_txt);
        //initializing both arrays
        ArrayList<String> secondSpinnerItems = new ArrayList<>();
        ArrayList<String> firstSpinnerItems = new ArrayList<>();
        //Adding items to both arrays
        firstSpinnerItems.add("gram");
        firstSpinnerItems.add("kilogram");
        firstSpinnerItems.add("pound");
        firstSpinnerItems.add("tonne");
        //*****************************
        secondSpinnerItems.add("gram");
        secondSpinnerItems.add("kilogram");
        secondSpinnerItems.add("pound");
        secondSpinnerItems.add("tonne");
        //Making array adapters for both arrays
        ArrayAdapter<String> secondSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,secondSpinnerItems);
        ArrayAdapter<String> firstSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,firstSpinnerItems);
        firstSpinner.setAdapter(firstSpinnerAdapter);
        SecondSpinner.setAdapter(secondSpinnerAdapter);
    }

    public void weightToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @SuppressLint("SetTextI18n")
    public void calculateWeight(View view) {
        //If by chance user enter a string we will catch it by using try catch
        try {
            //Defining all the important values
            Calculate cal = new Calculate();
            String first_val = firstSpinner.getSelectedItem().toString();
            String second_val = SecondSpinner.getSelectedItem().toString();
            Integer ans_into_int = Integer.valueOf(UserAnswer.getText().toString());
            if (first_val.equals("gram")){
                switch(second_val){
                    case "gram":{
                        answerTxt.setText(UserAnswer.getText().toString());
                        break;
                    }
                    case "kilogram": {
                        Integer ans = cal.calculate(ans_into_int, "divide", 1000);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                    case "pound":{
                        Integer ans = cal.calculate(ans_into_int, "divide", 454);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                    case "tonne":{
                        Integer ans = cal.calculate(ans_into_int, "divide", 1000000);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                }
            }
            if (first_val.equals("kilogram")){
                switch (second_val) {
                    case "gram": {
                        Integer ans = cal.calculate(ans_into_int, "multiply", 1000);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                    case "kilogram": {
                        answerTxt.setText(UserAnswer.getText().toString());
                        break;
                    }
                    case "pound": {
                        Integer ans = cal.calculate(ans_into_int, "multiply", 2);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                    case "tonne": {
                        Integer ans = cal.calculate(ans_into_int, "divide", 1000);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                }
            }
            if (first_val.equals("pound")){
                switch (second_val) {
                    case "gram": {
                        Integer ans = cal.calculate(ans_into_int, "multiply", 454);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                    case "kilogram": {
                        Integer ans = cal.calculate(ans_into_int, "multiply", 2);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                    case "pound": {
                        answerTxt.setText(UserAnswer.getText().toString());
                        break;
                    }
                    case "tonne": {
                        Integer ans = cal.calculate(ans_into_int, "divide", 2205);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                }
            }
            if (first_val.equals("tonne")){
                switch (second_val) {
                    case "gram": {
                        Integer ans = cal.calculate(ans_into_int, "multiply", 1000000);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                    case "kilogram": {
                        Integer ans = cal.calculate(ans_into_int, "multiply", 1000);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                    case "pound": {
                        Integer ans = cal.calculate(ans_into_int, "multiply", 2205);
                        answerTxt.setText(ans.toString());
                        break;
                    }
                    case "tonne": {
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