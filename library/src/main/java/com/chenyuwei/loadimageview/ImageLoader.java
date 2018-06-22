package com.chenyuwei.loadimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


public class ImageLoader implements ImageListener{

    private Context context;
    private GlideDrawableImageViewTarget target;
    private ArrayList<ImageListener> listeners = new ArrayList<>();
    private Options options;

    public ImageLoader(Context context, ImageView imageView){
        options = new Options();
        this.context = context;
        addListener(this);
        target = new GlideDrawableImageViewTarget(imageView) {
            public void onStart() {
                super.onStart();
                for (ImageListener listener : listeners) {
                    listener.onStart();
                }
            }

            @Override
            public void onResourceReady(GlideDrawable drawable, GlideAnimation anim) {
                super.onResourceReady(drawable, anim);
                for (ImageListener listener : listeners) {
                    listener.onFinish();
                }
            }

            public void onLoadFailed(Exception e, Drawable errorDrawable) {
                super.onLoadFailed(e, errorDrawable);
                for (ImageListener listener : listeners) {
                    listener.onFailed();
                }
            }
        };
    }

    public ImageLoader setFailedRes(int failedRes) {
        this.options.setFailedRes(failedRes);
        return this;
    }

    public ImageLoader setShape(Options.Shape shape){
        this.options.setShape(shape);
        return this;
    }

    public ImageLoader setOptions(Options options) {
        this.options = options;
        return this;
    }

    public void load(String url){
        switch(options.getShape()) {
            case DEFAULT:
                Glide.with(context.getApplicationContext()).load(url).into(target);
                break;
            case CIRCLE:
                Glide.with(context.getApplicationContext()).load(url).bitmapTransform(new CropCircleTransformation(context)).into(target);
                break;
            case ROUND:
                Glide.with(context.getApplicationContext()).load(url).bitmapTransform(new RoundedCornersTransformation(context,30,0, RoundedCornersTransformation.CornerType.ALL)).into(target);
        }
    }

    public void load(int resourceId){
        switch(options.getShape()) {
            case DEFAULT:
                Glide.with(context.getApplicationContext()).load(resourceId).into(target);
                break;
            case CIRCLE:
                Glide.with(context.getApplicationContext()).load(resourceId).bitmapTransform(new CropCircleTransformation(context)).into(target);
                break;
            case ROUND:
                Glide.with(context.getApplicationContext()).load(resourceId).bitmapTransform(new RoundedCornersTransformation(context,30,0, RoundedCornersTransformation.CornerType.ALL)).into(target);
        }
    }

    public void load(Bitmap bitmap){
        switch(options.getShape()) {
            case DEFAULT:
                Glide.with(context.getApplicationContext()).load(bitmap).into(target);
                break;
            case CIRCLE:
                Glide.with(context.getApplicationContext()).load(bitmap).bitmapTransform(new CropCircleTransformation(context)).into(target);
                break;
            case ROUND:
                Glide.with(context.getApplicationContext()).load(bitmap).bitmapTransform(new RoundedCornersTransformation(context,30,0, RoundedCornersTransformation.CornerType.ALL)).into(target);
        }
    }

    public ImageLoader addListener(ImageListener listener){
        listeners.add(listener);
        return this;
    }

    public ImageLoader removeListener(ImageListener listener){
        listeners.remove(listener);
        return this;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onFinish() {

    }

    @Override
    public void onFailed() {
        load(options.getFailedRes());
    }
}
