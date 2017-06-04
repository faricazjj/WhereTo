package com.example.faricazjj.whereto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {
    private Button loginButton;
    private Button signUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        loginButton = (Button) findViewById(R.id.button2);
        signUpButton = (Button) findViewById(R.id.button4);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent j = new Intent(Welcome.this, LoginActivity.class);
                startActivity(j);
            }
        });


        signUpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Welcome.this, SignupActivity.class);
                startActivity(i);
            }
        });


    }


}
