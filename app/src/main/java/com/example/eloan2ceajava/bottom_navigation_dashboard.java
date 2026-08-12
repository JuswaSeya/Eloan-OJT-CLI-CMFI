package com.example.eloan2ceajava;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.eloan2ceajava.adapter.Homepage_adapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class bottom_navigation_dashboard extends AppCompatActivity {
    private ViewPager2 ViewPager2;
    private BottomNavigationView bottomNavigationViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.bottom_navigation_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.homepage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ViewPager2 = findViewById(R.id.viewPager2);
        bottomNavigationViewPager = findViewById(R.id.nav_view);

        Homepage_adapter adapter = new Homepage_adapter(this);
        ViewPager2.setAdapter(adapter);

        bottomNavigationViewPager.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.navigation_add_transaction) {
                ViewPager2.setCurrentItem(0);
                return true;
            } else if (item.getItemId() == R.id.navigation_client_info) {
                ViewPager2.setCurrentItem(1);
                return true;
            }
//                case R.id.navigation_settings:
//                    ViewPager2.setCurrentItem(2);
//                    return true;


            ;
                return false;
        });
    }
}
