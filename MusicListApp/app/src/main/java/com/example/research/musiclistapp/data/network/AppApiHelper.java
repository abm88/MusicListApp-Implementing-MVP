package com.example.research.musiclistapp.data.network;

import com.example.research.musiclistapp.Result;
import com.example.research.musiclistapp.services.IRequestInterface;
import com.example.tae.moview_api.Services.reqInterface;
import com.example.tae.moview_api.data.network.service.ConnectionService;
import com.example.tae.moview_api.model.Movie_List_Model;

import io.reactivex.Observable;

/**
 * Created by AbdulBasit on 29/09/2017.
 */

public class AppApiHelper implements APIHelper {

    private IRequestInterface requestInterface;

    public AppApiHelper(requestInterface requestInterface) {
        this.requestInterface = ConnectionService.getConnectionService();
    }


    @Override
    public Observable<Result> resultObservable() {
        return requestInterface.getResultList();
    }
}

