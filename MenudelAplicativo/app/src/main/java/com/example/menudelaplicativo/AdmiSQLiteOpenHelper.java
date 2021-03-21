package com.example.menudelaplicativo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdmiSQLiteOpenHelper  extends SQLiteOpenHelper {

    public AdmiSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDedatos) {
        BaseDedatos.execSQL("create table datos(codigo int primary key,n int, n1 int, n2 int, xn int, xn1 int,xn2 int,v real,d real,l real,e real,t real,b real)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
