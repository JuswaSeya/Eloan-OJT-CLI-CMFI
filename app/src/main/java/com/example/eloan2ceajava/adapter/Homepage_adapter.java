package com.example.eloan2ceajava.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.eloan2ceajava.bottom_navigation_bar;
import com.example.eloan2ceajava.profile_fragment;

public class Homepage_adapter extends FragmentStateAdapter {
    public Homepage_adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new bottom_navigation_bar();
            case 1:
                    return new profile_fragment();
//            case 2:
//                return new SettingsFragment();
            default:
                return new bottom_navigation_bar();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Number of fragments
    }
}
