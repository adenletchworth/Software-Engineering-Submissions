package com.cpp.Entity.MusicStreaming;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;

class CachingSongServiceTest {

    @Mock
    private RealSongService realService;

    private CachingSongService cachingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cachingService = new CachingSongService(realService);
    }

    @Test
    void testSearchByTitleCaseInsensitivity() {
        String titleLower = "hello";
        String titleUpper = "HELLO";
        List<Song> expectedSongs = Arrays.asList(new Song(titleLower, "Adele", "Album", 300));

        when(realService.searchByTitle(anyString())).thenReturn(expectedSongs);

        List<Song> resultLower = cachingService.searchByTitle(titleLower);
        List<Song> resultUpper = cachingService.searchByTitle(titleUpper);

        verify(realService, times(1)).searchByTitle(titleLower);
        assertIterableEquals(expectedSongs, resultLower);
        assertIterableEquals(expectedSongs, resultUpper);
    }

    @Test
    void testSearchByAlbumCacheFunctionality() {
        String album = "album";
        List<Song> expectedSongs = Arrays.asList(new Song("Song", "Artist", album, 250));

        when(realService.searchByAlbum(album.toLowerCase())).thenReturn(expectedSongs);

        List<Song> result1 = cachingService.searchByAlbum(album);
        List<Song> result2 = cachingService.searchByAlbum("ALBUM");

        verify(realService, times(1)).searchByAlbum(album.toLowerCase()); 
        assertIterableEquals(expectedSongs, result1);
        assertIterableEquals(expectedSongs, result2);
    }
}
