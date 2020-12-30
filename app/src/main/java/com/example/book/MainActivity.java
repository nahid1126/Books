package com.example.book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int ISLAMICALL = 1;
    public static final int NOVELALL = 2;
    public static final int HORRORALL = 3;
    public static final int PROALL = 4;
    private RecyclerView mRecyclerView;
    private TextView mTextView;

    // private RecyclerView.Adapter mAdapter;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final String TAG = "MainActivity";
    public ArrayList<ItemList> mItemListIslam, mItemListNovel, mItemListHorror, mItemListPro;
    private CarouselView carouselView;
    private int[] mImage = new int[]{
            R.drawable.slide1, R.drawable.slide2, R.drawable.slide3
    };

    private Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: started");

        createIslamicItemList();
        createProgramItemList();
        createNovelItemList();
        createHorrorItemList();

        builtRecyclerViewIslam();
        builtRecyclerViewPro();
        builtRecyclerViewNovel();
        builtRecyclerViewIslamHorror();

        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(mImage.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImage[position]);
            }
        });


        button1=findViewById(R.id.buttonI);
        button2=findViewById(R.id.buttonP);
        button3=findViewById(R.id.buttonN);
        button4=findViewById(R.id.buttonH);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    private void createIslamicItemList() {
        mItemListIslam = new ArrayList<>();
        mItemListIslam.add(new ItemList(R.drawable.islam, "প্যারাডক্সিক্যাল\n সাজিদ", "আরিফ আজাদ", "100tk"));
        mItemListIslam.add(new ItemList(R.drawable.islam2, "ঈমানের দাবী", "সাইয়েদ আবুল হাসান\nনদভী র.", "90tk"));
        mItemListIslam.add(new ItemList(R.drawable.islam3, "লেকচার সমগ্র", "ডা.জাকির নায়েক", "100tk"));

    }

    private void createProgramItemList() {
        mItemListPro = new ArrayList<>();
        mItemListPro.add(new ItemList(R.drawable.pro, "৫২টি প্রোগ্রামিং \nসমস্যা ও সমাধান", "তামিম শাহ্রিয়ার", "120tk"));
        mItemListPro.add(new ItemList(R.drawable.pro1, "ডেটা স্ট্রাকচার \nও অ্যালগরিদম", "তামিম শাহ্রিয়ার", "150tk"));
        mItemListPro.add(new ItemList(R.drawable.pro2, "কম্পিউটার প্রোগ্রামিং\n ১ম", "তামিম শাহ্রিয়ার সুবিন", "100tk"));
        mItemListPro.add(new ItemList(R.drawable.pro3, "সহজে শিখি \nসি প্রোগ্রামিং", "আরিফুজ্জামান ফয়সাল", "100tk"));
        mItemListPro.add(new ItemList(R.drawable.pro4, "পাইথন দিয়ে\n প্রোগ্রামিং শেখা", "তামিম শাহ্রিয়ার সুবিন", "90tk"));
        mItemListPro.add(new ItemList(R.drawable.pro5, "জাভা স্ক্রিপ্ট", "জসিম উদ্দিন", "200tk"));
        mItemListPro.add(new ItemList(R.drawable.pro6, "কম্পিউটার প্রোগ্রামিং\n ২য়", "তামিম শাহ্রিয়ার সুবিন", "100tk"));
        mItemListPro.add(new ItemList(R.drawable.pro7, "Java", "Daniel Liand", "600tk"));
    }

    private void createNovelItemList() {
        mItemListNovel = new ArrayList<>();
        mItemListNovel.add(new ItemList(R.drawable.upo, "এত কাছে তুমি \nতবু এত দূরে", "কামাল হোসেন টিপু", "110tk"));
        mItemListNovel.add(new ItemList(R.drawable.upo1, "পথ হারিয়ে পথে", "রকিবুল ইসলাম মুকুল", "90tk"));
        mItemListNovel.add(new ItemList(R.drawable.upo2, "সেরা পাচ\n প্রেমের\n উপন্যাস", "হুমায়ূন আহমেদ", "100tk"));
        mItemListNovel.add(new ItemList(R.drawable.upo3, "কে কথা কয়", "হুমায়ূন আহমেদ", "120tk"));
        mItemListNovel.add(new ItemList(R.drawable.upo4, "সেরা পাচ\n মুক্তিযুদ্ধের\n উপন্যাস", "হুমায়ূন আহমেদ", "90tk"));
        mItemListNovel.add(new ItemList(R.drawable.upo5, "মানব জমিন", "শীর্ষেন্দু মুখোপাধ্যায়", "600tk"));
        mItemListNovel.add(new ItemList(R.drawable.upo6, "যুগান্তরের ঘূর্ণিপাক\n ও \nবাংলাদেশের উপন্যাস", "যতীন সরকার", "100tk"));
        mItemListNovel.add(new ItemList(R.drawable.upo7, "উপন্যাস সমগ্র", "সঞ্জীব চটোপাধ্যায়", "90tk"));
        mItemListNovel.add(new ItemList(R.drawable.upo8, "সেরা সাত কিশোর \nউপন্যাস", "হুমায়ূন আহমেদ", "300tk"));
    }

    private void createHorrorItemList() {
        mItemListHorror = new ArrayList<>();
        mItemListHorror.add(new ItemList(R.drawable.hor, "ভূত সাবধান", "মশিউর রহমান", "100tk"));
        mItemListHorror.add(new ItemList(R.drawable.hor1, "আরেক ড্রাকুলা", "অনীশ দাস অপু", "120tk"));
        mItemListHorror.add(new ItemList(R.drawable.hor2, "এর জন্যে \nমানুষ কাদে", "শেখ আব্দুল হাকিম", "90tk"));
        mItemListHorror.add(new ItemList(R.drawable.hor3, "কিশোর হরর হানাবাড়ি", "অনীশ দাস অপু", "100tk"));
        mItemListHorror.add(new ItemList(R.drawable.hor4, "ভূতের সংসার", "দেলোয়ার হোসেন", "90tk"));
        mItemListHorror.add(new ItemList(R.drawable.hor5, "সেরা হরর গল্প", " নাফে মোহাম্মদ এনাম", "200tk"));
        mItemListHorror.add(new ItemList(R.drawable.hor6, "ভয়াঙ্ক দুঃস্বপ্ন", "রাকিব হাসান", "100tk"));
        mItemListHorror.add(new ItemList(R.drawable.hor7, "তান্ত্রিকের কবলে", "টিপু কিবরিয়া", "90tk"));
    }

    private void builtRecyclerViewIslam() {
        mTextView=findViewById(R.id.hedding);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mAdapter = new RecyclerViewAdapter(mItemListIslam);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

    }


    private void builtRecyclerViewNovel() {
        mTextView=findViewById(R.id.hedding3);
        mRecyclerView = findViewById(R.id.recyclerView3);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mAdapter = new RecyclerViewAdapter(mItemListNovel);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

    }

    private void builtRecyclerViewIslamHorror() {
        mRecyclerView = findViewById(R.id.recyclerView4);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mAdapter = new RecyclerViewAdapter(mItemListHorror);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

    }

    private void builtRecyclerViewPro() {
        mRecyclerView = findViewById(R.id.recyclerView2);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mAdapter = new RecyclerViewAdapter(mItemListPro);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);


    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.buttonN){
            Intent novel =new Intent(getApplicationContext(),DetailsActivity.class);
            String messege=mTextView.getText().toString();
            novel.putExtra("Hedding",messege);
            startActivityForResult(novel,NOVELALL);
        }else if(v.getId()==R.id.buttonI){
            Intent islamic=new Intent(getApplicationContext(),DetailsActivity.class);
            String messege=mTextView.getText().toString();
            islamic.putExtra("Hedding",messege);
            startActivityForResult(islamic,ISLAMICALL);
        }
    }
}