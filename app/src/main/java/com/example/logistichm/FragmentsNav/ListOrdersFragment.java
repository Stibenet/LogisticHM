package com.example.logistichm.FragmentsNav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logistichm.Models.Order;
import com.example.logistichm.Models.Order_test;
import com.example.logistichm.R;
import com.example.logistichm.ViewHolder;
import com.example.logistichm.ViewHolder_test;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//TODO 2 tabs: all and current orders
public class ListOrdersFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private DatabaseReference mRef;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_orders, container, false);

        //RecyclerView
        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Orders");

        showOrders();

        return rootView;
    }

    private void showOrders(){
        FirebaseRecyclerAdapter<Order, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Order, ViewHolder>(
                        Order.class,
                        R.layout.row,
                        ViewHolder.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Order order, int position) {
                        viewHolder.setDetails(
                                getActivity(),
                                order.getDateTimeOrder(),
                                order.getChoosePay(),
                                order.getWhereFrom(),
                                order.getWhere(),
                                order.getComment(),
                                order.getNumberMovers());
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
