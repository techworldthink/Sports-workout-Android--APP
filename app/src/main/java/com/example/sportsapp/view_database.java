package com.example.sportsapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class view_database extends AppCompatActivity implements View.OnClickListener {
    public TextView List;
    public Button Cricket,Football,Baseball,Gym;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_database);
        List = (TextView) findViewById(R.id.list);
        List.setOnClickListener(this);
        Cricket = (Button) findViewById(R.id.Cricket);
        Cricket.setOnClickListener(this);
        Football = (Button) findViewById(R.id.football);
        Football.setOnClickListener(this);
        Baseball = (Button) findViewById(R.id.baseball);
        Baseball.setOnClickListener(this);
        Gym = (Button) findViewById(R.id.gym);
        Gym.setOnClickListener(this);
        //List.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.Cricket:
                print("cricket");
                break;
            case R.id.football:
                print("football");
                break;
            case R.id.baseball:
                print("baseball");
                break;
            case R.id.gym:
                print("gym");
                break;
            default:
               // print();
                break;
        }
    }

    void print(String get_one_thing)
    {
        if(get_one_thing.equals("cricket"))
        {
            String tableName = "Cricket";
            String db_name = "sports_register";

            String tableString = String.format("Table %s:\n", tableName);
            SQLiteDatabase records = openOrCreateDatabase(db_name, MODE_PRIVATE, null);

            records.execSQL("CREATE TABLE IF NOT EXISTS Cricket(Date VARCHAR);");
            Cursor test = records.rawQuery("Select count(*) from Cricket",null);
            test.moveToLast();
            int count=test.getInt(0);

            if(count == 0) {
                Toast.makeText(view_database.this,"There is No data",Toast.LENGTH_SHORT).show();
            }


                Cursor allRows  = records.rawQuery("SELECT * FROM " + tableName, null);
                if (allRows.moveToFirst() ){
                    String[] columnNames = allRows.getColumnNames();
                    do {
                        for (String name: columnNames) {
                            tableString += String.format("%s: %s\n", name,
                                    allRows.getString(allRows.getColumnIndex(name)));
                        }
                        tableString += "\n";

                    } while (allRows.moveToNext());
                }
                //Toast.makeText(view_database.this,tableString,Toast.LENGTH_SHORT).show();
                List.setText(tableString);




        }


        if(get_one_thing.equals("football"))
        {
            String tableName = "Football";
            String db_name = "sports_register";

            String tableString = String.format("Table %s:\n", tableName);
            SQLiteDatabase records = openOrCreateDatabase(db_name, MODE_PRIVATE, null);

            records.execSQL("CREATE TABLE IF NOT EXISTS Football(Date VARCHAR);");
            Cursor test = records.rawQuery("Select count(*) from Football",null);
            test.moveToLast();
            int count=test.getInt(0);

            if(count == 0) {
                Toast.makeText(view_database.this,"There is No data",Toast.LENGTH_SHORT).show();
            }


                Cursor allRows  = records.rawQuery("SELECT * FROM " + tableName, null);
                if (allRows.moveToFirst() ){
                    String[] columnNames = allRows.getColumnNames();
                    do {
                        for (String name: columnNames) {
                            tableString += String.format("%s: %s\n", name,
                                    allRows.getString(allRows.getColumnIndex(name)));
                        }
                        tableString += "\n";

                    } while (allRows.moveToNext());
                }
                //Toast.makeText(view_database.this,tableString,Toast.LENGTH_SHORT).show();
                List.setText(tableString);





        }

        if(get_one_thing.equals("baseball"))
        {
            String tableName = "Baseball";
            String db_name = "sports_register";

            String tableString = String.format("Table %s:\n", tableName);
            SQLiteDatabase records = openOrCreateDatabase(db_name, MODE_PRIVATE, null);

            records.execSQL("CREATE TABLE IF NOT EXISTS Baseball(Date VARCHAR);");
            Cursor test = records.rawQuery("Select count(*) from Baseball",null);
            test.moveToLast();
            int count=test.getInt(0);

            if(count == 0) {
                Toast.makeText(view_database.this,"There is No data",Toast.LENGTH_SHORT).show();
            }

                Cursor allRows  = records.rawQuery("SELECT * FROM " + tableName, null);
                if (allRows.moveToFirst() ){
                    String[] columnNames = allRows.getColumnNames();
                    do {
                        for (String name: columnNames) {
                            tableString += String.format("%s: %s\n", name,
                                    allRows.getString(allRows.getColumnIndex(name)));
                        }
                        tableString += "\n";

                    } while (allRows.moveToNext());
                }
                //Toast.makeText(view_database.this,tableString,Toast.LENGTH_SHORT).show();
                List.setText(tableString);





        }

        if(get_one_thing.equals("gym"))
        {
            String tableName = "Gym";
            String db_name = "sports_register";

            String tableString = String.format("Table %s:\n", tableName);
            SQLiteDatabase records = openOrCreateDatabase(db_name, MODE_PRIVATE, null);

            records.execSQL("CREATE TABLE IF NOT EXISTS Gym(Date VARCHAR);");
            Cursor test = records.rawQuery("Select count(*) from Gym",null);
            test.moveToLast();
            int count=test.getInt(0);

            if(count == 0) {
                Toast.makeText(view_database.this, "There is No data", Toast.LENGTH_SHORT).show();
            }

                    Cursor allRows  = records.rawQuery("SELECT * FROM " + tableName, null);
                    if (allRows.moveToFirst() ){
                        String[] columnNames = allRows.getColumnNames();
                        do {
                            for (String name: columnNames) {
                                tableString += String.format("%s: %s\n", name,
                                        allRows.getString(allRows.getColumnIndex(name)));
                            }
                            tableString += "\n";

                        } while (allRows.moveToNext());
                    }
                    //Toast.makeText(view_database.this,tableString,Toast.LENGTH_SHORT).show();
                    List.setText(tableString);





        }





    }
}
