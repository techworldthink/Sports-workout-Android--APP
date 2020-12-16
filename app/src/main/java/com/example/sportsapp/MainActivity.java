package com.example.sportsapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button cricket, football, baseball, gym;
    public TextView textView3,textView4,textView5,textView6;

    public Button print,view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cricket = (Button) findViewById(R.id.cricket);
        football = (Button) findViewById(R.id.football);
        baseball = (Button) findViewById(R.id.baseball);
        gym = (Button) findViewById(R.id.gym);
        cricket.setOnClickListener(this);
        football.setOnClickListener(this);
        baseball.setOnClickListener(this);
        gym.setOnClickListener(this);

        textView3 =(TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(this);
        textView4 =(TextView) findViewById(R.id.textView4);
        textView4.setOnClickListener(this);
        textView5 =(TextView) findViewById(R.id.textView5);
        textView5.setOnClickListener(this);
        textView6 =(TextView) findViewById(R.id.textView6);
        textView6.setOnClickListener(this);

        view = findViewById(R.id.check);
        print = findViewById(R.id.print);
        view.setOnClickListener(this);
        print.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.cricket:
                Add_to_db("cricket");
                break;
            case R.id.football:
                Add_to_db("football");
                break;
            case R.id.baseball:
                Add_to_db("baseball");
                break;
            case R.id.gym:
                Add_to_db("gym");
                break;
            case R.id.print:
                Intent i= new Intent(MainActivity.this,view_database.class);
                startActivity(i);
                break;
            case R.id.check:
                 check();
                 break;
            default:
                Toast.makeText(MainActivity.this, "Something Happened ... !", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    void Add_to_db(String table_name_get) {

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);
        String db_name = "sports_register";
        SQLiteDatabase records = openOrCreateDatabase(db_name, MODE_PRIVATE, null);

        if (table_name_get.equals("cricket")) {

            records.execSQL("CREATE TABLE IF NOT EXISTS Cricket(Date VARCHAR);");
            Cursor test = records.rawQuery("Select count(*) from Cricket",null);
            test.moveToLast();
            int count=test.getInt(0);

            if(count == 0) {
                ContentValues values_dummy = new ContentValues();
                values_dummy.put("Date", "0");
                records.insert("Cricket", null, values_dummy);
            }

            Cursor resultSet = records.rawQuery("Select * from Cricket",null);
            resultSet.moveToLast();
            String Date = resultSet.getString(0);

            if(Date.equals(formattedDate))
            {
               // Toast.makeText(MainActivity.this,"Already",Toast.LENGTH_SHORT).show();
                textView3.setText("ADDED");
            }
            else
            {
                ContentValues values = new ContentValues();
                values.put("Date",formattedDate);
                records.insert("Cricket", null, values);

                Cursor resultSet2 = records.rawQuery("Select * from Cricket",null);
                resultSet2.moveToLast();
                String Date_get = resultSet2.getString(0);

                //Toast.makeText(MainActivity.this,Date_get,Toast.LENGTH_SHORT).show();
                textView3.setText("NOT ADDED");
            }

        }

        if (table_name_get.equals("football")) {

            records.execSQL("CREATE TABLE IF NOT EXISTS Football(Date VARCHAR);");
            Cursor test = records.rawQuery("Select count(*) from Football",null);
            test.moveToLast();
            int count=test.getInt(0);

            if(count == 0) {
                ContentValues values_dummy = new ContentValues();
                values_dummy.put("Date", "0");
                records.insert("Football", null, values_dummy);
            }

            Cursor resultSet = records.rawQuery("Select * from Football",null);
            resultSet.moveToLast();
            String Date = resultSet.getString(0);

            if(Date.equals(formattedDate))
            {
               // Toast.makeText(MainActivity.this,"Already",Toast.LENGTH_SHORT).show();
                textView4.setText("ADDED");
            }
            else
            {
                ContentValues values = new ContentValues();
                values.put("Date",formattedDate);
                records.insert("Football", null, values);

                Cursor resultSet2 = records.rawQuery("Select * from Football",null);
                resultSet2.moveToLast();
                String Date_get = resultSet2.getString(0);

               // Toast.makeText(MainActivity.this,Date_get,Toast.LENGTH_SHORT).show();
                textView4.setText("NOT ADDED");
            }

        }


        if (table_name_get.equals("baseball")) {

            records.execSQL("CREATE TABLE IF NOT EXISTS Baseball(Date VARCHAR);");
            Cursor test = records.rawQuery("Select count(*) from Baseball",null);
            test.moveToLast();
            int count=test.getInt(0);

            if(count == 0) {
                ContentValues values_dummy = new ContentValues();
                values_dummy.put("Date", "0");
                records.insert("Baseball", null, values_dummy);
            }

            Cursor resultSet = records.rawQuery("Select * from Baseball",null);
            resultSet.moveToLast();
            String Date = resultSet.getString(0);

            if(Date.equals(formattedDate))
            {
                //Toast.makeText(MainActivity.this,"Already",Toast.LENGTH_SHORT).show();
                textView5.setText("ADDED");
            }
            else
            {
                ContentValues values = new ContentValues();
                values.put("Date",formattedDate);
                records.insert("Baseball", null, values);

                Cursor resultSet2 = records.rawQuery("Select * from Baseball",null);
                resultSet2.moveToLast();
                String Date_get = resultSet2.getString(0);

               // Toast.makeText(MainActivity.this,Date_get,Toast.LENGTH_SHORT).show();
                textView5.setText("NOT ADDED");
            }

        }

        if (table_name_get.equals("gym")) {

            records.execSQL("CREATE TABLE IF NOT EXISTS Gym(Date VARCHAR);");
            Cursor test = records.rawQuery("Select count(*) from Gym",null);
            test.moveToLast();
            int count=test.getInt(0);

            if(count == 0) {
                ContentValues values_dummy = new ContentValues();
                values_dummy.put("Date", "0");
                records.insert("Gym", null, values_dummy);
            }

            Cursor resultSet = records.rawQuery("Select * from Gym",null);
            resultSet.moveToLast();
            String Date = resultSet.getString(0);

            if(Date.equals(formattedDate))
            {
                //Toast.makeText(MainActivity.this,"Already",Toast.LENGTH_SHORT).show();
                textView6.setText("ADDED");
            }
            else
            {
                ContentValues values = new ContentValues();
                values.put("Date",formattedDate);
                records.insert("Gym", null, values);

                Cursor resultSet2 = records.rawQuery("Select * from Gym",null);
                resultSet2.moveToLast();
                String Date_get = resultSet2.getString(0);

                // Toast.makeText(MainActivity.this,Date_get,Toast.LENGTH_SHORT).show();
                textView6.setText("NOT ADDED");
            }

        }



    }
    void check(){
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);
        String db_name = "sports_register";

        SQLiteDatabase records = openOrCreateDatabase(db_name, MODE_PRIVATE, null);


        //  one ......................................
        records.execSQL("CREATE TABLE IF NOT EXISTS Gym(Date VARCHAR);");
        Cursor test_gym = records.rawQuery("Select count(*) from Gym",null);
        test_gym.moveToLast();
        int count_gym=test_gym.getInt(0);

        if(count_gym == 0) {
            //ContentValues values_dummy = new ContentValues();
            //values_dummy.put("Date", "0");
           // records.insert("Gym", null, values_dummy);
            textView6.setText("NOT");
        }
        else
        {
            Cursor resultSet_gym = records.rawQuery("Select * from Gym",null);
            resultSet_gym.moveToLast();
            String Date_gym = resultSet_gym.getString(0);

            if(Date_gym.equals(formattedDate))
            {
                //Toast.makeText(MainActivity.this,"Already",Toast.LENGTH_SHORT).show();
                textView6.setText("ADDED");
            }
            else
            {
                textView6.setText("NOT");
            }
        }

        // two ...............................................

        records.execSQL("CREATE TABLE IF NOT EXISTS Baseball(Date VARCHAR);");
        Cursor test_baseball = records.rawQuery("Select count(*) from Baseball",null);
        test_baseball.moveToLast();
        int count_baseball=test_baseball.getInt(0);

        if(count_baseball == 0) {
            //ContentValues values_dummy = new ContentValues();
            //values_dummy.put("Date", "0");
            //records.insert("Gym", null, values_dummy);
            textView5.setText("NOT");
        }
        else
        {
            Cursor resultSet_baseball = records.rawQuery("Select * from Baseball",null);
            resultSet_baseball.moveToLast();
            String Date_baseball = resultSet_baseball.getString(0);

            if(Date_baseball.equals(formattedDate))
            {
                //Toast.makeText(MainActivity.this,"Already",Toast.LENGTH_SHORT).show();
                textView5.setText("ADDED");
            }
            else
            {
                textView5.setText("NOT");
            }
        }

        // three   .......................................................

        records.execSQL("CREATE TABLE IF NOT EXISTS Football(Date VARCHAR);");
        Cursor test_football = records.rawQuery("Select count(*) from Football",null);
        test_football.moveToLast();
        int count_football=test_football.getInt(0);

        if(count_football == 0) {
            //ContentValues values_dummy = new ContentValues();
            //values_dummy.put("Date", "0");
           // records.insert("Gym", null, values_dummy);
            textView4.setText("NOT");
        }
        else
        {
            Cursor resultSet_football = records.rawQuery("Select * from Football",null);
            resultSet_football.moveToLast();
            String Date_football = resultSet_football.getString(0);

            if(Date_football.equals(formattedDate))
            {
                //Toast.makeText(MainActivity.this,"Already",Toast.LENGTH_SHORT).show();
                textView4.setText("ADDED");
            }
            else
            {
                textView4.setText("NOT");
            }
        }

        //  four  ................................................................

        records.execSQL("CREATE TABLE IF NOT EXISTS Cricket(Date VARCHAR);");
        Cursor test_cricket = records.rawQuery("Select count(*) from Cricket",null);
        test_cricket.moveToLast();
        int count_cricket=test_cricket.getInt(0);

        if(count_cricket == 0) {
            //ContentValues values_dummy = new ContentValues();
            //values_dummy.put("Date", "0");
            //records.insert("Gym", null, values_dummy);
            textView3.setText("NOT");
        }
        else
        {
            Cursor resultSet_cricket = records.rawQuery("Select * from Cricket",null);
            resultSet_cricket.moveToLast();
            String Date_cricket = resultSet_cricket.getString(0);

            if(Date_cricket.equals(formattedDate))
            {
                //Toast.makeText(MainActivity.this,"Already",Toast.LENGTH_SHORT).show();
                textView3.setText("ADDED");
            }
            else
            {
                textView3.setText("NOT");
            }
        }

    }


}
