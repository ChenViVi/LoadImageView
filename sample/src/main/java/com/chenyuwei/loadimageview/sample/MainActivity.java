package com.chenyuwei.loadimageview.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.chenyuwei.loadimageview.ImageListener;
import com.chenyuwei.loadimageview.ImageLoader;
import com.chenyuwei.loadimageview.LoadImageView;
import com.chenyuwei.loadimageview.Options;
import com.chenyuwei.loadimageview.WaveImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        LoadImageView loadImageView = findViewById(R.id.loadImageView);
        WaveImageView waveImageView = findViewById(R.id.waveImageView);
        LoadImageView loadImageView2 = findViewById(R.id.loadImageView2);

        /**
         * ImageView in Shape.DEFAULT
         * */
        ImageLoader imageLoader = new ImageLoader(this, imageView);
        imageLoader.setShape(Options.Shape.DEFAULT)
                .load("http://img0.imgtn.bdimg.com/it/u=1378161988,3289698924&fm=206&gp=0.jpg");

        /**
         * LoadImageView in Shape.Circle
         * */
        loadImageView.setShape(Options.Shape.CIRCLE)
                .load("http://img4.duitang.com/uploads/blog/201403/21/20140321130651_at3yv.thumb.600_0.jpeg");

        /**
         * WaveImageView in Shape.ROUND
         * */
        waveImageView.addListener(new ImageListener() {
            @Override
            public void onStart() {
                Log.e("waveImageView","onStart");
            }

            @Override
            public void onFinish() {
                Log.e("waveImageView","onFinish");
            }

            @Override
            public void onFailed() {
                Log.e("waveImageView","onFailed");
            }
        }).load("http://a.hiphotos.baidu.com/zhidao/pic/item/adaf2edda3cc7cd9f595fcf03d01213fb80e915b.jpg");

        loadImageView2.setShape(Options.Shape.CIRCLE)
                .setFailedRes(R.drawable.globe)
                .load("invalid link");
    }
}
