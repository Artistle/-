package com.example.artistle.applicationforparsing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.github.mzule.fantasyslide.FantasyListener;
import com.github.mzule.fantasyslide.SideBar;

public class MainActivity extends AppCompatActivity {
    private SideBar leftSideBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftSideBar = (SideBar)findViewById(R.id.leftSideBar);
        leftSideBar.setFantasyListener(new FantasyListener() {
            @Override
            public boolean onHover(@Nullable View view, int index) {
                return false;
            }

            @Override
            public boolean onSelect(View view, int index) {
                return false;
            }

            @Override
            public void onCancel() {

            }
        });
    }
}
