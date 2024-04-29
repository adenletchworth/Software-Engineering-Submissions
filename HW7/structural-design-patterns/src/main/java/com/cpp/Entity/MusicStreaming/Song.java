package com.cpp.Entity.MusicStreaming;

public class Song {
    private String title;
    private String artist;
    private String album;
    private int durationSeconds;

    public Song(String title, String artist, String album, int durationSeconds) {
        this.title = title.toLowerCase(); 
        this.artist = artist.toLowerCase();
        this.album = album.toLowerCase();
        this.durationSeconds = durationSeconds;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getDuration() {
        return durationSeconds;
    }

    @Override
    public String toString() {
        return "Song{" +
               "title='" + title + '\'' +
               ", artist='" + artist + '\'' +
               ", album='" + album + '\'' +
               ", duration=" + durationSeconds +
               '}';
    }
}
