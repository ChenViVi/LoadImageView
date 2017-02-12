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
public class LoadImageView extends ImageView implements ImageListener {
    private Context context;
    private String url;
    private int resourceId;
    private ImageListener listener;
    private Options options = new Options();

    public LoadImageView(Context context) {
        super(context);
        this.context = context;
    }

    public LoadImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.LoadImageView);
        options.setFailedRes(a.getResourceId(R.styleable.LoadImageView_failed_src,R.drawable.img_default));
        switch (a.getInt(R.styleable.LoadImageView_shape,-1)){
            case 0:
                options.setShape(Options.Shape.DEFAULT);
                break;
            case 1:
                options.setShape(Options.Shape.CIRCLE);
                break;
            case 2:
                options.setShape(Options.Shape.ROUND);
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

    public void load(String url) {
        this.url = url;
        ImageLoader.with(this.context, this, url, this,options);
    }

    public void load(int resourceId) {
        this.resourceId = resourceId;
        ImageLoader.with(this.context, this, resourceId, this, options);
    }

    public void load(Bitmap bitmap) {
        ImageLoader.with(this.context, this, bitmap, this, options);
    }

    public void load(String url, ImageListener listener) {
        this.url = url;
        this.listener = listener;
        ImageLoader.with(this.context, this, url, this);
    }

    public void load(int resourceId, ImageListener listener) {
        this.resourceId = resourceId;
        this.listener = listener;
        ImageLoader.with(this.context, this, resourceId, this);
    }

    public void load(Bitmap bitmap, ImageListener listener) {
        this.listener = listener;
        ImageLoader.with(this.context, this, bitmap, this);
    }

    public void load(String url, Options options) {
        this.url = url;
        ImageLoader.with(this.context, this, url, this, options);
    }

    public void load(int resourceId, Options options) {
        this.resourceId = resourceId;
        ImageLoader.with(this.context, this, resourceId, this, options);
    }

    public void load(Bitmap bitmap, Options options) {
        ImageLoader.with(this.context, this, bitmap, this, options);
    }

    public void load(String url, ImageListener listener, Options options) {
        this.url = url;
        this.listener = listener;
        ImageLoader.with(this.context, this, url, this, options);
    }

    public void load(int resourceId, ImageListener listener, Options options) {
        this.resourceId = resourceId;
        this.listener = listener;
        ImageLoader.with(this.context, this, resourceId, this, options);
    }

    public void load(Bitmap bitmap, ImageListener listener, Options options) {
        this.listener = listener;
        ImageLoader.with(this.context, this, bitmap, this, options);
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public void setShaple(Options.Shape shape) {
        this.options.setShape(shape);
    }

    public void setDefaultImg(int failedRes) {
        this.options.setFailedRes(failedRes);
    }

    public void onStart() {
        if(this.listener != null) {
            this.listener.onStart();
        }
    }

    public void onFinish() {
        if(this.listener != null) {
            this.listener.onFinish();
        }
    }

    public void onFailed() {
        Log.e("LoadImageViewFailed", "url= " + this.url);
        if(this.listener != null) {
            this.listener.onFailed();
        }
    }
}
