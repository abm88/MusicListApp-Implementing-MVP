package com.example.research.musiclistapp.data.network.service;

import com.example.research.musiclistapp.data.network.service.API_Constants;
import com.example.research.musiclistapp.services.IRequestInterface;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Research on 30/09/2017.
 */

public class ConnectionService {

    static Retrofit retrofit;


    public static IRequestInterface getConnectionService(){

        retrofit = new Retrofit.Builder()
                .baseUrl(API_Constants.BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(IRequestInterface.class);
    }


}
