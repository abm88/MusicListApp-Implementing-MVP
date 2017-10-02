package com.example.research.musiclistapp.data;

import com.example.tae.moview_api.data.network.APIHelper;
import com.example.tae.moview_api.model.Movie_List_Model;

import io.reactivex.Observable;

/**
 * Created by AbdulBasit on 29/09/2017.
 */

public class AppDataManager implements DataManager {
    private APIHelper apiHelper;

    public AppDataManager() {
        this.apiHelper = apiHelper;
    }

  //  @Override
    public Observable<Movie_List_Model> useCaseMovieList() {
        return apiHelper.useCaseMovieList();

    }


}
