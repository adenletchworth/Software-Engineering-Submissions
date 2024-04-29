package com.cpp.Entity.MusicStreaming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class RealSongServiceTest {

    private RealSongService service;
    private List<Song> songs;

    @BeforeEach
    void setUp() {
        songs = Arrays.asList(
            new Song("Hello", "Adele", "25", 240),
            new Song("Someone Like You", "Adele", "21", 223),
            new Song("Rolling in the Deep", "Adele", "21", 228)
        );
        service = new RealSongService(songs);
    }

    @Test
    void testSearchById() {
        assertEquals(songs.get(0), service.searchById(0));
        assertEquals(songs.get(1), service.searchById(1));
    }

    @Test
    void testSearchByTitle() {
        List<Song> result = service.searchByTitle("hello");
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals("hello", result.get(0).getTitle());
    }

    @Test
    void testSearchByAlbum() {
        List<Song> result = service.searchByAlbum("21");
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(song -> song.getAlbum().equalsIgnoreCase("21")));
    }
}
