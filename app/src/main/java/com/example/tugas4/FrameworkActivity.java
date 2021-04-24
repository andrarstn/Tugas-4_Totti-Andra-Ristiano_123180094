package com.example.tugas4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class FrameworkActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_framework);

        navbar = findViewById(R.id.main_nav);
        navbar.setOnNavigationItemSelectedListener(this);

        loadFragment(new Fragment());

        if(savedInstanceState == null) {
            getSupportFragmentManager().
                    beginTransaction().replace(R.id.main_fragment,new recyclerViewFragment()).commit();
        }
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.main_fragment, fragment).
                    commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.ic_home:
                fragment = new recyclerViewFragment();
                break;

            case R.id.ic_person:
              fragment = new UserFragment();
              break;
        }
        return loadFragment(fragment);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void clickMethod(View v) {
        switch(v.getId()) {
            case R.id.btn_logout:
                SharedPreferences preferences = getSharedPreferences("SAVED_LOGIN", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();

                Intent intent = new Intent(FrameworkActivity.this, MainActivity.class);
                FrameworkActivity.this.startActivity(intent);
                finish();
                break;

            case R.id.btn_edit_profile:
                Intent intentEP = new Intent(FrameworkActivity.this, EditProfileActivity.class);
                FrameworkActivity.this.startActivity(intentEP);
                finish();
                break;
        }
    }
}