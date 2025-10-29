package com.example.spotify.model;

public class Album {
    private Long id;
    private String naziv;
    private String zanr;
    private int godinaIzdanja;
    private String izvodjac;

    public Album(Long id, String naziv, String zanr, int godinaIzdanja, String izvodjac) {
        this.id = id;
        this.naziv = naziv;
        this.zanr = zanr;
        this.godinaIzdanja = godinaIzdanja;
        this.izvodjac = izvodjac;
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
}
