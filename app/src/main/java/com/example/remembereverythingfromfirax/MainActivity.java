package com.example.remembereverythingfromfirax;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    private TextView editTextTime;
    private int tHour, tMinute;

    BottomNavigationView bottomNavigationView; //меню
    private static final String TAG = "MainActivity"; //меню

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bottomNavigationView = findViewById(R.id.bottom_navigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(this);
getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit(); // меню по умолчанию
//        editTextTime = findViewById(R.id.editTextTime);
//
//        editTextTime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                TimePickerDialog timePickerDialog = new TimePickerDialog(
//                        MainActivity.this,
//                        android.R.style.Theme_Material_Light_Dialog_MinWidth,
//                        new TimePickerDialog.OnTimeSetListener() {
//                            @Override
//                            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
//                                tHour = hourOfDay;
//                                tMinute = minute;
//                                String time = tHour + ":" + tMinute;
//                                SimpleDateFormat f24Hours = new SimpleDateFormat(
//                                        "HH:mm"
//                                );
//                                try {
//                                    Date date = f24Hours.parse(time);
//                                    SimpleDateFormat f12Hours = new SimpleDateFormat(
//                                            "hh:mm aa"
//                                    );
//                                    editTextTime.setText(f24Hours.format(date));
//                                } catch (ParseException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        }, 12, 0, true
//                );
//                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                timePickerDialog.updateTime(tHour, tMinute);
//                timePickerDialog.show();
//            }
//        });

    }

    List_Of_Reminders_Fragment list = new List_Of_Reminders_Fragment();
    ShoppingFragment shopping = new ShoppingFragment();
    HomeFragment home = new HomeFragment();

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new HomeFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.miHome:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, home).commit();
                break;

            case R.id.miListOfReminders:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, list).commit();
                break;


            case R.id.miShopping:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, shopping).commit();
                break;
        }
        return true;

    }
}