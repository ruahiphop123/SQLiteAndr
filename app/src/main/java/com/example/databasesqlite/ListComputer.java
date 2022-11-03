package com.example.databasesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListComputer extends AppCompatActivity {
    SQLiteDatabase database;
    ArrayList<InforDataComputer> list;
    ListView listViewComputer;
    ComputerAdapter adapter;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_computer);
        getSupportActionBar().hide();
        list = new ArrayList<InforDataComputer>();

        back = findViewById(R.id.imgBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        updateUI();
    }

    public void updateUI() {
        database = openOrCreateDatabase("computer.db", MODE_PRIVATE, null);
        if (database != null) {
            Cursor cursor = database.query("tbComputer", null, null, null, null, null, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                InforDataComputer data = new InforDataComputer();
                data.setiDMay(cursor.getInt(0));
                data.setTenMay(cursor.getString(1));
                data.setHangSX(cursor.getString(2));
                list.add(data);
                cursor.moveToNext();
            }
            cursor.close();
            adapter = new ComputerAdapter(ListComputer.this, R.layout.line_data, list);
            listViewComputer = (ListView) findViewById(R.id.listViewComputer);
            listViewComputer.setAdapter(adapter);
        }
    }
}