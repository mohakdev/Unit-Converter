package com.antares_studio.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DigitalStorageActivity extends AppCompatActivity {
    EditText UserAnswer;
    Spinner firstSpinner;
    Spinner SecondSpinner;
    TextView answerTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital);
        firstSpinner = findViewById(R.id.Dgt_firstSpinner);
        SecondSpinner = findViewById(R.id.Dgt_SecondSpinner);
        UserAnswer = findViewById(R.id.Dgt_UserAnswer);
        answerTxt = findViewById(R.id.Dgt_txt);
        //initializing both arrays
        ArrayList<String> secondSpinnerItems = new ArrayList<>();
        ArrayList<String> firstSpinnerItems = new ArrayList<>();
        //Adding items to both arrays
        firstSpinnerItems.add("kilobyte");
        firstSpinnerItems.add("megabyte");
        firstSpinnerItems.add("gigabyte");
        firstSpinnerItems.add("terabyte");
        //***********************************
        secondSpinnerItems.add("kilobyte");
        secondSpinnerItems.add("megabyte");
        secondSpinnerItems.add("gigabyte");
        secondSpinnerItems.add("terabyte");
        //Making array adapters for both arrays
        ArrayAdapter<String> secondSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, secondSpinnerItems);
        ArrayAdapter<String> firstSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, firstSpinnerItems);
        firstSpinner.setAdapter(firstSpinnerAdapter);
        SecondSpinner.setAdapter(secondSpinnerAdapter);
    }

    public void dgtToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void Calculate(View view) {
        //If by chance user enter a string we will catch it by using try catch
        try {
            //Defining all the important values
            Calculate cal = new Calculate();
            String first_val = firstSpinner.getSelectedItem().toString();
            String second_val = SecondSpinner.getSelectedItem().toString();
            Integer ans_into_int = Integer.valueOf(UserAnswer.getText().toString());
            if (first_val.equals("kilobyte")) {
                switch (second_val) {
                    case "kilobyte": {
                        answerTxt.setText(UserAnswer.getText().toString());
                        break;
                    }
                    case "megabyte": {
                        float ans = cal.calculate(ans_into_int, "divide", 1000);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "gigabyte": {
                        float ans = cal.calculate(ans_into_int, "divide", 1000000);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "terabyte": {
                        float ans = cal.calculate(ans_into_int, "divide", 1000000000);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                }
            }
            if (first_val.equals("megabyte")) {
                switch (second_val) {
                    case "kilobyte": {
                        //
                        float ans = cal.calculate(ans_into_int, "multiply", 1000);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "megabyte": {
                        answerTxt.setText(UserAnswer.getText().toString());
                        break;
                    }
                    case "gigabyte": {
                        float ans = cal.calculate(ans_into_int, "divide", 1000);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "terabyte": {
                        float ans = cal.calculate(ans_into_int, "divide", 1000000);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                }
            }
            if (first_val.equals("gigabyte")) {
                switch (second_val) {
                    case "kilobyte": {
                        //
                        float ans = cal.calculate(ans_into_int, "multiply", 1000000);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "megabyte": {
                        //
                        float ans = cal.calculate(ans_into_int, "multiply", 1000);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "gigabyte": {
                        answerTxt.setText(UserAnswer.getText().toString());
                        break;
                    }
                    case "terabyte": {
                        float ans = cal.calculate(ans_into_int, "divide", 1000);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                }
            }
            if (first_val.equals("terabyte")) {
                switch (second_val) {
                    case "kilobyte": {
                        //
                        float ans = cal.calculate(ans_into_int, "multiply", 1000000000);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "megabyte": {
                        //
                        float ans = cal.calculate(ans_into_int, "multiply", 1000000);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "gigabyte": {
                        float ans = cal.calculate(ans_into_int, "multiply", 1000);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "terabyte": {
                        answerTxt.setText(UserAnswer.getText().toString());
                        break;
                    }
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, "TextBox does not contain any numbers", Toast.LENGTH_SHORT).show();
        }
    }
}