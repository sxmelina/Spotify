/* package com.example.spotify.model;

public class Pjesma {
    private Long id;
    private String naziv;
    private String trajanje;
    private int godinaIzdanja;
    private Long albumId;


*/

package com.example.spotify.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Pjesma {
    private Long albumId;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;
    private String trajanje;
    private int godinaIzdanja;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Album album;

    public Pjesma(){}

    public Pjesma(Long id, String naziv, String trajanje, int godinaIzdanja, Long albumId) {
        this.id = id;
        this.naziv = naziv;
        this.trajanje = trajanje;
        this.godinaIzdanja = godinaIzdanja;
        this.albumId = albumId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) { this.naziv = naziv; }

    public String getTrajanje() { return trajanje; }
    public void setTrajanje(String trajanje) { this.trajanje = trajanje; }

    public int getGodinaIzdanja() { return godinaIzdanja; }
    public void setGodinaIzdanja(int godinaIzdanja) { this.godinaIzdanja = godinaIzdanja; }

    public Long getAlbumId() { return albumId; }
    public void setAlbumId(Long albumId) { this.albumId = albumId; }
}

