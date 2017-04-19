package com.mei_husky.sampleneterrorutil;

import android.util.Log;

import com.mei_husky.sampleneterrorutil.model.bean.MovieTheatersModel;
import com.mei_husky.sampleneterrorutil.model.manager.MovieApiManager;
import com.mei_husky.sampleneterrorutil.model.util.ExceptionHandle;
import com.mei_husky.sampleneterrorutil.model.util.MySubscriber;

import org.junit.Test;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fcn-mq on 2017/4/19.
 */

public class ApiTest {

    @Test
    public void MovieTest() throws Exception {
        MovieApiManager apiManager = new MovieApiManager();
        apiManager.getTheatersMovie("成都", 1, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySubscriber<MovieTheatersModel>() {

                    @Override
                    public void onError(ExceptionHandle.ResponeThrowable responeThrowable) {
                        Log.e("tag", "MovieApiTest失败！");
                        Log.e("tag", "responeThrowable.code=" + responeThrowable.code);
                        Log.e("tag", "responeThrowable.message=" + responeThrowable.message);
                    }

                    @Override
                    public void onNext(MovieTheatersModel movieTheatersModel) {
                        Log.i("tag", "MovieApiTest成功！");
                        Log.i("tag", "movieTheatersModel =" + movieTheatersModel.toString());
                    }

                });
        Thread.sleep(Long.MAX_VALUE);
    }
}
