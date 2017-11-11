package com.example.dell_pc.soilfertility;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class PredictingCrop extends AppCompatActivity {
    ArrayAdapter<CharSequence> adapter;
    LinearLayout ll8, ll9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predicting_crop);

        ll8 = (LinearLayout) findViewById(R.id.LL8);
        ll9 = (LinearLayout) findViewById(R.id.LL9);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.SoilType,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.SoilColor,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);

        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.Salt,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter);

        final Spinner spinner8 = (Spinner) findViewById(R.id.spinner8);
        adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.Irrcond,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner8.setAdapter(adapter);

        final Spinner spinner9 = (Spinner) findViewById(R.id.spinner9);
        adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.IrrMethod,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner9.setAdapter(adapter);

        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
        adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.Irr,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter);

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {

                    ll8.setVisibility(View.VISIBLE);
                    ll9.setVisibility(View.VISIBLE);

                }

                else
                {

                    ll8.setVisibility(View.INVISIBLE);
                    ll9.setVisibility(View.INVISIBLE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner spinner5 = (Spinner) findViewById(R.id.spinner5);
        adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.Fertility,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter);

        Spinner spinner6 = (Spinner) findViewById(R.id.spinner6);
        adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.wheather,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner6.setAdapter(adapter);

        Spinner spinner7 = (Spinner) findViewById(R.id.spinner7);
        adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.FinancialCondition,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter(adapter);
    }
}
