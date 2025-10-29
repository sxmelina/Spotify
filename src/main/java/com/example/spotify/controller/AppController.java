package com.example.spotify.controller;

import com.example.spotify.data.DemoData;
import com.example.spotify.model.Album;
import com.example.spotify.model.Pjesma;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {

    private final DemoData demoData;

    public AppController(DemoData demoData) {
        this.demoData = demoData;
    }

    @GetMapping("/a")
    public String listaAlbuma(Model model) {
        model.addAttribute("albumi", demoData.getAlbumi());
        return "listA";
    }

    @GetMapping("/b")
    public String listaPjesama(Model model) {
        model.addAttribute("pjesme", demoData.getPjesme());
        model.addAttribute("demoData", demoData);
        return "listB";
    }

    @GetMapping("/a/action/{id}")
    public String pjesmeAlbuma(@PathVariable Long id, Model model) {
        Album album = demoData.getAlbumById(id);

        List<Pjesma> pjesmeAlbuma = new ArrayList<>();
        for (Pjesma pjesma : demoData.getPjesme()) {
            if (pjesma.getAlbumId().equals(id)) {
                pjesmeAlbuma.add(pjesma);
            }
        }

        model.addAttribute("album", album);
        model.addAttribute("pjesme", pjesmeAlbuma);
        return "action";
    }
}
