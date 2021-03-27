package com.example.halsteaddb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String nameDB="metricas";
    String nameTABLE="resultsHalstead";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void newRecord(View view) {
        HelperSQL admin = new HelperSQL(this, this.nameDB, null, 1);//Helper, data base: nameDB
        SQLiteDatabase db = admin.getWritableDatabase();//data base

        Halstead h=new Halstead(9,12,6,14);//Calculate new Halstead

        ContentValues record = new ContentValues();
        record.put("n1",h.n1);
        record.put("N1_",h.N1);
        record.put("n2",h.n2);
        record.put("N2_",h.N2);
        record.put("N",h.N);
        record.put("n_",h.n);
        record.put("V",h.V);
        record.put("D",h.D);
        record.put("L",h.L);
        record.put("E",h.E);
        record.put("T",h.T);
        record.put("B",h.B);

        db.insert(this.nameTABLE,null,record);//insert into nameDB.nameTABLE
        db.close();//close data base

        Toast.makeText(this, "newRecord() successfully. 👌", Toast.LENGTH_SHORT).show();

    }
    public void getRecords(View view){
        HelperSQL admin = new HelperSQL(this, this.nameDB, null, 1);//Helper, data base: nameDB
        SQLiteDatabase db = admin.getWritableDatabase();//data base

        Cursor resultQuery=db.rawQuery("SELECT * FROM "+this.nameTABLE,null);
        int i=1;
        while(resultQuery.moveToNext()){
            System.out.println("row "+(i++)+
                    " n1:"+resultQuery.getInt(resultQuery.getColumnIndex("n1"))+
                    " N1:"+resultQuery.getInt(resultQuery.getColumnIndex("N1_"))+
                    " n2:"+resultQuery.getInt(resultQuery.getColumnIndex("n2"))+
                    " N2:"+resultQuery.getInt(resultQuery.getColumnIndex("N2_"))+
                    " N:"+resultQuery.getDouble(resultQuery.getColumnIndex("N"))+
                    " n:"+resultQuery.getDouble(resultQuery.getColumnIndex("n_"))+
                    " V:"+resultQuery.getDouble(resultQuery.getColumnIndex("V"))+
                    " D:"+resultQuery.getDouble(resultQuery.getColumnIndex("D"))+
                    " L:"+resultQuery.getDouble(resultQuery.getColumnIndex("L"))+
                    " E:"+resultQuery.getDouble(resultQuery.getColumnIndex("E"))+
                    " T:"+resultQuery.getDouble(resultQuery.getColumnIndex("T"))+
                    " B:"+resultQuery.getDouble(resultQuery.getColumnIndex("B"))
            );
        }


        Toast.makeText(this, "getRecords() successfully. ✔", Toast.LENGTH_SHORT).show();

    }
}