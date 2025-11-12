
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
        Album a1 = new Album(1L, "Sredinom", "New age", 2000, "Dino Merlin", "https://dinomerlin.com/assets/photos/album/big/1626705594-sredinom.jpg");
        albumi.add(a1);
        Album a2 = new Album(2L, "Thriller", "Pop", 1982, "Michael Jackson","https://upload.wikimedia.org/wikipedia/en/5/55/Michael_Jackson_-_Thriller.png");
        albumi.add(a2);
        Album a3 = new Album(3L, "Pakt sa đavolom", "Rep", 2017, "Jala & Buba Corelli","https://upload.wikimedia.org/wikipedia/en/7/71/Pakt_s_djavolom.jpg");
        albumi.add(a3);
        Album a4 = new Album(4L, "1989", "Pop", 2014, "Taylor Swift","https://upload.wikimedia.org/wikipedia/en/f/f6/Taylor_Swift_-_1989.png");
        albumi.add(a4);

       //dino
        pjesme.add(new Pjesma(1L, "Godinama", "3:56", 2000, a1));
        pjesme.add(new Pjesma(2L, "Halima", "4:16", 2000, a1));
        // michael jackson
        pjesme.add(new Pjesma(5L, "Wanna Be Startin' Somethin'", "6:03", 1982, a2));
        pjesme.add(new Pjesma(6L, "Thriller", "5:57", 1982, a2));
        //jala
        pjesme.add(new Pjesma(3L, "22", "4:15", 2017, a3));
        pjesme.add(new Pjesma(4L, "Advokat", "4:32", 2017, a3));
        // Taylor
        pjesme.add(new Pjesma(7L, "Wonderland", "4:06", 2014, a4));
        pjesme.add(new Pjesma(8L, "New Romantics", "3:51", 2014, a4));

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