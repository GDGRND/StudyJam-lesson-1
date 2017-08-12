package ru.webant.studyjam.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dst on 05.08.17.
 */

public class NewsFormat {

    private String copyright;
    @SerializedName("last_updated")
    private Date lastUpdate;
    @SerializedName("num_results")
    private int numResult;
    private ArrayList<Article> results;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getNumResult() {
        return numResult;
    }

    public void setNumResult(int numResult) {
        this.numResult = numResult;
    }

    public ArrayList<Article> getResults() {
        return results;
    }

    public void setResults(ArrayList<Article> results) {
        this.results = results;
    }
}
