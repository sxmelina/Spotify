package com.example.spotify.controller;

import com.example.spotify.model.Korisnik;
import com.example.spotify.repository.KorisnikRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/korisnici")
public class KorisnikController {

    private final KorisnikRepository korisnikRepository;

    public KorisnikController(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("korisnici", korisnikRepository.findAll());
        return "korisnici";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("korisnik", new Korisnik());
        return "korisnik_form";
    }

    @PostMapping
    public String create(@ModelAttribute Korisnik korisnik) {
        korisnikRepository.save(korisnik);
        return "redirect:/korisnici";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Korisnik korisnik = korisnikRepository.findById(id).orElseThrow();
        model.addAttribute("korisnik", korisnik);
        return "korisnik_form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Korisnik form) {
        Korisnik korisnik = korisnikRepository.findById(id).orElseThrow();
        korisnik.setUsername(form.getUsername());
        korisnik.setEmail(form.getEmail());
        korisnikRepository.save(korisnik);
        return "redirect:/korisnici";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Korisnik korisnik = korisnikRepository.findById(id).orElseThrow();
        model.addAttribute("korisnik", korisnik);
        return "korisnik_detail";
    }
}
