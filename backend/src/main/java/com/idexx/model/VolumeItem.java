package com.idexx.model;

import java.io.Serializable;

public class VolumeItem implements Serializable {
    private String id;
    private VolumeInfo volumeInfo;
    private String type;

    public VolumeItem() {
        this.type = EntityType.Book.name();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public String getType() {
        return type;
    }

    public void setType(EntityType type) {
        this.type = type.name();
    }

    @Override
    public String toString() {
        return "VolumeItem{" +
                "id='" + id + '\'' +
                ", volumeInfo=" + volumeInfo +
                ", type=" + type +
                '}';
    }
}
