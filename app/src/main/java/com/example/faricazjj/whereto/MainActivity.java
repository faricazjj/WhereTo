package com.example.faricazjj.whereto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private Button passengerbtn;
    private Button driverbtn;
    private Button postbtn;
    private Button post1;
    private ScrollView scrollView;

    String postID;
    String postFieldKey;
    String postFieldValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference postRef = database.getReference("Posts");

        // Read from the database
        postRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {

                    postID = postSnapshot.getKey();

                    for (DataSnapshot postData: postSnapshot.getChildren()) {
                        postFieldKey = postData.getKey();
                        postFieldValue = postData.getValue(String.class);


                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("WHERETO", "Failed to read value.", error.toException());
            }
        });

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

        post1 = (Button) findViewById(R.id.post1);
        post1.setVisibility(View.GONE);
        post1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                post1.setVisibility(View.VISIBLE);
                Intent k = new Intent(MainActivity.this, Confirmation.class);
                startActivity(k);
            }
        });

    }
    /*private void refreshData(){
        scrollView.setAdapter(new SimpleAdapter(this,get));
    }*/



   // });
    //};

}
