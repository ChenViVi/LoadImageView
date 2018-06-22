package com.chenyuwei.loadimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by vivi on 2016/7/23.
 */
public class LoadImageView extends ImageView {

    private ImageLoader imageLoader;

    public LoadImageView(Context context) {
        super(context);
        imageLoader = new ImageLoader(context, this);
    }

    public LoadImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        imageLoader = new ImageLoader(context, this);
        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.LoadImageView);
        imageLoader.setFailedRes(a.getResourceId(R.styleable.LoadImageView_failed_src,R.drawable.img_default));
        switch (a.getInt(R.styleable.LoadImageView_shape,-1)){
            case 0:
                imageLoader.setShape(Options.Shape.DEFAULT);
                break;
            case 1:
                imageLoader.setShape(Options.Shape.CIRCLE);
                break;
            case 2:
                imageLoader.setShape(Options.Shape.ROUND);
                break;
        }
        if (a.getString(R.styleable.LoadImageView_load_src) != null){
            load(a.getString(R.styleable.LoadImageView_load_src));
        }
        a.recycle();
    }

    public LoadImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void load(final String url) {
        imageLoader.load(url);
        addListener(new ImageListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onFinish() {

            }

            @Override
            public void onFailed() {
                Log.e("LoadImageViewFailed", "url= " + url);
            }
        });
    }

    public LoadImageView load(int resourceId) {
        imageLoader.load(resourceId);
        return this;
    }

    public LoadImageView load(Bitmap bitmap) {
        imageLoader.load(bitmap);
        return this;
    }

    public LoadImageView addListener(ImageListener listener){
        imageLoader.addListener(listener);
        return this;
    }

    public LoadImageView removeListener(ImageListener listener){
        imageLoader.removeListener(listener);
        return this;
    }


    public LoadImageView setOptions(Options options) {
        imageLoader.setOptions(options);
        return this;
    }

    public LoadImageView setShape(Options.Shape shape) {
        imageLoader.setShape(shape);
        return this;
    }

    public LoadImageView setFailedRes(int failedRes) {
        imageLoader.setFailedRes(failedRes);
        return this;
    }
}
