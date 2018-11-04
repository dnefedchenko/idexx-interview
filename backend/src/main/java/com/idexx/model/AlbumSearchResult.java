package com.idexx.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AlbumSearchResult implements Serializable {
    private List<AlbumTrack> results;

    public AlbumSearchResult() {
        this.results = new ArrayList<>();
    }

    public List<AlbumTrack> getResults() {
        return results;
    }

    public void setResults(List<AlbumTrack> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "AlbumSearchResult{" +
                "results=" + results +
                '}';
    }
}
