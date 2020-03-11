package com.example.hwandroid92;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    private String selectedMargin;
    private Integer chooseMargin;
    private Button btnOK2;
    private Spinner spinnerMargin;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);

        btnOK2 = findViewById(R.id.btnOK);
        spinnerMargin = findViewById(R.id.spinnerThemes);
        ArrayAdapter arrayAdapter2 = ArrayAdapter.createFromResource(this, R.array.spinnerThemes, android.R.layout.simple_spinner_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerMargin.setAdapter(arrayAdapter2);

        spinnerMargin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView adapterView, View view, int position, long id) {
                String[] spinnerMargins = getResources().getStringArray(R.array.spinnerThemes);
                selectedMargin = spinnerMargins[position];
            }

            @Override
            public void onNothingSelected(AdapterView adapterView) {
            }

        });

        btnOK2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedMargin.equals("мелкие")) {
                    chooseMargin = 0;
                } else if (selectedMargin.equals("средние")) {
                    chooseMargin = 1;
                } else if (selectedMargin.equals("большие")) {
                    chooseMargin = 2;
                }

                if (chooseMargin == 0) {
                    Utils.changeToTheme(MainActivity.this, Utils.THEME_MARGIN_SMALL);
                } else if (chooseMargin == 1) {
                    Utils.changeToTheme(MainActivity.this, Utils.THEME_MARGIN_MIDDLE);
                } else if (chooseMargin == 2) {
                    Utils.changeToTheme(MainActivity.this, Utils.THEME_MARGIN_BIG);
                }


            }
        });
    }
}
