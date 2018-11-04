package com.idexx.model;

import java.io.Serializable;

public class AlbumTrack implements Serializable {
    private String trackName;
    private String artistName;
    private String type;

    public AlbumTrack() {
        this.type = EntityType.Album.name();
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AlbumTrack{" +
                "trackName='" + trackName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
