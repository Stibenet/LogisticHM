package com.example.logistichm.FragmentsNav;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.logistichm.MainActivity;
import com.example.logistichm.Models.Order;
import com.example.logistichm.Models.User;
import com.example.logistichm.NavActivity;
import com.example.logistichm.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CreateOrderFragment extends Fragment {
    private EditText whereFrom, where, howManyHours, comment;
    private Spinner numberMovers;
    private RadioGroup radioGroup;
    private static String choosePay; //For store value from radioGroup

    private DatabaseReference ref;
    private Order order;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_create_order, container, false);

        Button btnCreateOrder = rootView.findViewById(R.id.button_create_order);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        whereFrom = rootView.findViewById(R.id.whereFrom);
        where = rootView.findViewById(R.id.where);
        howManyHours = rootView.findViewById(R.id.how_many_hours);
        numberMovers = rootView.findViewById(R.id.spinner_number_movers);
        comment = rootView.findViewById(R.id.comment);
        radioGroup = rootView.findViewById(R.id.radioGroup);

        radioChoosePay(); //Get value from radioGroup choose pay

        order = new Order();
        ref = database.getReference("Orders"); //Name table in DB

        btnCreateOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCreateOrder();
                Toast.makeText(getContext(), "Заявка принята", Toast.LENGTH_SHORT).show();
                //TODO go to list order
                startActivity(new Intent(getActivity(), NavActivity.class));
            }
        });

        return rootView;
    }

    //Get data order from object
    private void getValues(){
        order.setWhereFrom(whereFrom.getText().toString());
        order.setWhere(where.getText().toString());
        order.setHowManyHours(howManyHours.getText().toString());
        order.setNumberMovers(numberMovers.getSelectedItem().toString());
        order.setComment(comment.getText().toString());
        order.setChoosePay(choosePay);
    }

    //TODO переход на список заявок пользователя
    //Save data and send to DB
    private void btnCreateOrder(){
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getValues();
                ref.child("Order " + whereFrom.getText().toString()).setValue(order);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private  void radioChoosePay() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Toast.makeText(getContext(), "Ничего не выбрано",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio_cash:
                        choosePay = "Наличные";
                        break;
                    case R.id.radio_card:
                        choosePay = "Картой";
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
