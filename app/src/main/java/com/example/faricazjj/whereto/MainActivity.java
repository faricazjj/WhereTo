package com.example.faricazjj.whereto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private Button passengerbtn;
    private Button driverbtn;
    private Button postbtn;
    public Button post1;
    public Button post1_back;
    private Button buttonPost;
    private ScrollView scrollView;
    private FirebaseAuth auth;

    String postID;
    String postFieldKey;
    String postFieldValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // auth = FirebaseAuth.getInstance();
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference userRef = database.getReference().child("Users");
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
        post1_back = (Button) findViewById(R.id.post1_back);
       // post1.setVisibility(View.GONE);
       // post1_back.setVisibility(View.GONE);
        post1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent k = new Intent(MainActivity.this, Confirmation.class);
                startActivityForResult(k, 1);

            }
        });
    }
   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("Caitlyn","IN ON ACTIVITY RESULT"+requestCode + resultCode + data);
        if (requestCode == 1) {
            post1.setVisibility(View.VISIBLE);
            post1_back.setVisibility(View.VISIBLE);
            Log.e("Caitlyn","activity results here");
        } else {
            post1.setVisibility(View.GONE);
            post1_back.setVisibility(View.GONE);
        }
    }*/


    /*private void refreshData(){
        scrollView.setAdapter(new SimpleAdapter(this,get));
    }*/



   // });
    //};

}
