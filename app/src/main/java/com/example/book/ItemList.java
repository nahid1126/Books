package com.example.book;

public class ItemList {
    private int mImageResource;
    private String mBookNameText;
    private String mAuthorText;
    private String mPrice;

    public ItemList(int mImageResource, String mBookNameText, String mAuthorText, String mPrice) {
        this.mImageResource = mImageResource;
        this.mBookNameText = mBookNameText;
        this.mAuthorText = mAuthorText;
        this.mPrice = mPrice;
    }
    public int getmImageResource() {
        return mImageResource;
    }

    public String getmBookNameText() {
        return mBookNameText;
    }

    public String getmAuthorText() {
        return mAuthorText;
    }

    public String getmPrice() {
        return mPrice;
    }
}
