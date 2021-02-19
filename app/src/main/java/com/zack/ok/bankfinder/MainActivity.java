package com.zack.ok.bankfinder;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_name) {
            Intent intent=new Intent(MainActivity.this,Name.class);
            startActivity(intent);
        } else if (id == R.id.nav_address) {
            Intent intent=new Intent(MainActivity.this,Address.class);
            startActivity(intent);
        } else if (id == R.id.nav_search) {
            Intent intent=new Intent(MainActivity.this,Search.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "BankFinder");
            // Replace * Bank Finder * with  the app link
            String message = "\nLet me recommend you this application *Bank Finder* \n\n";

            i.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(Intent.createChooser(i, "Share Using"));
        }
           else if (id == R.id.nav_about) {
            Intent intent=new Intent(MainActivity.this,About.class);
            startActivity(intent);

        }
           else if (id == R.id.nav_Exit) {
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
