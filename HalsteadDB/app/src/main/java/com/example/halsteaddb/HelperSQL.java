package com.example.halsteaddb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HelperSQL extends SQLiteOpenHelper {
    public HelperSQL(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE resultsHalstead(" +
                "n1 INTEGER NOT NULL," +
                "N1_ INTEGER NOT NULL," +
                "n2 INTEGER NOT NULL," +
                "N2_ INTEGER NOT NULL," +
                "N REAL NOT NULL," +
                "n_ REAL NOT NULL," +
                "V REAL NOT NULL," +
                "D REAL NOT NULL," +
                "L REAL NOT NULL," +
                "E REAL NOT NULL," +
                "T REAL NOT NULL," +
                "B REAL NOT NULL" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
