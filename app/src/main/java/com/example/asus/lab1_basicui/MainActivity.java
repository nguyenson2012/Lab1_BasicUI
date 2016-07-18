package com.example.asus.lab1_basicui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String NAME="name";
    public static final String CLASS="class";
    TextView tvName,tvClass,tvDate;
    Spinner spinnerName,spinnerClass;
    Button buttonSubmit;
    ArrayAdapter<String> nameAdapter;
    ArrayAdapter<String> classAdapter;
    Calendar calendar;
    String nameTeacher;
    String nameClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
        setAdapterForSpinner();
        getCurrentDate();
        registerEvent();
    }

    private void registerEvent() {
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra(NAME,nameTeacher);
                intent.putExtra(CLASS,nameClass);
                startActivity(intent);
            }
        });
        spinnerName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                  @Override
                                                  public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                                      nameTeacher=adapterView.getItemAtPosition(i).toString();
                                                  }

                                                  @Override
                                                  public void onNothingSelected(AdapterView<?> adapterView) {

                                                  }
                                              });
                spinnerClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        nameClass=adapterView.getItemAtPosition(i).toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
    }

    private void getCurrentDate() {
        calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int date=calendar.get(Calendar.DATE);
        String today=date+"/"+month+"/"+year;
        tvDate.setText(today+"");
    }

    private void setAdapterForSpinner() {
        List<String> listNameTeacher=new ArrayList<String>();
        listNameTeacher.add("Nguyễn Quang Huy");
        listNameTeacher.add("Trần Đức Hùng");
        listNameTeacher.add("Bùi Xuân Cảnh");
        nameAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,listNameTeacher);
        spinnerName.setAdapter(nameAdapter);
        List<String> listNameClass=new ArrayList<String>();
        listNameClass.add("Summer Code Camp");
        listNameClass.add("Android 4");
        listNameClass.add("iOS 4");
        classAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,listNameClass);
        spinnerClass.setAdapter(classAdapter);
    }

    private void setupView() {
        tvName= (TextView) findViewById(R.id.textviewName);
        tvClass=(TextView)findViewById(R.id.textviewClass);
        tvDate=(TextView)findViewById(R.id.textviewDate);
        spinnerName=(Spinner)findViewById(R.id.spinner_name);
        spinnerClass=(Spinner)findViewById(R.id.spinner_class);
        buttonSubmit=(Button)findViewById(R.id.button_commit);
    }
}
