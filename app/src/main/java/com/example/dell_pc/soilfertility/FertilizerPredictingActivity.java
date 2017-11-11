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
import android.widget.EditText;

public class FertilizerPredictingActivity extends AppCompatActivity {

    SQLiteDatabase cropsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizer_predicting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        EditText n_et = (EditText) findViewById(R.id.n_et);
        EditText p_et = (EditText) findViewById(R.id.p_et);
        EditText k_et = (EditText) findViewById(R.id.k_et);

        try{
            cropsDB = this.openOrCreateDatabase("Crops", MODE_PRIVATE, null);
            cropsDB.execSQL("CREATE TABLE IF NOT EXISTS cropMSP (cropName VARCHAR, msp INTEGER(4))");

            getData();

        }catch (Exception e){
            e.printStackTrace();
        }
        }

        public void getData(){
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
    }

