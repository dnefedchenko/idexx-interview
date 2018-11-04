package com.idexx.controller;

import com.idexx.model.AlbumTrack;
import com.idexx.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/albums")
public class AlbumsController {
    private AlbumService albumService;

    @Autowired
    public AlbumsController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<AlbumTrack> getAlbums(@RequestParam(name = "term") String term,
                                      @RequestParam(name = "country", defaultValue = "UA") String country) {
        return this.albumService.getAlbums(term, country);
    }
}
