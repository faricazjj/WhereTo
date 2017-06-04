package com.example.faricazjj.whereto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;
import android.support.annotation.*;
import com.google.firebase.database.*;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override

            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    //Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    //Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
    }
    String first;
    String last;
    String username;
    String email;
    String password;
    DatabaseReference.CompletionListener callback;


    public void onSignUp(View Button) {
        //after clicking the button
        EditText firstBox = (EditText)findViewById(R.id.editText2);
        EditText lastBox = (EditText)findViewById(R.id.editText4);
        EditText usernameBox = (EditText)findViewById(R.id.editText7);
        EditText emailBox = (EditText)findViewById(R.id.editText11);
        EditText passwordBox = (EditText)findViewById(R.id.editText10);
        first = firstBox.getText().toString();
        last = lastBox.getText().toString();
        username = usernameBox.getText().toString();
        email = emailBox.getText().toString();
        password = passwordBox.getText().toString();

        Task<AuthResult> userEvent = mAuth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.i("WHERETO", "createUserWithEmail:onComplete:" + task.isSuccessful());

                if (task.isSuccessful()) {
                    FirebaseUser user = task.getResult().getUser();
                    Log.i("WHERETO", "onComplete: uid=" + user.getUid());
                    Map<String,Object> map = new HashMap<>();
                    map.put("Email", email);
                    map.put("Firstname", first);
                    map.put("Lastname", last);
                    map.put("Username", username);


                    Map<String, Object> uidMap = new HashMap();
                    uidMap.put(user.getUid(), map);
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference userRef = database.getReference().child("Users");
                    userRef.updateChildren(uidMap, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                            Intent j = new Intent(SignupActivity.this, MainActivity.class);
                            startActivity(j);
                        }
                    });

                    // go to main activity


                }

                else {
                    //// TODO: 6/4/17
                }


            }
        });

        //Log.i("WHERETO");

    }

}

