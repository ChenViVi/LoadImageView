package com.chenyuwei.loadimageview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

/**
 * Created by vivi on 2016/7/23.
 */
public class ImageLoader {

    public static void with(Context context, ImageView imageView, String url){
        Glide.with(context).load(url).error(new Options().getFailedRes()).into(imageView);
    }

    public static void with(Context context, ImageView imageView, String url, final ImageListener listener){
        Glide.with(context).load(url).error(new Options().getFailedRes()).into(new GlideDrawableImageViewTarget(imageView) {
            @Override
            public void onStart() {
                super.onStart();
                listener.onStart();
            }

            @Override
            public void onResourceReady(GlideDrawable drawable, GlideAnimation anim) {
                super.onResourceReady(drawable, anim);
                listener.onFinish();
            }

            @Override
            public void onLoadFailed(Exception e, Drawable errorDrawable) {
                super.onLoadFailed(e, errorDrawable);
                listener.onFailed();
            }
        });
    }

    public static void with(Context context, ImageView imageView, String url, final Options options){
        Glide.with(context).load(url).error(options.getFailedRes()).into(imageView);
    }

    public static void with(Context context, ImageView imageView, String url, final ImageListener listener, final Options options){
        Glide.with(context).load(url).error(options.getFailedRes()).into(new GlideDrawableImageViewTarget(imageView) {
            @Override
            public void onStart() {
                super.onStart();
                listener.onStart();
            }

            @Override
            public void onResourceReady(GlideDrawable drawable, GlideAnimation anim) {
                super.onResourceReady(drawable, anim);
                listener.onFinish();
            }

            @Override
            public void onLoadFailed(Exception e, Drawable errorDrawable) {
                super.onLoadFailed(e, errorDrawable);
                listener.onFailed();
            }
        });
    }

}
