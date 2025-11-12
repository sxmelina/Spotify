package com.example.spotify.controller;

import com.example.spotify.data.DemoData;
import com.example.spotify.model.Album;
import com.example.spotify.model.Korisnik;
import com.example.spotify.model.Pjesma;
import com.example.spotify.repository.AlbumRepository;
import com.example.spotify.repository.KorisnikRepository;
import com.example.spotify.repository.PjesmaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {

    private final AlbumRepository albumRepository;
    private final PjesmaRepository pjesmaRepository;
    private final KorisnikRepository korisnikRepository;

    public AppController(AlbumRepository albumRepository, PjesmaRepository pjesmaRepository, KorisnikRepository korisnikRepository) {
        this.albumRepository = albumRepository;
        this.pjesmaRepository = pjesmaRepository;
        this.korisnikRepository = korisnikRepository;
    }

    @GetMapping({"/", "/albumi"})
    public String listaAlbuma(Model model) {
        List<Album> albumi = albumRepository.findAll();
        model.addAttribute("albumi", albumi);
        return "listaalbuma";
    }
    @GetMapping("/pjesme")
    public String svePjesme(Model model) {
        model.addAttribute("pjesme", pjesmaRepository.findAll());
        return "listapjesama";
    }

    @GetMapping("/a/action/{id}")
    public String detaljAlbuma(@PathVariable Long id, Model model) {
        Album album = albumRepository.findById(id).orElse(null);
        List<Pjesma> pjesme = pjesmaRepository.findByAlbum_Id(id);

        model.addAttribute("album", album);
        model.addAttribute("pjesme", pjesme);

        return "action";
    }

    @PostMapping("/album/{id}/like")
    public String likeAlbum(@PathVariable Long id,
                            @RequestParam("userId") Long userId) {
        Korisnik korisnik = korisnikRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Korisnik nije pronađen"));
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album nije pronađen"));

        korisnik.likeAlbum(album);
        korisnikRepository.save(korisnik);

        return "redirect:/a/action/" + id;
    }
}
