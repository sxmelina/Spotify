package com.example.spotify.model;

public class Album {
    private Long id;
    private String naziv;
    private String zanr;
    private int godinaIzdanja;
    private String izvodjac;
    private String slika;

    public Album(Long id, String naziv, String zanr, int godinaIzdanja, String izvodjac, String slika) {
        this.id = id;
        this.naziv = naziv;
        this.zanr = zanr;
        this.godinaIzdanja = godinaIzdanja;
        this.izvodjac = izvodjac;
        this.slika = slika;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) { this.naziv = naziv; }

    public String getZanr() { return zanr; }
    public void setZanr(String zanr) { this.zanr = zanr; }

    public int getGodinaIzdanja() { return godinaIzdanja; }
    public void setGodinaIzdanja(int godinaIzdanja) { this.godinaIzdanja = godinaIzdanja; }

    public String getIzvodjac() { return izvodjac; }
    public void setIzvodjac(String izvodjac) { this.izvodjac = izvodjac; }

    public String getSlika() { return slika; }
    public void setSlika(String slika) { this.slika = slika; }
}
