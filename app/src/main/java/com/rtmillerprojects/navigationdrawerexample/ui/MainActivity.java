package com.rtmillerprojects.navigationdrawerexample.ui;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.rtmillerprojects.navigationdrawerexample.R;
import com.rtmillerprojects.navigationdrawerexample.listener.MainListener;

/**
 * Created by Ryan on 5/28/2016.
 * Base Activity includes navigation options
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, MainListener{

    private DrawerLayout drawer;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer_base);
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.findFragmentByTag(MainFragment.class.getName()) == null) {

            fragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance(), MainFragment.class.getName())
                    .commit();
        }
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Toast.makeText(this, "HI", Toast.LENGTH_SHORT).show();
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
    @Override public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override public DrawerLayout getDrawer() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        return drawer;
    }
}
