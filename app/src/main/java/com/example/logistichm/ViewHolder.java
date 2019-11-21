//package com.example.logistichm;
//
//import android.content.Context;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.squareup.picasso.Picasso;
//
//public class ViewHolder extends RecyclerView.ViewHolder {
//
//    View mView;
//
//    public ViewHolder(@NonNull View itemView) {
//        super(itemView);
//
//        mView = itemView;
//    }
//
//    public void setDetails(String whereFrom, String where, String howManyHours, String numberMovers, String comment, String choosePay){
//        TextView mTitleView = mView.findViewById(R.id.rTitleTv);
//        TextView mDetailTv = mView.findViewById(R.id.rDescriptionTv);
//        ImageView mImageTv = mView.findViewById(R.id.rImageView);
//
//        mTitleView.setText(title);
//        mDetailTv.setText(description);
//        Picasso.get().load(image).into(mImageTv);
//    }
//}
