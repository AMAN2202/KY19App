package com.example.hp.side;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvMain = (RecyclerView) findViewById(R.id.rvMain);
        Bitmap[] bitmaps = getBitmaps();

        rvMain.setAdapter(new GridLayoutAdapter(getBaseContext(), bitmaps));
        rvMain.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.tabs);
        rvMain.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 && bottomNavigationView.isShown()) {
                    bottomNavigationView.animate().translationY(bottomNavigationView.getHeight()).setDuration(200);
                    fab.animate().translationY(bottomNavigationView.getHeight()).setDuration(200);

                } else if (dy < 0) {
                    bottomNavigationView.animate().translationY(0).setDuration(200);
                    fab.animate().translationY(0).setDuration(200);

                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                super.onScrollStateChanged(recyclerView, newState);
            }
        });
    }


    //staggered layout get images form resources
    private Bitmap[] getBitmaps() {


        Bitmap[] tempbitmaps = new Bitmap[6];
        tempbitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.i7);
        tempbitmaps[1] = BitmapFactory.decodeResource(getResources(), R.drawable.i1);
        tempbitmaps[2] = BitmapFactory.decodeResource(getResources(), R.drawable.i2);
        tempbitmaps[3] = BitmapFactory.decodeResource(getResources(), R.drawable.i3);
        tempbitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.i5);
        tempbitmaps[5] = BitmapFactory.decodeResource(getResources(), R.drawable.i9);


//height ratio can be changed according to need  keepinf fixed width
//    first_col  second_col
//    1           3
//    2           1
//    3           2
//3 2 1 denote largest medium and smallest height respectively


        Bitmap x1 = Bitmap.createScaledBitmap(tempbitmaps[0], 1024, 736, true);
        Bitmap x2 = Bitmap.createScaledBitmap(tempbitmaps[1], 1024, 768, true);
        Bitmap x3 = Bitmap.createScaledBitmap(tempbitmaps[2], 1024, 800, true);

        Bitmap y1 = Bitmap.createScaledBitmap(tempbitmaps[3], 1024, 738, true);
        Bitmap y2 = Bitmap.createScaledBitmap(tempbitmaps[4], 1024, 768, true);
        Bitmap y3 = Bitmap.createScaledBitmap(tempbitmaps[5], 1024, 799, true);

        tempbitmaps[0] = x1;
        tempbitmaps[2] = x2;
        tempbitmaps[4] = x3;

        tempbitmaps[1] = y3;
        tempbitmaps[3] = y1;
        tempbitmaps[5] = y2;

        return tempbitmaps;
    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_about) {
            // Handle the camera action
        } else if (id == R.id.nav_sponsors) {

        } else if (id == R.id.nav_map) {

        } else if (id == R.id.nav_faq) {

        } else if (id == R.id.nav_helpline) {

        } else if (id == R.id.nav_team) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
