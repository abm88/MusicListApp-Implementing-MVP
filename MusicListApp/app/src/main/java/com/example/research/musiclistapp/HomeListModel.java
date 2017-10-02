package com.example.research.musiclistapp;

/**
 * Created by Research on 30/09/2017.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeListModel {

    @SerializedName("resultCount")
    @Expose
    private Integer resultCount;
    @SerializedName("results")
    @Expose
    private List<RockListModel> results = null;

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public List<RockListModel> getResults() {
        return results;
    }

    public void setResults(List<RockListModel> results) {
        this.results = results;
    }

}