package com.example.datetime;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    private TextView dob,timepicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dob=findViewById(R.id.dob);
        timepicker=findViewById(R.id.timepicker);
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker();
            }
        });

        timepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime();
            }
        });
    }

    private void loadDatePicker(){
        final Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datepicker=new DatePickerDialog(this,this,year,month,day);
        datepicker.show();


    }
    private void loadTime(){
        final Calendar c=Calendar.getInstance();
        int hour=c.get(Calendar.HOUR);
        int minute=c.get(Calendar.MINUTE);
        int second=c.get(Calendar.SECOND);

        final TimePickerDialog timepick=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                timepicker.setText("Time is :"+hourOfDay + "/" + minute);
            }
        },hour,minute,false);
        timepick.show();



    }



    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date="Month/Date/year : "+ month +"/ "+ dayOfMonth + "/" + year;
        dob.setText(date);
    }
}
