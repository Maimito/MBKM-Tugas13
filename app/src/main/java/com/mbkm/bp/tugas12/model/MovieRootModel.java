package com.mbkm.bp.tugas12.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieRootModel {
    @SerializedName("dates")
    private Dates dateList;

    @SerializedName("page")
    private String page;

    @SerializedName("total_pages")
    private String totalPages;

    @SerializedName("results")
    private List<ResultsItem> results;

    @SerializedName("total_results")
    private String totalResults;

    public Dates getDateList() {
        return dateList;
    }

    public void setDateList(Dates dateList) {
        this.dateList = dateList;
    }

    public void setPage(String page){
        this.page = page;
    }

    public String getPage(){
        return page;
    }

    public void setTotalPages(String totalPages){
        this.totalPages = totalPages;
    }

    public String getTotalPages(){
        return totalPages;
    }

    public void setResults(List<ResultsItem> results){
        this.results = results;
    }

    public List<ResultsItem> getResults(){
        return results;
    }

    public void setTotalResults(String totalResults){
        this.totalResults = totalResults;
    }

    public String getTotalResults(){
        return totalResults;
    }
}
