/* package com.example.spotify.model;

public class Pjesma {
    private Long id;
    private String naziv;
    private String trajanje;
    private int godinaIzdanja;
    private Long albumId;


*/

package com.example.spotify.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pjesma")
@Access(AccessType.FIELD)
public class Pjesma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;
    private String trajanje;
    private int godinaIzdanja;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;
    public Pjesma(){}

    public Pjesma(Long id, String naziv, String trajanje, int godinaIzdanja, Album album) {
        this.id = id;
        this.naziv = naziv;
        this.trajanje = trajanje;
        this.godinaIzdanja = godinaIzdanja;
        this.album = album;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) { this.naziv = naziv; }

    public String getTrajanje() { return trajanje; }
    public void setTrajanje(String trajanje) { this.trajanje = trajanje; }

    public int getGodinaIzdanja() { return godinaIzdanja; }
    public void setGodinaIzdanja(int godinaIzdanja) { this.godinaIzdanja = godinaIzdanja; }

    public Album getAlbum() { return album; }
    public void setAlbum(Album album) { this.album = album; }

    @Transient // nismo radili ali je za dobijanje id-a
    public Long getAlbumId() { return album != null ? album.getId() : null; }
}

