package com.example.eloan2ceajava.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.eloan2ceajava.DashboardFragment;
import com.example.eloan2ceajava.bottom_navigation_bar;
import com.example.eloan2ceajava.client_fragment;
import com.example.eloan2ceajava.transaction_history;

public class Homepage_adapter extends FragmentStateAdapter {
    public Homepage_adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new DashboardFragment();
            case 1:
                    return new client_fragment();
            case 2:
                return new transaction_history();
            default:
                return new DashboardFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Number of fragments
    }
}
