package com.marca.folcloricas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Usuarios extends SQLiteOpenHelper {

    String creacion = "CREATE TABLE Usuarios(email TEXT primary key, password TEXT)";

    public Usuarios(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase bbdd) {
        bbdd.execSQL(creacion);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bbdd, int oldVersion, int newVersion) {
        bbdd.execSQL("DROP TABLE IF EXISTS Usuarios");
        bbdd.execSQL(creacion);
    }

    // Insercion en BBDD
    public boolean insert(String email, String password){
        SQLiteDatabase bbdd = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("email", email);
        contentValues.put("password", password);

        long ins = bbdd.insert("Usuarios", null, contentValues);
        if(ins == -1) return false;
        else return true;
    }

    // Comprobacion usuario
    public Boolean checkEmail(String email){
        SQLiteDatabase bbdd = this.getReadableDatabase();
        Cursor cursor = bbdd.rawQuery("Select * from Usuarios where email=?", new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }

    // Comprobacion usuario y password
    public boolean checkLogin(String email, String password){
        SQLiteDatabase bbdd = this.getReadableDatabase();
        Cursor cursor = bbdd.rawQuery("select * from Usuarios where email=? and password=?", new String[]{email, password});

        if(cursor.getCount()>0) return true;
        else return false;

    }
}
