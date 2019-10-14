package com.example.prince.g_app;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SearchView;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class Main_Window extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Fragment myfragment;
    FrameLayout mHostFragment;
    RelativeLayout re;
    Toolbar toolbar;

    NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__window);
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mHostFragment = (FrameLayout) findViewById(R.id.frame);
        re=(RelativeLayout)findViewById(R.id.re);





//       getSupportActionBar().setDisplayShowTitleEnabled(false);
        // Fragment myfragment;
        myfragment = new Subjects_main();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame, myfragment);
        ft.commit();




        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close){

           /* public void onDrawerClosed(View view) {
                getActionBar().setTitle("hello");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }*/

            /*public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle("hello2");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }*/
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float xPositionOpenDrawer = navigationView.getWidth();
                float xPositionWindowContent = (slideOffset * xPositionOpenDrawer);
                re.setX(xPositionWindowContent);
                //getActionBarView().setX(xPositionWindowContent);

            }
        };
        toggle.setDrawerIndicatorEnabled(false);
       /* Drawable drawable = ResourcesCompat.getDrawable(getResources(),
                android.R.drawable.btn_plus, this.getTheme());*/
        toggle.setHomeAsUpIndicator(R.drawable.nav_bb);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                if (drawer.isDrawerVisible(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }});

            drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




    }
    public View getActionBarView() {

        Window window = this.getWindow();
        final View decorView = window.getDecorView();
        final String packageName =  "android";
        final int resId = this.getResources().getIdentifier("action_bar_container", "id", packageName);
        final View actionBarView = decorView.findViewById(resId);
        return actionBarView;
    }

   /* public void onDrawerSlide(View drawerView, float offset) {
        RelativeLayout container = (RelativeLayout) findViewById(R.id.re);
        container.setTranslationX(offset * drawerView.getWidth());
    }*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                            System.exit(0);
                        }
                    })
                    .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
            // super.onBackPressed();
        }

    }


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        return true;
    }*/
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inflater = getMenuInflater();
       // Inflate menu to add items to action bar if it is present.
       inflater.inflate(R.menu.search_menu, menu);

       // Associate searchable configuration with the SearchView
       SearchManager searchManager =
               (SearchManager) getSystemService(Context.SEARCH_SERVICE);
       SearchView searchView =
               (SearchView) menu.findItem(R.id.menu_search).getActionView();
       searchView.setSearchableInfo(
               searchManager.getSearchableInfo(getComponentName()));

       return true;
   }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.subject) {
            // Fragment myfragment;
            myfragment = new Subjects_main();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame, myfragment);
            ft.commit();
        } else if (id == R.id.recentview) {
            //   Fragment myfragment;
            Intent  rec=new Intent(Main_Window.this,Recently_view.class);
            startActivity(rec);

        } else if (id == R.id.favourite) {
            Intent  fav=new Intent(Main_Window.this,Favourite.class);
            startActivity(fav);


        } else if (id == R.id.userguide) {

            Intent i = new Intent(Main_Window.this, View_pager_user_guide.class);
            startActivity(i);

        } else if (id == R.id.whygate) {
            Intent why = new Intent(Main_Window.this, Why_gate.class);
            startActivity(why);


        }else if(id==R.id.feed){


            Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "gudboysonu@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
            intent.putExtra(Intent.EXTRA_TEXT, "Dear"+"\n");
            startActivity(intent);

        } else if (id == R.id.exit) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                            System.exit(0);
                        }
                    })
                    .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }/*else if (id == R.id.search) {
            myfragment = new Search();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame, myfragment);
            ft.commit();
        }*/
        else if (id==R.id.fre){
            Intent intent =new Intent(Main_Window.this,Frequently.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
