package com.example.asus.lab1_basicui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Asus on 7/18/2016.
 */
public class DetailActivity extends Activity {
    TextView tvName,tvClass;
    String name,nameClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_detail_layout);
        setupView();
        getDataFromIntent();
        setDataForTextView();
    }

    private void setDataForTextView() {
        tvClass.setText(nameClass);
        tvName.setText(name);
    }

    private void getDataFromIntent() {
        Intent intent=getIntent();
        name=intent.getStringExtra(MainActivity.NAME);
        nameClass=intent.getStringExtra(MainActivity.CLASS);
    }

    private void setupView() {
        tvName=(TextView)findViewById(R.id.tvNameTeacher);
        tvClass=(TextView)findViewById(R.id.tvNameClass);
    }
}
