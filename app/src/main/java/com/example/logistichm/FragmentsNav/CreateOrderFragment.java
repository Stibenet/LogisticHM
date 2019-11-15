package com.example.logistichm.FragmentsNav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.logistichm.CreateOrder;
import com.example.logistichm.R;

import java.util.List;

public class CreateOrderFragment extends Fragment {
    private EditText whereFrom;
    private EditText where;
    

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_create_order, container, false);
        View rootView = inflater.inflate(R.layout.fragment_create_order, container, false);

        whereFrom = rootView.findViewById(R.id.whereFrom);
        where = rootView.findViewById(R.id.where);

        Spinner spinner = rootView.findViewById(R.id.spinner_number_movers);
        String selected = spinner.getSelectedItem().toString();
        Toast.makeText(getActivity(), selected, Toast.LENGTH_SHORT).show();
        return rootView;
    }

    private List<String> collectDataOrder(){


        return ;
    }
}
