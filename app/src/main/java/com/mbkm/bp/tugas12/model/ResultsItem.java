package com.mbkm.bp.tugas12.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultsItem {
    @SerializedName("overview")
    private String overview;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("video")
    private String video;

    @SerializedName("title")
    private String title;

    @SerializedName("genre_ids")
    private List<String> genreIds;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("popularity")
    private String popularity;

    @SerializedName("vote_average")
    private String voteAverage;

    @SerializedName("id")
    private String id;

    @SerializedName("adult")
    private String adult;

    @SerializedName("vote_count")
    private String voteCount;

    public void setOverview(String overview){
        this.overview = overview;
    }

    public String getOverview(){
        return overview;
    }

    public void setOriginalLanguage(String originalLanguage){
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalLanguage(){
        return originalLanguage;
    }

    public void setOriginalTitle(String originalTitle){
        this.originalTitle = originalTitle;
    }

    public String getOriginalTitle(){
        return originalTitle;
    }

    public void setVideo(String video){
        this.video = video;
    }

    public String isVideo(){
        return video;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setGenreIds(List<String> genreIds){
        this.genreIds = genreIds;
    }

    public List<String> getGenreIds(){
        return genreIds;
    }

    public void setPosterPath(String posterPath){
        this.posterPath = posterPath;
    }

    public String getPosterPath(){
        return posterPath;
    }

    public void setBackdropPath(String backdropPath){
        this.backdropPath = backdropPath;
    }

    public String getBackdropPath(){
        return backdropPath;
    }

    public void setReleaseDate(String releaseDate){
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate(){
        return releaseDate;
    }

    public void setPopularity(String popularity){
        this.popularity = popularity;
    }

    public String getPopularity(){
        return popularity;
    }

    public void setVoteAverage(String voteAverage){
        this.voteAverage = voteAverage;
    }

    public String getVoteAverage(){
        return voteAverage;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setAdult(String adult){
        this.adult = adult;
    }

    public String isAdult(){
        return adult;
    }

    public void setVoteCount(String voteCount){
        this.voteCount = voteCount;
    }

    public String getVoteCount(){
        return voteCount;
    }
}
