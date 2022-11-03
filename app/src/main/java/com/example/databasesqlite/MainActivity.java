package com.example.databasesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase database;
    String msg = "";
    Button btToList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        doDeleteDatabase();
        getDatabase();

        btToList = findViewById(R.id.buttonToList);
        btToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListComputer.class);
                startActivity(intent);
            }
        });
    }

    public boolean isTableExists(SQLiteDatabase database, String tableName) {
        Cursor cursor = database.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '"+tableName+"'", null);
        if(cursor!=null) {
            if(cursor.getCount()>0) {
                cursor.close();
                return true;
            }
            cursor.close();
        }
        return false;
    }

//    public void doCreateDatabase(){
//        database = openOrCreateDatabase("computer.db", MODE_PRIVATE,
//                null);
//    }

    public void doDeleteDatabase(){
        if(deleteDatabase("computer.db")==true)
        {
            msg = "Delete database 'computer.db' is successful";
        }
        else
        {
            msg = "Delete database 'computer.db' is failed";
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void doCreateComputerTable(){
        String sql = "CREATE TABLE tbComputer (";
        sql += "iDMay Integer primary key,";
        sql += "tenMay TEXT,";
        sql += "tenHang TEXT)";
        database.execSQL(sql);
    }
    public void doCreateCategoryTable(){
        String sql = "CREATE TABLE tbCategory(";
        sql += "idCat Integer primary key,";
        sql += "soLuong Integer,";
        sql += "idMayNo Integer NOT NULL CONSTRAINT idMay " + " REFERENCES tbComputer(idMay) ON DELETE CASCADE)";
        database.execSQL(sql);
    }

    public void doInsertRecord(){
        ContentValues values = new ContentValues();
        values.put("idMay", 1);
        values.put("tenMay", "Laptop Gaming");
        values.put("tenHang","Intel");
        if(database.insert("tbComputer",null,values) == -1){
            msg = "Failed to insert";
        }

        values.put("idMay", 2);
        values.put("tenMay", "Laptop Lenovo");
        values.put("tenHang","AMD");
        if(database.insert("tbComputer",null,values) == -1){
            msg = "Failed to insert";
        }

        values.put("idMay", 3);
        values.put("tenMay", "Laptop Gaming 21 inch");
        values.put("tenHang","Intel");
        if(database.insert("tbComputer",null,values) == -1){
            msg = "Failed to insert";
        }

        values.put("idMay", 4);
        values.put("tenMay", "Laptop Asus");
        values.put("tenHang","Intel");
        if(database.insert("tbComputer",null,values) == -1){
            msg = "Failed to insert";
        }

        values.put("idMay", 5);
        values.put("tenMay", "Laptop HP 2020");
        values.put("tenHang","Intel");
        if(database.insert("tbComputer",null,values) == -1){
            msg = "Failed to insert";
        }

        values.put("idMay", 6);
        values.put("tenMay", "Laptop HP Lenovo");
        values.put("tenHang","Intel");
        if(database.insert("tbComputer",null,values) == -1){
            msg = "Failed to insert";
        }

        values.put("idCat", 1);
        values.put("soLuong", 5);
        values.put("idMayNo",2);
        if(database.insert("tbCategory",null,values) == -1){
            msg = "Failed to insert";
         }
    }

    public SQLiteDatabase getDatabase()
    {
        database = openOrCreateDatabase("computer.db", MODE_PRIVATE, null);
        try
        {
            if(database!=null)
            {
                if(isTableExists(database,"tbComputer"))
                    return database;
                doCreateComputerTable();
                doCreateCategoryTable();
                doInsertRecord();
                Toast.makeText(this, "Tạo", Toast.LENGTH_SHORT).show();
            }
        }
        catch(Exception e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
        return database;
    }

    //Update
//    public void updateTenMay(Integer idMay, String newtenMay)
//    {
//        ContentValues values = new ContentValues();
//        values.put("tenMay", newtenMay);
//        int ret =  database.update("tbComputer", values, "malop = ?", new String[] {malop})
//    }
    }