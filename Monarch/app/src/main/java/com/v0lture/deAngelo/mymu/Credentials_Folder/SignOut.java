package com.v0lture.deAngelo.mymu.Credentials_Folder;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.v0lture.deAngelo.mymu.Home_Tabs.NavActivity;

/**
 * Created by De'Angelo on 12/7/2016.
 */

public class SignOut extends NavActivity {
   // Button signOut;

    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();

                auth.signOut();
                if (auth.getCurrentUser()==null){
                    startActivity(new Intent(SignOut.this, LoginActivity.class));
                    finish();
                }
            }
        }



