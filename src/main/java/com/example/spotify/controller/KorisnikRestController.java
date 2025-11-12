package com.example.spotify.controller;

import com.example.spotify.model.Album;
import com.example.spotify.model.Korisnik;
import com.example.spotify.repository.AlbumRepository;
import com.example.spotify.repository.KorisnikRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/korisnici")
public class KorisnikRestController {

    private final KorisnikRepository korisnikRepository;
    private final AlbumRepository albumRepository;

    public KorisnikRestController(KorisnikRepository korisnikRepository, AlbumRepository albumRepository) {
        this.korisnikRepository = korisnikRepository;
        this.albumRepository = albumRepository;
    }

    // ---- KORISNICI CRUD (osnovno) ----

    // GET /api/korisnici
    @GetMapping
    public List<Korisnik> all() {
        return korisnikRepository.findAll();
    }

    // GET /api/korisnici/{id}
    @GetMapping("/{id}")
    public Korisnik one(@PathVariable Long id) {
        return korisnikRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Korisnik nije pronađen"));
    }

    // POST /api/korisnici  (kreiranje)
    @PostMapping
    public ResponseEntity<Korisnik> create(@RequestBody Korisnik body) {
        if (body.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID se ne šalje pri kreiranju");
        }
        var saved = korisnikRepository.save(body);
        return ResponseEntity.created(URI.create("/api/korisnici/" + saved.getId())).body(saved);
    }

    // PUT /api/korisnici/{id}  (izmjena)
    @PutMapping("/{id}")
    public Korisnik update(@PathVariable Long id, @RequestBody Korisnik body) {
        var k = korisnikRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Korisnik nije pronađen"));
        if (body.getUsername() != null) k.setUsername(body.getUsername());
        if (body.getEmail() != null) k.setEmail(body.getEmail());
        return korisnikRepository.save(k);
    }

    // ---- LIKE KOLEKCIJA ----

    // GET /api/korisnici/{id}/likes  (svi lajkovani albumi)
    @GetMapping("/{id}/likes")
    public List<Album> likes(@PathVariable Long id) {
        var k = korisnikRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Korisnik nije pronađen"));
        // toList() od Java 16; ako si na starijem, koristi new ArrayList<>(k.getLikedAlbums())
        return k.getLikedAlbums().stream().toList();
    }

    // POST /api/korisnici/{id}/like/{albumId}  (lajkuj)
    @PostMapping("/{id}/like/{albumId}")
    public ResponseEntity<Void> like(@PathVariable Long id, @PathVariable Long albumId) {
        var k = korisnikRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Korisnik nije pronađen"));
        var a = albumRepository.findById(albumId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Album nije pronađen"));

        k.likeAlbum(a);
        korisnikRepository.save(k);
        return ResponseEntity.ok().build();
    }

    // DELETE /api/korisnici/{id}/like/{albumId}  (unlike)
    @DeleteMapping("/{id}/like/{albumId}")
    public ResponseEntity<Void> unlike(@PathVariable Long id, @PathVariable Long albumId) {
        var k = korisnikRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Korisnik nije pronađen"));
        var a = albumRepository.findById(albumId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Album nije pronađen"));

        k.unlikeAlbum(a);
        korisnikRepository.save(k);
        return ResponseEntity.noContent().build();
    }
}

