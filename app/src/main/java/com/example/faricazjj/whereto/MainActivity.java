package com.example.faricazjj.whereto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;

public class MainActivity extends AppCompatActivity {
    private Button passengerbtn;
    private Button driverbtn;
    private Button postbtn;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //scrollView = (ScrollView)findViewById(R.id.scrollView);
       // scrollView.setOnClickListener();
        //refreshData();
        postbtn = (Button) findViewById(R.id.button7);
        postbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this, PostActivity.class);
                startActivity(j);
            }
        });
    }
    /*private void refreshData(){
        scrollView.setAdapter(new SimpleAdapter(this,get));
    }*/



   // });
    //};

}
