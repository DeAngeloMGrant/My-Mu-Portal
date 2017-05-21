package com.v0lture.deAngelo.mymu.credentials_folder;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.v0lture.deAngelo.mymu.home_tabs.NavActivity;

/**
 * Created by De'Angelo on 12/7/2016.
 */

public class SignOut extends NavActivity {
   // Button signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       FirebaseAuth auth = FirebaseAuth.getInstance();

                auth.signOut();
                if (auth.getCurrentUser()==null){
                    startActivity(new Intent(SignOut.this, LoginActivity.class));
                    finish();
                }
            }
        }



