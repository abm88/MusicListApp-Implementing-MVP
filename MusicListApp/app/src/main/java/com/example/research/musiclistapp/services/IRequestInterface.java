package com.example.research.musiclistapp.services;

import com.example.research.musiclistapp.data.network.service.API_Constants;
import com.example.research.musiclistapp.Result;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Research on 30/09/2017.
 */

public interface IRequestInterface {

    @GET(API_Constants.CLASSIC_LIST_API)
    Observable<Result> getResultList();

}
