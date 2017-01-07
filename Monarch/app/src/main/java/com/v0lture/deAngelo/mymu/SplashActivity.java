package com.v0lture.deAngelo.mymu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.v0lture.deAngelo.mymu.Credentials_Folder.LoginActivity;

/**
 * Created by De'Angelo on 12/30/2016.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
