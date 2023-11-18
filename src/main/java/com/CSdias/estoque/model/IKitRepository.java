package com.CSdias.estoque.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKitRepository extends JpaRepository<Kit, Long>{
    public List<Kit> findByNomeIgnoringCaseContaining(String nome);
}