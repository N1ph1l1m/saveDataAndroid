package com.example.databaseroom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.databaseroom.SQLite.DataBaseHelper;
import com.example.databaseroom.SQLite.SimpleExample;
import com.example.databaseroom.SQLite.UserActivity;

public class Main_SQLite extends AppCompatActivity {

    ListView userList;
    TextView header;
    DataBaseHelper dataBaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sqlite);
        userList = findViewById(R.id.list);

        dataBaseHelper = new DataBaseHelper(getApplicationContext());
    }

    @Override
    protected void onResume() {
        super.onResume();
        db = dataBaseHelper.getReadableDatabase();


        userCursor = db.rawQuery(" SELECT * FROM  " + DataBaseHelper.TABLE , null);
        String[] headers = new String[] {DataBaseHelper.COLUMN_NAME, DataBaseHelper.COLUMN_YEAR};

        userAdapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item,
                userCursor, headers, new int[]{android.R.id.text1, android.R.id.text2},0);
        userList.setAdapter(userAdapter);




    }
    public void addData(View view) {
       Intent intent = new Intent(this , UserActivity.class);
       startActivity(intent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
        userCursor.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.dataBase1){
            startActivity(new Intent(this, SimpleExample.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}