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

    //To pass float as parameter in calculate class method add an f in last
    public void openLengthPage(View view) {
        Intent intent = new Intent(this, Length.class);
        startActivity(intent);
    }

    public void openWeightPage(View view) {
        Intent intent = new Intent(this, WeightActivity.class);
        startActivity(intent);
    }

    public void openTimePage(View view) {
        Intent intent = new Intent(this, TimeActivity.class);
        startActivity(intent);
    }

    public void openDigitalPage(View view) {
        Intent intent = new Intent(this, DigitalStorageActivity.class);
        startActivity(intent);
    }
}