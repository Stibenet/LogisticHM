package com.example.logistichm.FragmentsNav;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.logistichm.R;

public class ListOrdersFragment_test extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list_orders_test);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
    }
}
