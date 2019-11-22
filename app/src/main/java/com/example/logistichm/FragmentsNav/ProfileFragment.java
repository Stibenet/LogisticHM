package com.example.logistichm.FragmentsNav;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.logistichm.MainActivity;
import com.example.logistichm.NavActivity;
import com.example.logistichm.R;

public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        startActivity(new Intent(getContext(), ListOrdersFragment_test.class));
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}
