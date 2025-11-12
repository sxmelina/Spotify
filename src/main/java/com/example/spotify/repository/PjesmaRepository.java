package com.example.spotify.repository;

import com.example.spotify.model.Pjesma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PjesmaRepository extends JpaRepository<Pjesma, Long> {
    List<Pjesma> findByAlbum_Id(Long id);
}
