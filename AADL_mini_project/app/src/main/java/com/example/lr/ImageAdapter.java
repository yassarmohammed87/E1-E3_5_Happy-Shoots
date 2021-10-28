package com.example.lr;

//package com.example.gallerydemo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    public int[] imageArray = {
            R.drawable.i1,R.drawable.i2,
            R.drawable.i3, R.drawable.i4,
            R.drawable.i5,R.drawable.i6,
            R.drawable.i7,R.drawable.i8,
            R.drawable.i9,R.drawable.i10,
            R.drawable.i11,R.drawable.i12,
            R.drawable.i13, R.drawable.i14,
            R.drawable.i15, R.drawable.i16,
            R.drawable.i17
    };

    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int i) {
        return imageArray[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(imageArray[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(340,350));
        return imageView;
    }
}