package com.example.book;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<ItemList> mItemList = new ArrayList<>();

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView mBookName, mAuthor, mPrice;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            mBookName = itemView.findViewById(R.id.booknameText);
            mAuthor = itemView.findViewById(R.id.authorText);
            mPrice = itemView.findViewById(R.id.priceText);
        }
    }

    //constructor
    public RecyclerViewAdapter(ArrayList<ItemList> mItemList) {
        this.mItemList = mItemList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: working");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        RecyclerViewHolder rvh = new RecyclerViewHolder(v);

        return rvh;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: working");
        ItemList currentItem = mItemList.get(position);

        holder.imageView.setImageResource(currentItem.getmImageResource());
        holder.mBookName.setText(currentItem.getmBookNameText());
        holder.mAuthor.setText(currentItem.getmAuthorText());
        holder.mPrice.setText(currentItem.getmPrice());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}
