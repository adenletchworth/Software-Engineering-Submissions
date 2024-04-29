package com.cpp;

import java.util.Arrays;
import java.util.List;

import com.cpp.Entity.MusicStreaming.CachingSongService;
import com.cpp.Entity.MusicStreaming.RealSongService;
import com.cpp.Entity.MusicStreaming.Song;
import com.cpp.Entity.MusicStreaming.SongService;

public class MusicStreamingDriver {
    public static void main(String[] args) {
        List<Song> songs = Arrays.asList(
            new Song("Song1", "Artist1", "Album1", 200),
            new Song("Song2", "Artist2", "Album2", 201),
            new Song("Song3", "Artist2", "Album2", 202),
            new Song("Song4", "Artist3", "Album3", 203),
            new Song("Song5", "Artist3", "Album4", 204),
            new Song("Song6", "Artist4", "Album5", 205),
            new Song("Song7", "Artist4", "Album6", 206),
            new Song("Song8", "Artist1", "Album7", 207),
            new Song("Song9", "Artist5", "Album8", 208),
            new Song("Song10", "Artist6", "Album9", 209)

        );

        RealSongService realService = new RealSongService(songs);
        CachingSongService cachingService = new CachingSongService(realService);

        performSearch(cachingService);
    }

    private static void performSearch(SongService service) {
        System.out.println("Searching by title 'Song1':");
        printSongs(service.searchByTitle("Song1"));
    
        System.out.println("Searching by title 'Song10':");
        printSongs(service.searchByTitle("Song10"));
    
        System.out.println("Repeating search by title 'Song1' to demonstrate caching:");
        printSongs(service.searchByTitle("Song1"));
    
        System.out.println("Searching by album 'Album9':");
        printSongs(service.searchByAlbum("Album9"));
    
        System.out.println("Repeating search by album 'Album9' to demonstrate caching:");
        printSongs(service.searchByAlbum("Album9"));
    }
    

    private static void printSongs(List<Song> songs) {
        if (songs.isEmpty()) {
            System.out.println("No songs found.");
        } else {
            for (Song song : songs) {
                System.out.println(song);
            }
        }
    }
    
}
