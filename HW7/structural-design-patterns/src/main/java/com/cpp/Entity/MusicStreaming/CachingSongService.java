package com.cpp.Entity.MusicStreaming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CachingSongService implements SongService {
    private RealSongService realService;
    private Map<Integer, Song> idCache = new HashMap<>();
    private Map<String, List<Song>> titleCache = new HashMap<>();
    private Map<String, List<Song>> albumCache = new HashMap<>();

    public CachingSongService(RealSongService realService) {
        this.realService = realService;
    }

    @Override
    public Song searchById(Integer songID) {
        if (!idCache.containsKey(songID)) {
            idCache.put(songID, realService.searchById(songID));
        }
        return idCache.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if (!titleCache.containsKey(title.toLowerCase())) {
            titleCache.put(title.toLowerCase(), realService.searchByTitle(title));
        }
        return titleCache.get(title.toLowerCase());
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if (!albumCache.containsKey(album.toLowerCase())) {
            albumCache.put(album.toLowerCase(), realService.searchByAlbum(album));
        }
        return albumCache.get(album.toLowerCase());
    }
}

