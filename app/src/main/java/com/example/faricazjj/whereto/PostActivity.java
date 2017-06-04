package com.example.faricazjj.whereto;

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

public class PostActivity extends AppCompatActivity {
    private Spinner spinner1, destination, month, day, time;
    private Button buttonPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        addItemsOnDestination();
        addItemsOnMonth();
        addItemsOnDay();
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
        List<String> list = new ArrayList<String>();
        list.add("0:00");
        list.add("1:00");
        list.add("2:00");
        list.add("3:00");
        list.add("4:00");
        list.add("5:00");
        list.add("6:00");
        list.add("7:00");
        list.add("8:00");
        list.add("9:00");
        list.add("10:00");
        list.add("11:00");
        list.add("12:00");
        list.add("13:00");
        list.add("14:00");
        list.add("15:00");
        list.add("16:00");
        list.add("17:00");
        list.add("18:00");
        list.add("19:00");
        list.add("20:00");
        list.add("21:00");
        list.add("22:00");
        list.add("23:00");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
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

        buttonPost.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(PostActivity.this,
                        "OnClickListener : " +
                                "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) +
                                "\nDestination : "+ String.valueOf(destination.getSelectedItem()) +
                                "\nMonth : "+ String.valueOf(month.getSelectedItem()) + "\nDay : "+
                                String.valueOf(day.getSelectedItem()) + "\nTime : "+
                                String.valueOf(time.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }

        });
    }


}
