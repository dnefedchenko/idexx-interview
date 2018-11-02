package com.idexx.model;

import java.util.ArrayList;
import java.util.List;

public class VolumeInfo {
    private String title;
    private List<String> authors;

    public VolumeInfo() {
        this.authors = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "VolumeInfo{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                '}';
    }
}
