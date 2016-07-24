package com.chenyuwei.loadimageview;


/**
 * Created by vivi on 2016/7/23.
 */
public class Options{

    private int failedRes = R.drawable.img_default;
    private Shape shape = Shape.DEFAULT;

    public Options(){

    }

    public Options(Options.Builder builder){
        this.failedRes = builder.failedRes;
        this.shape = builder.shape;
    }

    public int getFailedRes() {
        return failedRes;
    }

    public Shape getShape() {
        return shape;
    }

    public enum Shape {
        DEFAULT,Circle,Round
    }

    public static class Builder {

        private int failedRes = R.drawable.img_default;
        private Shape shape = Shape.DEFAULT;

        public Options.Builder setFailedRes(int failedRes) {
            this.failedRes = failedRes;
            return this;
        }

        public Options.Builder setShape(Shape shape) {
            this.shape = shape;
            return this;
        }

        public Options build() {
            return new Options(this);
        }
    }
}
