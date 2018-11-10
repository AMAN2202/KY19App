package com.example.hp.side;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class GridLayoutAdapter extends RecyclerView.Adapter<GridHolder> {

    public Context context;
    Bitmap[] bitmaps;


    public GridLayoutAdapter(Context context, Bitmap[] bitmap) {
        this.bitmaps = bitmap;
        this.context = context;
    }

    @NonNull

    @Override
    public GridHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_rv, parent, false);
        return new GridHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridHolder holder, int i) {
        holder.imageView.setImageBitmap(bitmaps[i]);

        final int position = i;
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "item " + position + " clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return bitmaps.length;
    }
}
