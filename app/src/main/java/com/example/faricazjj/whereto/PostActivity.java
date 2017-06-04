package com.example.faricazjj.whereto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static com.example.faricazjj.whereto.R.id.post1;
import static com.example.faricazjj.whereto.R.id.post1_back;

public class PostActivity extends AppCompatActivity {
    private Spinner spinner1, destination, month, day, time;
    public Button buttonPost;
    private Button post1, post1_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        addItemsOnDestination();
        addItemsOnMonth();
        addItemsOnDay();
        addItemsOnTime();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();

    }

    // add items into spinner dynamically
    public void addItemsOnDestination() {

        destination = (Spinner) findViewById(R.id.destination);
        List<String> list = new ArrayList<String>();
        list.add("San Jose");
        list.add("Los Angeles");
        list.add("Sacramento");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destination.setAdapter(dataAdapter);
    }
    public void addItemsOnMonth(){
        month = (Spinner) findViewById(R.id.month);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        month.setAdapter(dataAdapter);
    }
    public void addItemsOnDay(){
        day = (Spinner) findViewById(R.id.day);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= 31; i++){
            list.add(i);
        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        day.setAdapter(dataAdapter);
        }
    }
    public void addItemsOnTime(){
        time = (Spinner) findViewById(R.id.time);
        List<String> timeList = new ArrayList<String>();
        timeList.add("0:00");
        timeList.add("1:00");
        timeList.add("2:00");
        timeList.add("3:00");
        timeList.add("4:00");
        timeList.add("5:00");
        timeList.add("6:00");
        timeList.add("7:00");
        timeList.add("8:00");
        timeList.add("9:00");
        timeList.add("10:00");
        timeList.add("11:00");
        timeList.add("12:00");
        timeList.add("13:00");
        timeList.add("14:00");
        timeList.add("15:00");
        timeList.add("16:00");
        timeList.add("17:00");
        timeList.add("18:00");
        timeList.add("19:00");
        timeList.add("20:00");
        timeList.add("21:00");
        timeList.add("22:00");
        timeList.add("23:00");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, timeList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        time.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        destination = (Spinner) findViewById(R.id.destination);
        destination.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        month = (Spinner) findViewById(R.id.month);
        month.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        day = (Spinner) findViewById(R.id.day);
        day.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        time = (Spinner) findViewById(R.id.time);
        time.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }



    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        destination = (Spinner) findViewById(R.id.destination);
        buttonPost = (Button) findViewById(R.id.buttonPost);
        month = (Spinner) findViewById(R.id.month);
        day = (Spinner) findViewById(R.id.day);
        time = (Spinner) findViewById(R.id.time);
        post1_back = (Button) findViewById(R.id.post1_back);
        post1 = (Button) findViewById(R.id.post1);


        buttonPost.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                post1.setVisibility(View.VISIBLE);
                post1_back.setVisibility(View.VISIBLE);
                Intent j = new Intent(PostActivity.this, MainActivity.class);
                startActivity(j);
            }


        });
    }


}
