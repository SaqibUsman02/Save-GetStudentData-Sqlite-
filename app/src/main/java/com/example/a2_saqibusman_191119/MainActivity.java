package com.example.a2_saqibusman_191119;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a2_saqibusman_191119.Adapter.recyclerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edt_id,edt_name,edt_city,edt_Age;
    Button bt_save,bt_view;
    SqliteDB_Helper sqliteDB_helper;
    recyclerAdapter rvadapter;
    View view;
    RecyclerView recyclerView;
    ArrayList<String> save_id=new ArrayList<>();
    ArrayList<String> save_name=new ArrayList<>();
    ArrayList<String> save_city=new ArrayList<>();
    ArrayList<String> save_Age=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_name=findViewById(R.id.edttxt_name);
        edt_Age=findViewById(R.id.edttxt_age);
        edt_city=findViewById(R.id.edttxt_city);
        edt_id=findViewById(R.id.edttxt_id);
        recyclerView=findViewById(R.id.RV);
        sqliteDB_helper= new SqliteDB_Helper(this);

        bt_save=findViewById(R.id.btn_save);
        bt_view=findViewById(R.id.btn_view);


        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String name=edt_name.getText().toString();
                    String id=edt_id.getText().toString();
                    String city=edt_city.getText().toString();
                    String age=edt_Age.getText().toString();

                  Boolean CheckSaved=  sqliteDB_helper.InsertStudentData(id,name,city,age);
                  if(CheckSaved==true)
                  {
                      Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                  }
                  else
                  {
                      Toast.makeText(MainActivity.this, "Not Saved", Toast.LENGTH_SHORT).show();
                  }

            }
        });

        bt_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDataonTextView();

                rvadapter=new recyclerAdapter(getApplicationContext(),save_id,save_name,save_city,save_Age);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(rvadapter);
            }
        });
    }

    public void setDataonTextView()
    {

        Cursor eachRecordCursor = sqliteDB_helper.getStudentData();
        if(eachRecordCursor.getCount()==0)
        {
            Toast.makeText(this, "No Record Exist", Toast.LENGTH_SHORT).show();
        }
        while (eachRecordCursor.moveToNext())
        {
            save_id.add(eachRecordCursor.getString(0));
            save_name.add(eachRecordCursor.getString(1));
            save_Age.add(eachRecordCursor.getString(2));
            save_city.add(eachRecordCursor.getString(3));
//            String eachRecord;
//            eachRecord= "ID: " + eachRecordCursor.getString(0) + "\n";
//            eachRecord=eachRecord + "Name: " + eachRecordCursor.getString(1) + "\n ";
//            eachRecord=eachRecord + "City: " + eachRecordCursor.getString(2) + "\n ";
//            eachRecord=eachRecord + "Age: " + eachRecordCursor.getString(3) + "\n ";
//            eachRecord=eachRecord + "------------------------- \n";
//            all_Records=all_Records + eachRecord;
        }

    }
}