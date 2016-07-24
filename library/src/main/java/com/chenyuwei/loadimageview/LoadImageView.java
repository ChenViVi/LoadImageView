package com.chenyuwei.loadimageview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by vivi on 2016/7/23.
 */
public class LoadImageView extends ImageView implements ImageListener{

    private Context context;
    private ImageListener listener;

    public LoadImageView(Context context) {
        super(context);
        this.context = context;
    }

    public LoadImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public LoadImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void load(String url){
        ImageLoader.with(context,this,url);
    }

    public void load(String url, ImageListener listener){
        this.listener = listener;
        ImageLoader.with(context, this, url, this);
    }

    public void load(String url, Options options){
        ImageLoader.with(context, this, url, this, options);
    }

    public void load(String url, ImageListener listener,Options options){
        this.listener = listener;
        ImageLoader.with(context, this, url, this, options);
    }

    @Override
    public void onStart() {
        if (listener != null){
            listener.onStart();
        }
    }

    @Override
    public void onFinish() {
        if (listener != null){
            listener.onFinish();
        }
    }

    @Override
    public void onFailed() {
        if (listener != null){
            listener.onFailed();
        }
    }
}
