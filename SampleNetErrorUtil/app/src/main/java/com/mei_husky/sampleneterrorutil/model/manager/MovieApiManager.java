package com.mei_husky.sampleneterrorutil.model.manager;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.mei_husky.sampleneterrorutil.common.Constants;
import com.mei_husky.sampleneterrorutil.common.ConstantsApi;
import com.mei_husky.sampleneterrorutil.model.api.DoubanMovieService;
import com.mei_husky.sampleneterrorutil.model.bean.MovieTheatersModel;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by fcn-mq on 2017/4/14.
 */

public class MovieApiManager {

    private DoubanMovieService movieService;

    public MovieApiManager() {
        init();
    }

    private void init() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        if (Constants.debug) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor).addNetworkInterceptor(new StethoInterceptor());
        }
        OkHttpClient client = builder.build();

        movieService = new Retrofit.Builder()
                .baseUrl(ConstantsApi.BASE_DOUBAN)
//                .addConverterFactory(FastJsonConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()
                .create(DoubanMovieService.class);
    }

    /**
     * 获取正在上映的电影信息
     * @param city 上映的城市
     * @param count 要获取的电影数量
     * @param start 从第几个开始（分页功能使用）
     * @return
     */
    public Observable<MovieTheatersModel> getTheatersMovie(String city, Integer count, Integer start) {
        return movieService.requestTheatersMovies(city, count, start);
    }

    /**
     * 获取默认城市（北京）所有上映电影
     * @return
     */
    public Observable<MovieTheatersModel> getAllTheatersMovie() {
        return getTheatersMovie(null, null, null);
    }

    /**
     * 获取某座城市所有正在上映电影
     * @param city 上映的城市
     * @return
     */
    public Observable<MovieTheatersModel> getAllTheatersMovie(String city) {
        return getTheatersMovie(city, null, null);
    }



}
