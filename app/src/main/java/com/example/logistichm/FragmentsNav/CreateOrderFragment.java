package com.example.logistichm.FragmentsNav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.logistichm.R;

import java.util.ArrayList;

public class CreateOrderFragment extends Fragment {
    private EditText whereFrom, where, howManyHours, comment;
    private Spinner numberMovers;
    private Button btnCreateOrder;

    ArrayList<String> dataOrder = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_create_order, container, false);
        View rootView = inflater.inflate(R.layout.fragment_create_order, container, false);

        whereFrom = rootView.findViewById(R.id.whereFrom);
        where = rootView.findViewById(R.id.where);
        howManyHours = rootView.findViewById(R.id.how_many_hours);
        numberMovers = rootView.findViewById(R.id.spinner_number_movers);
        comment = rootView.findViewById(R.id.comment);
        btnCreateOrder = rootView.findViewById(R.id.button_create_order);

        return rootView;
    }

    private void collectDataOrder(){
        String resWhereFrom = whereFrom.getText().toString();
        String resWhere = where.getText().toString();
        String resHowManyHours = howManyHours.getText().toString();
        String selectNumbetMovers = numberMovers.getSelectedItem().toString();
        String resComment = comment.getText().toString();

        dataOrder.add(resWhereFrom);
        dataOrder.add(resWhere);
        dataOrder.add(resHowManyHours);
        dataOrder.add(selectNumbetMovers);
        dataOrder.add(resComment);
    }

    private void checkButton(){
        btnCreateOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), (CharSequence) dataOrder, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
