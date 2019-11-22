package com.example.logistichm.FragmentsNav;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.logistichm.Models.Order;
import com.example.logistichm.NavActivity;
import com.example.logistichm.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Objects;

public class CreateOrderFragment extends Fragment {
    private EditText whereFrom, where, comment;
    private Spinner numberMovers;
    private RadioGroup radioGroup;
    private static String choosePay; //For store value from radioGroup
    private Button btnCreateOrder, btnSetDate, btnSetTime;

    private DatabaseReference ref;
    private Order order;

    private TextView currentDateTime;
    private Calendar dateAndTime = Calendar.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_create_order, container, false);
        order = new Order();

        btnCreateOrder = rootView.findViewById(R.id.button_create_order);
        btnSetDate = rootView.findViewById(R.id.dateButton);
        btnSetTime = rootView.findViewById(R.id.timeButton);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        whereFrom = rootView.findViewById(R.id.whereFrom);
        where = rootView.findViewById(R.id.where);
        numberMovers = rootView.findViewById(R.id.spinner_number_movers);
        comment = rootView.findViewById(R.id.comment);
        radioGroup = rootView.findViewById(R.id.radioGroup);

        radioChoosePay(); //Get value from radioGroup choose pay

        ref = database.getReference("Orders"); //Name table in DB

        currentDateTime = rootView.findViewById(R.id.currentDateTime); //date and time order
        setInitialDateTime();
        getListenerButtons();

        return rootView;
    }

    //ALL BUTTONS
    private void getListenerButtons(){
        btnSetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDate(view);
            }
        });

        btnSetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTime(view);
            }
        });

        btnCreateOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCreateOrder();
                Toast.makeText(getContext(), "Заявка принята", Toast.LENGTH_SHORT).show();
                //TODO go to list order
                startActivity(new Intent(getActivity(), NavActivity.class));
            }
        });
    }

    //Get data order from object
    private void getValues(){
        order.setWhereFrom(whereFrom.getText().toString());
        order.setWhere(where.getText().toString());
        order.setDateTimeOrder(resultValueDateTime());
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

    //DATE AND TIME
    // отображаем диалоговое окно для выбора даты
    public void setDate(View v) {
        new DatePickerDialog(Objects.requireNonNull(getContext()), d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    // отображаем диалоговое окно для выбора времени
    public void setTime(View v) {
        new TimePickerDialog(Objects.requireNonNull(getContext()), t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true)
                .show();
    }

    private String resultValueDateTime(){
        return DateUtils.formatDateTime(getContext(),
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                        | DateUtils.FORMAT_SHOW_TIME);
    }

    // установка начальных даты и времени
    private void setInitialDateTime() {
        currentDateTime.setText(resultValueDateTime());
    }

    // установка обработчика выбора времени
    private TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            setInitialDateTime();
        }
    };

    // установка обработчика выбора даты
    private DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDateTime();
        }
    };
}
