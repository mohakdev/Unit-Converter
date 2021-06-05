package com.antares_studio.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openLengthPage(View view) {
        Intent intent = new Intent(this, Length.class);
        startActivity(intent);
    }
    public void openWeightPage(View view) {
        Intent intent = new Intent(this, WeightActivity.class);
        startActivity(intent);
    }

    public void openTimePage(View view) {
    }

    public void openDigitalPage(View view) {
    }
}