package com.CSdias.estoque.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKitRepository extends JpaRepository<Kit, Long> {
    public List<Kit> findByPeca(Optional<Peca> pca);

    public Optional<Kit> findById(Long id);

    public List<Kit> findByNomeIgnoringCaseContaining(String nome);
}