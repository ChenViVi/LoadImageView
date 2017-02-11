package com.chenyuwei.loadimageview;


/**
 * Created by vivi on 2016/7/23.
 */
public class Options {
    private int failedRes;
    private Options.Shape shape;

    public Options() {
        this.failedRes = R.drawable.img_default;
        this.shape = Options.Shape.DEFAULT;
    }

    public Options(Options.Builder builder) {
        this.failedRes = R.drawable.img_default;
        this.shape = Options.Shape.DEFAULT;
        this.failedRes = builder.failedRes;
        this.shape = builder.shape;
    }

    public void setShape(Options.Shape shape) {
        this.shape = shape;
    }

    public void setFailedRes(int failedRes) {
        this.failedRes = failedRes;
    }

    public int getFailedRes() {
        return this.failedRes;
    }

    public Options.Shape getShape() {
        return this.shape;
    }

    public static class Builder {
        private int failedRes;
        private Options.Shape shape;

        public Builder() {
            this.failedRes = R.drawable.img_default;
            this.shape = Options.Shape.DEFAULT;
        }

        public Options.Builder setFailedRes(int failedRes) {
            this.failedRes = failedRes;
            return this;
        }

        public Options.Builder setShape(Options.Shape shape) {
            this.shape = shape;
            return this;
        }

        public Options build() {
            return new Options(this);
        }
    }

    public enum Shape {
        DEFAULT,
        CIRCLE,
        ROUND
    }
}