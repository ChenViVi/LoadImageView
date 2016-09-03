# LoadImageView

## Features
Using WaveImageView to enable wave animator while loading.

 <img src="http://a3.qpic.cn/psb?/V11nMvcA1OpCIy/CMOMIEe7sFI.2SBaOLLmDDexFBMDhMx*4oiDtTH.9gw!/b/dLAAAAAAAAAA&bo=eAFMAgAAAAACBRY!&rf=viewer_4" width="60%">

Set options to choose different shapes.

 <img src="http://a2.qpic.cn/psb?/V11nMvcA1OpCIy/KlNUEzXD.CBsHjD4ep5KuOcSMTeoaqidjfgxoJTrkfM!/b/dKYAAAAAAAAA&bo=hgFaAgAAAAACB*w!&rf=viewer_4" width="60%">

## Usage
Simple use
```
loadImageView.setShape(Options.Shape.Circle);
loadImageView.load(R.mipmap.ic_launcher);
loadImageView.load(bitmap);
loadImageView.load("http://a.hiphotos.baidu.com/zhidao/pic/item/adaf2edda3cc7cd9f595fcf03d01213fb80e915b.jpg");
```


Load into imageView
 ```
 ImageLoader.with(this,imageView,"http://img0.imgtn.bdimg.com/it/u=1378161988,3289698924&fm=206&gp=0.jpg",
                 new Options.Builder()
                         .setShape(Options.Shape.DEFAULT)
                         .build());
 ```

 Load into LoadImageView or WaveImageView
 ```
 <com.chenyuwei.loadimageview.LoadImageView
      android:id="@+id/imageView"
      android:layout_width="match_parent"
      android:layout_height="match_parent"/>

<com.chenyuwei.loadimageview.WaveImageView
      android:id="@+id/waveImageView"
      android:layout_width="match_parent"
      android:layout_height="match_parent"/>
 ```

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
