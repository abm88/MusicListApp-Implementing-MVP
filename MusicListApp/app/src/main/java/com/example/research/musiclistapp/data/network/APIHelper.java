package com.example.research.musiclistapp.data.network;

import com.example.research.musiclistapp.Result;
import com.example.tae.moview_api.model.Movie_List_Model;

import io.reactivex.Observable;

/**
 * Created by AbdulBasit on 29/09/2017.
 */

public interface APIHelper {
    Observable<Result> useCaseResulList();
}
