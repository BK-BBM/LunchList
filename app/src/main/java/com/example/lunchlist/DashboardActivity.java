package com.example.lunchlist;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DashboardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        /* after creating our own toolbar, we're making it the default actionBar
        a toolbar is an improved version of an actionbar.

        we use setSupportActionBar(then we parse our toolbar)
        and we want the title to be disabled because we added our own title in XML on the toolbar

        * */
    }


    /*
    * we use onCreateOptionsMenu to specify Options for our custom menu.
    *and then we inflate it with the XML menu resource
    * we return true so that it stays inflated/ so that our options stick
    * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.popup_menu, menu);
        return true;
    }


    /* onOptionsItemSelected specifies an action that must occur once a menuItem is clicked.
     a menu item is anything on the list /menu list
    * */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.popUp_profile) {
            //open profile page
        }
        else if (itemId == R.id.popUp_History) {
            //show history
        }
        else if (itemId == R.id.popUp_darkmode) {
            //change to dark mode
        }
        else if (itemId == R.id.popUp_settings) {
            //open settings
        } else if (itemId == R.id.popUp_Logout) {
            //log user out
        } else {
            throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }

        return super.onOptionsItemSelected(item);
    }
}


