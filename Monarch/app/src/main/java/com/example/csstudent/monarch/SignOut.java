package com.example.csstudent.monarch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by De'Angelo on 12/7/2016.
 */

public class SignOut extends AppCompatActivity {
    Button signOut;

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signout);
        //surpriseImage = (RadioButton)findViewById(R.id.radioButton);
        //toast = (RadioButton)findViewById(R.id.radioButton2);
        // newLogo = (ImageView)findViewById(R.id.newlogo);
        //get firebase auth instance

        signOut = (Button) findViewById(R.id.sign_out);

        auth = FirebaseAuth.getInstance();
        //get current user

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
            private void signOut(){
                auth.signOut();
                if (auth.getCurrentUser()==null){
                    startActivity(new Intent(SignOut.this, LoginActivity.class));
                    finish();
                }
            }
        });
    }}



