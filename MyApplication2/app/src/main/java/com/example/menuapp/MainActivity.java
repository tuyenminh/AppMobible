package com.example.menuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.menuapp.fragment.Bieudothongkefragment;
import com.example.menuapp.fragment.Capnhatdiemfragment;
import com.example.menuapp.fragment.Diemdukienfragment;
import com.example.menuapp.fragment.Homefragment;
import com.example.menuapp.fragment.Qlmonhocfragment;
import com.example.menuapp.fragment.Thoikhoabieufragment;
import com.example.menuapp.fragment.Thongtincanhanfragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Bundle savedInstanceState;
    private DrawerLayout mDrawerLayout;
    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_TTCN = 1;
    private static final int FRAGMENT_QLMH = 2;
    private static final int FRAGMENT_CND = 3;
    private static final int FRAGMENT_TKB = 4;
    private static final int FRAGMENT_BDTK = 5;
    private static final int FRAGMENT_DDK = 6;
    private int mCurrentFragment = FRAGMENT_HOME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar,
                R.string.nav_mo, R.string.nav_dong);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //bat su kien khi lick vao item
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        replaceFragment(new Homefragment());
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);

//        Button btn = findViewById(R.id.button2);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent = new Intent(MainActivity.this, diemcaithien.class);
////               startActivity(intent);
//                Toast.makeText(MainActivity.this, "Net button", Toast.LENGTH_SHORT).show();
//        }
//
//        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            if (mCurrentFragment != FRAGMENT_HOME) {
                replaceFragment(new Homefragment());
                mCurrentFragment = FRAGMENT_HOME;
            }
        }
        else if (id == R.id.thongtincanhan) {
            if (mCurrentFragment != FRAGMENT_TTCN) {
                replaceFragment(new Thongtincanhanfragment());
                mCurrentFragment = FRAGMENT_TTCN;
            }
        } else if (id == R.id.nav_capnhatdiem) {
            if (mCurrentFragment != FRAGMENT_CND) {
                replaceFragment(new Capnhatdiemfragment());
                mCurrentFragment = FRAGMENT_CND;
            }
        } else if (id == R.id.nav_quanlyhocphan) {
            if (mCurrentFragment != FRAGMENT_QLMH) {
                replaceFragment(new Qlmonhocfragment());
                mCurrentFragment = FRAGMENT_QLMH;
            }
        } else if (id == R.id.nav_thoikhoabieu) {
            if (mCurrentFragment != FRAGMENT_TKB) {
                replaceFragment(new Thoikhoabieufragment());
                mCurrentFragment = FRAGMENT_TKB;
            }
        } else if (id == R.id.nav_diemdukien) {
            if (mCurrentFragment != FRAGMENT_DDK) {
                replaceFragment(new Diemdukienfragment());
                mCurrentFragment = FRAGMENT_DDK;
            }
        } else if (id == R.id.nav_bieudothongke) {
                if (mCurrentFragment != FRAGMENT_BDTK) {
                    replaceFragment(new Bieudothongkefragment());
                    mCurrentFragment = FRAGMENT_BDTK;
                }
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
    }
}