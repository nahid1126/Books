package com.example.book;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends MainActivity {

    private RecyclerView mRecyclerViewD;

    private RecyclerView.Adapter mAdapterD;
    private RecyclerView.LayoutManager mLayoutManagerD;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //new DetailsActivity().createIslamicItemList();

        builtislamicBook();
        builtislamicNovel();

        textView=findViewById(R.id.detailshedding);


    }



    public void builtislamicNovel() {
        Intent intent=getIntent();
        String mes=intent.getStringExtra("Hedding");
        textView.setText(mes);
        mRecyclerViewD = findViewById(R.id.recyclerViewD);
        mRecyclerViewD.setHasFixedSize(true);
        mLayoutManagerD = new LinearLayoutManager(getApplicationContext());
        mAdapterD = new RecyclerViewAdapter(mItemListNovel);

        mRecyclerViewD.setLayoutManager(mLayoutManagerD);
        mRecyclerViewD.setItemAnimator(new DefaultItemAnimator());
        mRecyclerViewD.setAdapter(mAdapterD);
    }

    public void builtislamicBook() {
        Intent intent=getIntent();
        String mes1 =intent.getStringExtra("Hedding");
        textView.setText(mes1);
        mRecyclerViewD = findViewById(R.id.recyclerViewD);
        mRecyclerViewD.setHasFixedSize(true);
        mLayoutManagerD = new LinearLayoutManager(getApplicationContext());
        mAdapterD = new RecyclerViewAdapter(mItemListIslam);

        mRecyclerViewD.setLayoutManager(mLayoutManagerD);
        mRecyclerViewD.setItemAnimator(new DefaultItemAnimator());
        mRecyclerViewD.setAdapter(mAdapterD);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==ISLAMICALL){
            builtislamicBook();
        }
        else if (resultCode==NOVELALL){
            builtislamicNovel();
        }
    }

}
