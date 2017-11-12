package com.example.dell_pc.soilfertility;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.Math.round;

public class FertilizerPredictingActivity extends AppCompatActivity {

    SQLiteDatabase cropsDB, fertilizerDB, cropsNPK;
    ArrayList<String> fertName = new ArrayList<>(), cropName = new ArrayList<>();
    ArrayList<Integer> nList = new ArrayList<>(), n1List = new ArrayList<>();
    ArrayList<Integer> pList = new ArrayList<>(), p1List = new ArrayList<>();
    ArrayList<Integer> kList = new ArrayList<>(), k1List = new ArrayList<>();
    int nValue;
    int pValue;
    int kValue;
    EditText n_et;
    EditText p_et;
    EditText k_et;
    int cropPos;
    Button button;
    TextView n_tv, p_tv, k_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizer_predicting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try{
            cropsDB = this.openOrCreateDatabase("Crops", MODE_PRIVATE, null);
            cropsDB.execSQL("CREATE TABLE IF NOT EXISTS cropMSP (cropName VARCHAR, msp INTEGER(4))");
            fertilizerDB = this.openOrCreateDatabase("Fertilizers", MODE_PRIVATE, null);
            fertilizerDB.execSQL("CREATE TABLE IF NOT EXISTS fertilizerContent (name VARCHAR, n INTEGER(2), p INTEGER(2), k INTEGER(2))");
            /*fertilizerDB.execSQL("INSERT INTO fertilizerContent VALUES ('DAP', 18, 46, 0)");
            fertilizerDB.execSQL("INSERT INTO fertilizerContent VALUES ('Urea', 46, 0, 0)");
            fertilizerDB.execSQL("INSERT INTO fertilizerContent VALUES ('SSP', 0, 20, 0)");
            fertilizerDB.execSQL("INSERT INTO fertilizerContent VALUES ('GradeA', 19, 19, 19)");
            fertilizerDB.execSQL("INSERT INTO fertilizerContent VALUES ('GradeB', 20, 20, 0)");*/

            cropsNPK = this.openOrCreateDatabase("CropsNPK", MODE_PRIVATE, null);
            cropsNPK.execSQL("CREATE TABLE IF NOT EXISTS cropsNPKDB (name VARCHAR, n INTEGER(3), p INTEGER(3), k INTEGER(3))");
            /*cropsNPK.execSQL("INSERT INTO cropsNPKDB (name, n, p, k) VALUES ('Jowar', 75, 40, 0)");
            cropsNPK.execSQL("INSERT INTO cropsNPKDB (name, n, p, k) VALUES ('Paddy', 100, 30, 0)");
            cropsNPK.execSQL("INSERT INTO cropsNPKDB (name, n, p, k) VALUES ('Sesame', 20, 25, 0)");
            cropsNPK.execSQL("INSERT INTO cropsNPKDB (name, n, p, k) VALUES ('Wheat', 120, 60, 0)");
            cropsNPK.execSQL("INSERT INTO cropsNPKDB (name, n, p, k) VALUES ('Sugarcane', 110, 50, 35)");
            cropsNPK.execSQL("INSERT INTO cropsNPKDB (name, n, p, k) VALUES ('Cotton', 360, 140, 60)");
            cropsNPK.execSQL("INSERT INTO cropsNPKDB (name, n, p, k) VALUES ('Sugarcane', 150, 80, 80)");*/
            n_et = (EditText) findViewById(R.id.n_et);
            p_et = (EditText) findViewById(R.id.p_et);
            k_et = (EditText) findViewById(R.id.k_et);
            n_tv = (TextView) findViewById(R.id.nTV);
            p_tv = (TextView) findViewById(R.id.pTV);
            k_tv = (TextView) findViewById(R.id.kTV);
            Spinner spinner = (Spinner) findViewById(R.id.spinner);
            ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.crops,android.R.layout.simple_spinner_item);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(arrayAdapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    cropPos = position;
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            button = (Button) findViewById(R.id.button2);

            getFertilizerData();
            getCropData();
            getCropNPKData();

        }catch (Exception e){
            e.printStackTrace();
        }
        }

        public void getCropData(){
            Cursor c = cropsDB.rawQuery("SELECT * FROM cropMSP", null);
            int nameIndex = c.getColumnIndex("cropName");
            int mspIndex = c.getColumnIndex("msp");
            c.moveToFirst();
            while(!c.isAfterLast()){
                Log.i("Crop Name: ", c.getString(nameIndex));
                Log.i("MSP: ", Integer.toString(c.getInt(mspIndex)));
                c.moveToNext();
            }
        }

    public void getFertilizerData(){
        Cursor c = fertilizerDB.rawQuery("SELECT * FROM fertilizerContent", null);
        int nameIndex = c.getColumnIndex("name");
        int nIndex = c.getColumnIndex("n");
        int pIndex = c.getColumnIndex("p");
        int kIndex = c.getColumnIndex("k");
        fertName.clear();
        nList.clear();
        pList.clear();
        kList.clear();
        c.moveToFirst();
        while(!c.isAfterLast()){
            fertName.add(c.getString(nameIndex));
            nList.add(c.getInt(nIndex));
            pList.add(c.getInt(pIndex));
            kList.add(c.getInt(kIndex));
            c.moveToNext();
        }

    }

    public void getCropNPKData(){
        Cursor c = cropsNPK.rawQuery("SELECT * FROM cropsNPKDB", null);
        int nameIndex = c.getColumnIndex("name");
        int nIndex = c.getColumnIndex("n");
        int pIndex = c.getColumnIndex("p");
        int kIndex = c.getColumnIndex("k");
        cropName.clear();
        n1List.clear();
        p1List.clear();
        k1List.clear();
        c.moveToFirst();
        while(!c.isAfterLast()){
            cropName.add(c.getString(nameIndex));
            n1List.add(c.getInt(nIndex));
            p1List.add(c.getInt(pIndex));
            k1List.add(c.getInt(kIndex));
            c.moveToNext();
        }
    }

    public void onClick(View v) {
        nValue = Integer.parseInt(n_et.getText().toString());
        pValue = Integer.parseInt(p_et.getText().toString());
        kValue = Integer.parseInt(k_et.getText().toString());
        String nRange;
        String pRange;
        String kRange;
        double nDiff, pDiff, kDiff;
        int nPos=n1List.get(cropPos), pPos=p1List.get(cropPos), kPos=k1List.get(cropPos);

        /*if(nPos > 0 && pPos > 0){
            if(kPos > 0){
                nDiff = 0.25*nPos/nList.get(3);
                pDiff = pPos - pList.get(3);
                kDiff = kPos - kList.get(3);
            }
            else {
                nDiff = nPos - nList.get(0);
                pDiff = pPos - pList.get(0);
                kDiff = kPos - kList.get(0);
            }
        }
        else{
            if(nPos == 0){
                nDiff = nPos - nList.get(2);
                pDiff = pPos - pList.get(2);
                kDiff = kPos - kList.get(2);
            }
            else {
                nDiff = nPos - nList.get(1);
                pDiff = pPos - pList.get(1);
                kDiff = kPos - kList.get(1);
            }
        }*/

        if(nValue >= 75){
            if(nValue >= 150){
                if(nPos > 0 && pPos > 0){
                    if(kPos > 0){
                        nDiff = 0.25*nPos/nList.get(3);
                    }
                    else {
                        nDiff = 0.25*nPos/nList.get(0);
                    }
                }
                else{
                    if(nPos == 0){
                        nDiff = 0.25*nPos/nList.get(2);
                    }
                    else {
                        nDiff = 0.25*nPos/nList.get(1);
                    }
                }
            }
            else{
                if(nPos > 0 && pPos > 0){
                    if(kPos > 0){
                        nDiff = 0.5*nPos/nList.get(3);
                    }
                    else {
                        nDiff = 0.5*nPos/nList.get(0);
                    }
                }
                else{
                    if(nPos == 0){
                        nDiff = 0.5*nPos/nList.get(2);
                    }
                    else {
                        nDiff = 0.5*nPos/nList.get(1);
                    }
                }
            }
        }
        else{
            if(nPos > 0 && pPos > 0){
                if(kPos > 0){
                    nDiff = 1.0*nPos/nList.get(3);
                }
                else {
                    nDiff = 1.0*nPos/nList.get(0);
                }
            }
            else{
                if(nPos == 0){
                    nDiff = 1.0*nPos/nList.get(2);
                }
                else {
                    nDiff = 1.0*nPos/nList.get(1);
                }
            }
        }
        if(pValue >= 28){
            if(nValue >= 56){
                if(nPos > 0 && pPos > 0){
                    if(kPos > 0){
                        pDiff = 0.25*pPos/pList.get(3);
                    }
                    else {
                        pDiff = 0.25*pPos/pList.get(0);
                    }
                }
                else{
                    if(nPos == 0){
                        pDiff = 0.25*pPos/pList.get(2);
                    }
                    else {
                        pDiff = 0.25*pPos/pList.get(1);
                    }
                }
            }
            else{
                if(nPos > 0 && pPos > 0){
                    if(kPos > 0){
                        pDiff = 0.5*pPos/pList.get(3);
                    }
                    else {
                        pDiff = 0.5*pPos/pList.get(0);
                    }
                }
                else{
                    if(nPos == 0){
                        pDiff = 0.5*pPos/pList.get(2);
                    }
                    else {
                        pDiff = 0.5*pPos/pList.get(1);
                    }
                }
            }
        }
        else{
            if(nPos > 0 && pPos > 0){
                if(kPos > 0){
                    pDiff = 1.0*pPos/pList.get(3);
                }
                else {
                    pDiff = 1.0*pPos/pList.get(0);
                }
            }
            else{
                if(nPos == 0){
                    pDiff = 1.0*pPos/pList.get(2);
                }
                else {
                    pDiff = 1.0*pPos/pList.get(1);
                }
            }
        }
        if(kValue >= 15){
            if(kValue >= 45){
                if(nPos > 0 && pPos > 0){
                    if(kPos > 0){
                        kDiff = 0.25*kPos/kList.get(3);
                    }
                    else {
                        kDiff = 0.25*kPos/kList.get(0);
                    }
                }
                else{
                    if(nPos == 0){
                        kDiff = 0.25*kPos/kList.get(2);
                    }
                    else {
                        kDiff = 0.25*kPos/kList.get(1);
                    }
                }
            }
            else{
                if(nPos > 0 && pPos > 0){
                    if(kPos > 0){
                        kDiff = 0.5*kPos/kList.get(3);
                    }
                    else {
                        kDiff = 0.5*kPos/kList.get(0);
                    }
                }
                else{
                    if(nPos == 0){
                        kDiff = 0.5*kPos/kList.get(2);
                    }
                    else {
                        kDiff = 0.5*kPos/kList.get(1);
                    }
                }
            }
        }
        else{
            if(nPos > 0 && pPos > 0){
                if(kPos > 0){
                    kDiff = 1.0*kPos/kList.get(3);
                }
                else {
                    kDiff = 1.0*kPos/kList.get(0);
                }
            }
            else{
                if(nPos == 0){
                    kDiff = 1.0*kPos/kList.get(2);
                }
                else {
                    kDiff = 1.0*kPos/kList.get(1);
                }
            }
        }

        Log.i("N amt", Double.toString(nDiff));
        Log.i("P amt", Double.toString(pDiff));
        Log.i("K amt", Double.toString(kDiff));

        Log.i("Crop Name", cropName.get(cropPos));
        Log.i("N Value", n1List.get(cropPos).toString());
        Log.i("P Value", p1List.get(cropPos).toString());
        Log.i("K Value", k1List.get(cropPos).toString());

        n_tv.setText(String.format("N: %.2f", nDiff));
        p_tv.setText(String.format("P: %.2f", pDiff));
        k_tv.setText(String.format("K: %.2f", kDiff));

        n_tv.setVisibility(View.VISIBLE);
        p_tv.setVisibility(View.VISIBLE);
        k_tv.setVisibility(View.VISIBLE);
    }

}

