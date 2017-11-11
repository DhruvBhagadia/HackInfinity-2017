package com.example.dell_pc.soilfertility;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class PredictingCrop extends AppCompatActivity {
    ArrayAdapter<CharSequence> adapter;
    int int1, int2, int3, int4, int5, int6, int7, int8, int9;
    LinearLayout ll8, ll9;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predicting_crop);

        ll8 = (LinearLayout) findViewById(R.id.LL8);
        ll9 = (LinearLayout) findViewById(R.id.LL9);

        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.SoilType, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.SoilColor, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int2 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.Salt, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int3 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Spinner spinner8 = (Spinner) findViewById(R.id.spinner8);
        adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.Irrcond, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner8.setAdapter(adapter);
        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int8 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Spinner spinner9 = (Spinner) findViewById(R.id.spinner9);
        adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.IrrMethod, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner9.setAdapter(adapter);
        spinner9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int9 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
        adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.Irr, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter);

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int4 = position;

                if (position == 1) {

                    ll8.setVisibility(View.VISIBLE);
                    ll9.setVisibility(View.VISIBLE);

                } else {

                    ll8.setVisibility(View.INVISIBLE);
                    ll9.setVisibility(View.INVISIBLE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner spinner5 = (Spinner) findViewById(R.id.spinner5);
        adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.Fertility, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter);
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int5 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner spinner6 = (Spinner) findViewById(R.id.spinner6);
        adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.wheather, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner6.setAdapter(adapter);
        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int6 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner spinner7 = (Spinner) findViewById(R.id.spinner7);
        adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.FinancialCondition, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter(adapter);
        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int7 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        button = (Button) findViewById(R.id.signUpButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((int4 != 2 ) && (int7 == 0 || int8 == 0)){

                    if ((int1 == 0) || (int2 == 0) || (int3 == 0) || (int4 == 0) || (int5 == 0) || (int6 == 0) || (int7 == 0) || (int8 == 0) || (int9 == 0)) {

                        Context context = getApplicationContext();
                        CharSequence text = "Invalid sign up!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
                else {

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


    }
