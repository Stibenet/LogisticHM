package com.example.logistichm.FragmentsNav;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.logistichm.ListOrderBlank;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position){
        ListOrderBlank listOrderBlank = new ListOrderBlank();
        position = position + 1;
        Bundle bundle = new Bundle();
        bundle.putString("message", "Fragment :" + position);
        listOrderBlank.setArguments(bundle);
        return listOrderBlank;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
