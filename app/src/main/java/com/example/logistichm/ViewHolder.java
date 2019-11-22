package com.example.logistichm;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    private View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
    }

    //TODO Change ChoosePay on Price. And add full info by order
    public void setDetails(Context ctx, String dateTimeOrder, String choosePay, String whereFrom, String where, String comment, String numberMovers){
        TextView mDateTime = mView.findViewById(R.id.rowDateTime);
        TextView mPrice = mView.findViewById(R.id.rowPrice);
        TextView mWhereFrom = mView.findViewById(R.id.rowWhereFrom);
        TextView mWhere = mView.findViewById(R.id.rowWhere);
        TextView mComment = mView.findViewById(R.id.rowComment);
        TextView mNumberMovers = mView.findViewById(R.id.rowNumberMovers);

        String concatNumberMovers = mNumberMovers.getText().toString() + ": " + numberMovers;

        mDateTime.setText(dateTimeOrder);
        mPrice.setText(choosePay);
        mWhereFrom.setText(whereFrom);
        mWhere.setText(where);
        mComment.setText(comment);
        mNumberMovers.setText(concatNumberMovers);
    }
}
