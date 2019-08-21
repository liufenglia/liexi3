package com.example.asus.liexi3;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by asus on 2019/8/21.
 */

public interface Apiserivce {
    String url="http://gank.io/api/";

    @GET("data/%E7%A6%8F%E5%88%A9/20/1")
    Observable<Fuli_Adager> getdata();
}
