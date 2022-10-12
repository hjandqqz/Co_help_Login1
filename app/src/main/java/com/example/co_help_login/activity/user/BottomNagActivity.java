package com.example.co_help_login.activity.user;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.co_help_login.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNagActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomnag);
        bottomNavigationView  = findViewById(R.id.bottomNav);



        //设置监听事件
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

//            if(savedInstanceState == null)

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                switch (menuItem.getItemId()){
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.publish:
                        fragment = new MeFragment();
                        break;
                    case R.id.me:
                        fragment = new PublishFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
                return true;
            }
        });
    }
}