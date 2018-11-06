package com.example.hp.side;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GridHolder extends RecyclerView.ViewHolder {
    public LinearLayout linearLayout;
    ImageView imageView;

    public GridHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.ivMainImage);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.Linearlayout_item);
    }

}