package com.mei_husky.sampleneterrorutil.model.api;


import com.mei_husky.sampleneterrorutil.common.ConstantsApi;
import com.mei_husky.sampleneterrorutil.model.bean.MovieTheatersModel;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by fcn-mq on 2017/4/14.
 * 豆瓣-电影-API
 */

public interface DoubanMovieService {

    /**
     * 200 OK
     *{
     *  "city" :城市名
     *  "title": "正在上映的电影-北京",
     *  "total": 39,    //总数
     *  "start": 0,     //从第几个开始获取
     *  "count": 20,    //请求的数量
     *  "subjects": [<Subject>, ...],
     *}
     * @return
     */
    @GET(ConstantsApi.douban_in_theaters)
    Observable<MovieTheatersModel> requestTheatersMovies(@Query("city") String city,
                                                                     @Query("count") Integer count,
                                                                     @Query("start") Integer start);

}
