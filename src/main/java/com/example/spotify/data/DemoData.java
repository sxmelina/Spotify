package com.example.spotify.data;

import com.example.spotify.model.Album;
import com.example.spotify.model.Pjesma;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DemoData {

    private List<Album> albumi = new ArrayList<>();
    private List<Pjesma> pjesme = new ArrayList<>();

    public DemoData() {
        // Kreiranje albuma
        albumi.add(new Album(1L, "The Dark Side of the Moon", "Progressive Rock", 1973, "Pink Floyd"));
        albumi.add(new Album(2L, "Thriller", "Pop", 1982, "Michael Jackson"));
        albumi.add(new Album(3L, "Back in Black", "Hard Rock", 1980, "AC/DC"));
        albumi.add(new Album(4L, "Abbey Road", "Rock", 1969, "The Beatles"));

        // Kreiranje pjesama
        // Pink Floyd - The Dark Side of the Moon
        pjesme.add(new Pjesma(1L, "Speak to Me", "1:13", 1973, 1L));
        pjesme.add(new Pjesma(2L, "Breathe", "2:43", 1973, 1L));
        pjesme.add(new Pjesma(3L, "Time", "6:53", 1973, 1L));
        pjesme.add(new Pjesma(4L, "Money", "6:23", 1973, 1L));

        // Michael Jackson - Thriller
        pjesme.add(new Pjesma(5L, "Wanna Be Startin' Somethin'", "6:03", 1982, 2L));
        pjesme.add(new Pjesma(6L, "Thriller", "5:57", 1982, 2L));
        pjesme.add(new Pjesma(7L, "Beat It", "4:18", 1982, 2L));
        pjesme.add(new Pjesma(8L, "Billie Jean", "4:54", 1982, 2L));

        // AC/DC - Back in Black
        pjesme.add(new Pjesma(9L, "Hells Bells", "5:12", 1980, 3L));
        pjesme.add(new Pjesma(10L, "Back in Black", "4:15", 1980, 3L));
        pjesme.add(new Pjesma(11L, "You Shook Me All Night Long", "3:30", 1980, 3L));

        // The Beatles - Abbey Road
        pjesme.add(new Pjesma(12L, "Come Together", "4:20", 1969, 4L));
        pjesme.add(new Pjesma(13L, "Something", "3:03", 1969, 4L));
        pjesme.add(new Pjesma(14L, "Here Comes the Sun", "3:05", 1969, 4L));
    }

    public List<Album> getAlbumi() {
        return albumi;
    }

    public List<Pjesma> getPjesme() {
        return pjesme;
    }

    public Album getAlbumById(Long id) {
        for (Album album : albumi) {
            if (album.getId().equals(id)) {
                return album;
            }
        }
        return null;
    }
}