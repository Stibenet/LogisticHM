package com.example.logistichm.FragmentsNav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logistichm.ListOrder;
import com.example.logistichm.Models.Order;
import com.example.logistichm.R;
import com.example.logistichm.ViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ListOrdersFragment extends Fragment {
    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_orders, container, false);

        //RecyclerView
        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Data");

        showOrders();
        return rootView;
    }

    public void showOrders(){
        FirebaseRecyclerAdapter<Order, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Order, ViewHolder>(
                        Order.class,
                        R.layout.row,
                        ViewHolder.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Order order, int position) {
                        viewHolder.setDetails(getActivity(), order.getTitle(), order.getDescription(), order.getImage());
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
