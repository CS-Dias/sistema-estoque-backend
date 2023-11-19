package com.CSdias.estoque.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPecaRepository extends JpaRepository<Peca, Long> {
    public List<Peca> findByKit(Optional<Kit> kit);

}
