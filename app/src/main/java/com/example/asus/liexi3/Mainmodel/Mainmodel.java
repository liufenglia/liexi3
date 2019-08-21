package com.example.asus.liexi3.Mainmodel;

import com.example.asus.liexi3.Apiserivce;
import com.example.asus.liexi3.Fuli_Adager;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by asus on 2019/8/21.
 */

public class Mainmodel {


    public void LoadCall(final LoadAll loadAll){
        Retrofit build = new Retrofit.Builder()
                .baseUrl(Apiserivce.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Apiserivce apiserivce = build.create(Apiserivce.class);
        Observable<Fuli_Adager> getdata = apiserivce.getdata();
        getdata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Fuli_Adager>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Fuli_Adager fuli_adager) {
                        ArrayList<Fuli_Adager.ResultsBean> results = (ArrayList<Fuli_Adager.ResultsBean>) fuli_adager.getResults();
                        loadAll.getdata(results);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loadAll.getter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public interface LoadAll {
        void getdata(ArrayList<Fuli_Adager.ResultsBean> results);
        void getter(String str);
    }
}
