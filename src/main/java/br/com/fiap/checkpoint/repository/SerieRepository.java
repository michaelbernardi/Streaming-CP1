package br.com.fiap.checkpoint.repository;

import br.com.fiap.checkpoint.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository <Serie, Long> {
}
