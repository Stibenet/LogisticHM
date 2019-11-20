package com.example.logistichm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logistichm.Models.Order_test;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ListOrder extends AppCompatActivity {
    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list_orders);

        //RecyclerView
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Data");
    }

        @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Order_test, ViewHolder_test> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Order_test, ViewHolder_test>(
                        Order_test.class,
                        R.layout.row_test,
                        ViewHolder_test.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder_test viewHolder, Order_test order, int position) {
                        viewHolder.setDetails(getApplicationContext(), order.getTitle(), order.getDescription(), order.getImage());
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
