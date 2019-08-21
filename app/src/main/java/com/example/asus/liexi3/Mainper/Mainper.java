package com.example.asus.liexi3.Mainper;

import com.example.asus.liexi3.Fuli_Adager;
import com.example.asus.liexi3.Mainmodel.Mainmodel;
import com.example.asus.liexi3.Mainview.Mainview;

import java.util.ArrayList;

/**
 * Created by asus on 2019/8/21.
 */

public class Mainper implements Mainmodel.LoadAll{

    private Mainview mainview;
    private Mainmodel mainmodel;

    public Mainper(Mainview mainview) {
        this.mainview = mainview;
        this.mainmodel = new Mainmodel();
    }

    public void Call(){
        mainmodel.LoadCall(this);
    }


    @Override
    public void getdata(ArrayList<Fuli_Adager.ResultsBean> results) {
        mainview.setdata(results);
    }

    @Override
    public void getter(String str) {
        mainview.setter(str);
    }
}
