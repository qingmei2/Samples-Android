package com.mei_husky.sampleneterrorutil.model.util;

import android.util.Log;

import rx.Subscriber;

/**
 * Subscriber基类,可以在这里处理client网络连接状况
 * （比如没有wifi，没有4g，没有联网等）
 * Created by fcn-mq on 2017/4/19.
 */

public abstract class MySubscriber<T> extends Subscriber<T> {

    /*private Context context;

    public MySubscriber(Context context) {
        this.context = context;
    }*/

    @Override
    public void onStart() {
        super.onStart();
        Log.i("tag","MySubscriber.onStart()");
        //接下来可以检查网络连接等操作
        /*if (!NetworkUtil.isNetworkAvailable(context)) {

            Toast.makeText(context, "当前网络不可用，请检查网络情况", Toast.LENGTH_SHORT).show();
            // 一定好主动调用下面这一句
            onCompleted();

            return;
        }*/

    }

    public abstract void onError(ExceptionHandle.ResponeThrowable responeThrowable);

    @Override
    public void onError(Throwable e) {
        Log.e("tag","MySubscriber.throwable ="+e.toString());
        Log.e("tag","MySubscriber.throwable ="+e.getMessage());

        if(e instanceof Exception){
            //访问获得对应的Exception
            onError(ExceptionHandle.handleException(e));
        }else {
            //将Throwable 和 未知错误的status code返回
            onError(new ExceptionHandle.ResponeThrowable(e,ExceptionHandle.ERROR.UNKNOWN));
        }
    }

    @Override
    public void onCompleted() {
        Log.i("tag","MySubscriber.onComplete()");
    }
}
