package com.v0lture.deAngelo.mymu.Home_Tabs;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.v0lture.deAngelo.mymu.Anouncement_Folder.AnnounceActivity;
import com.v0lture.deAngelo.mymu.Bugs_Folder.Bugs;
import com.v0lture.deAngelo.mymu.R;
import com.v0lture.deAngelo.mymu.Schedule_Folder.ScheduleActivity;
import com.v0lture.deAngelo.mymu.Credentials_Folder.SignOut;
import com.v0lture.deAngelo.mymu.Tools_Fragment.ToolsActivity;


public class NavActivity extends AppCompatActivity{
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    //RadioButton surpriseImage;
   // RadioButton toast;
    //ImageView newLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        //surpriseImage = (RadioButton)findViewById(R.id.radioButton);
        //toast = (RadioButton)findViewById(R.id.radioButton2);
        // newLogo = (ImageView)findViewById(R.id.newlogo);



        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();


        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();


                if (menuItem.getItemId() == R.id.nav_announce) {
                    startActivity(new Intent(NavActivity.this, AnnounceActivity.class));
                    Toast.makeText(getApplicationContext(), "Click text for more info!", Toast.LENGTH_SHORT).show();
                }
                if (menuItem.getItemId() == R.id.nav_schedule) {
                    startActivity(new Intent(NavActivity.this, ScheduleActivity.class));
                }
                if (menuItem.getItemId() == R.id.bugs) {
                    startActivity(new Intent(NavActivity.this, Bugs.class));
                }
                if (menuItem.getItemId() == R.id.tools){
                    startActivity(new Intent(NavActivity.this, ToolsActivity.class));
                }
                if (menuItem.getItemId() == R.id.out) {
                    new AlertDialog.Builder(NavActivity.this)
                            .setIcon(android.R.drawable.ic_lock_power_off)
                            .setTitle("Logging Out")
                            .setMessage("Are you sure you want to log out?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            startActivity(new Intent(NavActivity.this, SignOut.class));
                                        }
                                    })
                    .setNegativeButton("No", null)
                            .show();

                }



                return false;
            }

        });
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name,
                R.string.app_name);

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();
    }

}
    /*@Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }


    }
   // public void  check(View v) {
        //boolean checked = ((RadioButton) v).isChecked();
        //switch (v.getId()) {
           // case R.id.radioButton:
              //  if (checked)
              //  surpriseImage.setVisibility(View.INVISIBLE);
              //  toast.setVisibility(View.INVISIBLE);
              //  break;
            //case R.id.radioButton2:
              //  if (checked)
              //      Toast.makeText(NavActivity.this, "Guess Not :/",
                           // Toast.LENGTH_LONG).show();
//break;
       // }
    //}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            startActivity(new Intent(NavActivity.this, NavActivity.class));
        } else if (id == R.id.nav_announce) {
            startActivity(new Intent(NavActivity.this, AnnounceActivity.class));
        } else if (id == R.id.nav_schedule) {
            startActivity(new Intent(NavActivity.this, ScheduleActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}*/
