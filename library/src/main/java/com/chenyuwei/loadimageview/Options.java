package com.chenyuwei.loadimageview;


/**
 * Created by vivi on 2016/7/23.
 */
public class Options{

    private int failedRes = R.drawable.img_default;

    public Options(){

    }

    public Options(Options.Builder builder){
        this.failedRes = builder.failedRes;
    }

    public static class Builder {

        private int failedRes = R.drawable.img_default;

        public Options.Builder setFailedRes(int failedRes) {
            this.failedRes = failedRes;
            return this;
        }

        public Options build() {
            return new Options(this);
        }
    }

    public int getFailedRes() {
        return failedRes;
    }

}
