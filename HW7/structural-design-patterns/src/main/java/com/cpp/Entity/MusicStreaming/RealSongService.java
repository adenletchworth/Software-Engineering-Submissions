package com.cpp.Entity.MusicStreaming;

import java.util.List;
import java.util.stream.Collectors;

public class RealSongService implements SongService {
    private List<Song> songs;

    public RealSongService(List<Song> songs) {
        this.songs = songs;
    }

    private void simulateNetworkLatency() {
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException ignored) {}
    }

    @Override
    public Song searchById(Integer songID) {
        simulateNetworkLatency();
        return songs.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        simulateNetworkLatency();
        return songs.stream()
                    .filter(song -> song.getTitle().equalsIgnoreCase(title.toLowerCase()))
                    .collect(Collectors.toList());
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        simulateNetworkLatency();
        return songs.stream()
                    .filter(song -> song.getAlbum().equalsIgnoreCase(album))
                    .collect(Collectors.toList());
    }
}


