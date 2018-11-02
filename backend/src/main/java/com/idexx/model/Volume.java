package com.idexx.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Volume implements Serializable {
    private List<VolumeItem> items;

    public Volume() {
        items = new ArrayList<>();
    }

    public List<VolumeItem> getItems() {
        return items;
    }

    public void setItems(List<VolumeItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Volume{" +
                "items=" + items +
                '}';
    }
}
