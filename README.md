# LoadImageView

代码风格简洁的、支持多种网络或本地图像资源的、可以设置形状的ImageView

## 下载Demo

[sample.apk](https://github.com/ChenViVi/LoadImageView/raw/master/display/sample.apk)

## 下载aar
[load-image-view-1.1.1.aar](https://github.com/ChenViVi/LoadImageView/raw/master/display/load-image-view-1.1.1.aar)

## 特性
使用WaveImageView来获得如下加载动画

 <img src="http://a3.qpic.cn/psb?/V11nMvcA1OpCIy/CMOMIEe7sFI.2SBaOLLmDDexFBMDhMx*4oiDtTH.9gw!/b/dLAAAAAAAAAA&bo=eAFMAgAAAAACBRY!&rf=viewer_4" width="40%">

设置选项来改变ImageView的形状

 <img src="http://p1.bqimg.com/4851/84e29ebf2918d776.png" width="40%">

## 用法

XML

```
<!--
             设置形状 app:shape
             设置加载图像的路径 app:load_src
             设置加载失败时显示的图像 app:failed_src
             -->
 <com.chenyuwei.loadimageview.LoadImageView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:scaleType="fitXY"
                app:shape="circle"
                app:load_src="http://i1.piimg.com/4851/126b8732dbd303cd.jpg"
                app:failed_src="@mipmap/ic_launcher"/>
```

加载不同种类的图像资源
```
loadImageView.load(R.mipmap.ic_launcher);
loadImageView.load(bitmap);
loadImageView.load("http://a.hiphotos.baidu.com/zhidao/pic/item/adaf2edda3cc7cd9f595fcf03d01213fb80e915b.jpg");
```

设置形状
```
loadImageView.setShape(Options.Shape.DEFAULT);
loadImageView.setShape(Options.Shape.CIRCLE);
loadImageView.setShape(Options.Shape.ROUND);
```

设置监听器和选项
```
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
                .setShape(Options.Shape.Round)
                .setFailedRes(R.mipmap.ic_launcher)
                .build());
```

设置默认图片，当加载失败时默认显示此图片
```
loadImageView.setDefaultImg(R.mipmap.ic_launcher);
```

使用ImageLoader来加载图片到ImageView或其他ImageView的子类
```
ImageLoader.with(this,imageView,"http://img0.imgtn.bdimg.com/it/u=1378161988,3289698924&fm=206&gp=0.jpg",
                 new Options.Builder()
                         .setShape(Options.Shape.DEFAULT)
                         .setFailedRes(R.mipmap.ic_launcher)
                         .build());
```