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

public class TimeActivity extends AppCompatActivity {
    EditText UserAnswer;
    Spinner firstSpinner;
    Spinner SecondSpinner;
    TextView answerTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        firstSpinner = findViewById(R.id.Time_firstSpinner);
        SecondSpinner = findViewById(R.id.Time_SecondSpinner);
        UserAnswer = findViewById(R.id.Time_UserAnswer);
        answerTxt = findViewById(R.id.Time_txt);
        //initializing both arrays
        ArrayList<String> secondSpinnerItems = new ArrayList<>();
        ArrayList<String> firstSpinnerItems = new ArrayList<>();
        //Adding items to both arrays
        firstSpinnerItems.add("second");
        firstSpinnerItems.add("minute");
        firstSpinnerItems.add("hour");
        firstSpinnerItems.add("day");
        firstSpinnerItems.add("year");
        //********************************
        secondSpinnerItems.add("second");
        secondSpinnerItems.add("minute");
        secondSpinnerItems.add("hour");
        secondSpinnerItems.add("day");
        secondSpinnerItems.add("year");
        //Making array adapters for both arrays
        ArrayAdapter<String> secondSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, secondSpinnerItems);
        ArrayAdapter<String> firstSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, firstSpinnerItems);
        firstSpinner.setAdapter(firstSpinnerAdapter);
        SecondSpinner.setAdapter(secondSpinnerAdapter);
    }

    public void timeToMain(View view) {
        Intent intent = new Intent(this, TimeActivity.class);
        startActivity(intent);
    }

    public void calculate(View view) {
        //If by chance user enter a string we will catch it by using try catch
        try {
            //Defining all the important values
            Calculate cal = new Calculate();
            String first_val = firstSpinner.getSelectedItem().toString();
            String second_val = SecondSpinner.getSelectedItem().toString();
            Integer ans_into_int = Integer.valueOf(UserAnswer.getText().toString());
            if (first_val.equals("second")) {
                switch (second_val) {
                    case "second": {
                        answerTxt.setText(UserAnswer.getText().toString());
                        break;
                    }
                    case "minute": {
                        float ans = cal.calculate(ans_into_int, "divide", 60);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "hour": {
                        float ans = cal.calculate(ans_into_int, "divide", 3600);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "day": {
                        float ans = cal.calculate(ans_into_int, "divide", 86400);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "year": {
                        float ans = cal.calculate(ans_into_int, "divide", 31556952);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                }
            }
            if (first_val.equals("minute")) {
                switch (second_val) {
                    case "second": {
                        float ans = cal.calculate(ans_into_int, "multiply", 60);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "minute": {
                        answerTxt.setText(UserAnswer.getText().toString());
                        break;
                    }
                    case "hour": {
                        float ans = cal.calculate(ans_into_int, "divide", 60);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "day": {
                        float ans = cal.calculate(ans_into_int, "divide", 1440);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "year": {
                        float ans = cal.calculate(ans_into_int, "divide",  525600);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                }
            }
            if (first_val.equals("hour")) {
                switch (second_val) {
                    case "second": {
                        float ans = cal.calculate(ans_into_int, "multiply", 3600);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "minute": {
                        float ans = cal.calculate(ans_into_int, "multiply", 60);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "hour": {
                        answerTxt.setText(UserAnswer.getText().toString());
                        break;
                    }
                    case "day": {
                        float ans = cal.calculate(ans_into_int, "divide", 24);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "year": {
                        float ans = cal.calculate(ans_into_int, "divide", 8760);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                }
            }
            if (first_val.equals("day")) {
                switch (second_val) {
                    case "second": {
                        float ans = cal.calculate(ans_into_int, "multiply", 86400);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "minute": {
                        float ans = cal.calculate(ans_into_int, "multiply", 1440);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "hour": {
                        float ans = cal.calculate(ans_into_int, "multiply", 24);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "day": {
                        answerTxt.setText(UserAnswer.getText().toString());
                        break;
                    }
                    case "year": {
                        float ans = cal.calculate(ans_into_int, "divide", 365);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                }
            }
            if (first_val.equals("year")) {
                switch (second_val) {
                    case "second": {
                        float ans = cal.calculate(ans_into_int, "multiply", 31556952);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "minute": {
                        float ans = cal.calculate(ans_into_int, "multiply", 525600);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "hour": {
                        float ans = cal.calculate(ans_into_int, "multiply", 8760);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "day": {
                        float ans = cal.calculate(ans_into_int, "multiply", 365);
                        String ans_in_string = String.valueOf(ans);
                        answerTxt.setText(ans_in_string);
                        break;
                    }
                    case "year": {
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