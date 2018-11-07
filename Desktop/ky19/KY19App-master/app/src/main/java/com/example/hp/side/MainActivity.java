package com.example.hp.side;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//recycler_view for staggered layout having id rvMain

        rvMain = (RecyclerView) findViewById(R.id.rvMain);
        Bitmap[] bitmaps = getBitmaps();

        rvMain.setAdapter(new GridLayoutAdapter(bitmaps));
        rvMain.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
//reccler attachment ended


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
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
    }


//staggered layout get images form resources
    private Bitmap[] getBitmaps() {
        Bitmap[] tempbitmaps = new Bitmap[9];
        tempbitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.i1);
        tempbitmaps[1] = BitmapFactory.decodeResource(getResources(), R.drawable.i3);
        tempbitmaps[2] = BitmapFactory.decodeResource(getResources(), R.drawable.i4);
        tempbitmaps[3] = BitmapFactory.decodeResource(getResources(), R.drawable.i5);
        tempbitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.i6);
        tempbitmaps[5] = BitmapFactory.decodeResource(getResources(), R.drawable.i7);
        tempbitmaps[6] = BitmapFactory.decodeResource(getResources(), R.drawable.i8);
        tempbitmaps[7] = BitmapFactory.decodeResource(getResources(), R.drawable.i9);
        tempbitmaps[8] = BitmapFactory.decodeResource(getResources(), R.drawable.i2);




        return tempbitmaps;
    }

// custom GridHolder for staggered layout
    private class GridLayoutAdapter extends RecyclerView.Adapter<GridHolder> {

        Bitmap[] bitmaps;


        public GridLayoutAdapter(Bitmap[] bitmap) {
            this.bitmaps = bitmap;
        }

        @NonNull

        @Override
        public GridHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.grid_rv, parent, false);
            return new GridHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull GridHolder holder, int i) {
            holder.imageView.setImageBitmap(bitmaps[i]);
        }

        @Override
        public int getItemCount() {
            return bitmaps.length;
        }
    }

    private class GridHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public GridHolder( View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivMainImage);
        }

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
