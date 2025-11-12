package com.example.spotify.model;
import jakarta.persistence.*;
import java.util.*;

@Table(name = "korisnici")
public class Korisnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "korisnik_likes",
            joinColumns = @JoinColumn(name = "korisnik_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id")
    )
    private Set<Album> likedAlbums = new HashSet<>();

    public Korisnik() {}

    public Korisnik(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Set<Album> getLikedAlbums() { return likedAlbums; }
    public void setLikedAlbums(Set<Album> likedAlbums) { this.likedAlbums = likedAlbums; }

    public void likeAlbum(Album album) { this.likedAlbums.add(album); }
    public void unlikeAlbum(Album album) { this.likedAlbums.remove(album); }
}
