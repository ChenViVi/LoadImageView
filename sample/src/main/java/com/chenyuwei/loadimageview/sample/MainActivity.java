package com.chenyuwei.loadimageview.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.chenyuwei.loadimageview.ImageListener;
import com.chenyuwei.loadimageview.ImageLoader;
import com.chenyuwei.loadimageview.LoadImageView;
import com.chenyuwei.loadimageview.Options;
import com.chenyuwei.loadimageview.WaveImageView;


public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private LoadImageView loadImageView;
    private WaveImageView waveImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        loadImageView = (LoadImageView) findViewById(R.id.loadImageView);
        waveImageView = (WaveImageView) findViewById(R.id.waveImageView);


        /**
         * ImageView in Shape.DEFAULT
         * */
        ImageLoader.with(this,imageView,"http://img0.imgtn.bdimg.com/it/u=1378161988,3289698924&fm=206&gp=0.jpg",
                new Options.Builder()
                        .setShape(Options.Shape.DEFAULT)
                        .build());

        /**
         * LoadImageView in Shape.Circle
         * */
        loadImageView.load("http://img4.duitang.com/uploads/blog/201403/21/20140321130651_at3yv.thumb.600_0.jpeg",new Options.Builder()
                .setShape(Options.Shape.CIRCLE)
                .build());

        /**
         * WaveImageView in Shape.ROUND
         * */
        waveImageView.load("http://a.hiphotos.baidu.com/zhidao/pic/item/adaf2edda3cc7cd9f595fcf03d01213fb80e915b.jpg", new ImageListener() {
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
        },new Options.Builder()
                .setShape(Options.Shape.ROUND)
                .setFailedRes(R.mipmap.ic_launcher)
                .build());
    }
}
