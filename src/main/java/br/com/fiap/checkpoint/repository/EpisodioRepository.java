package br.com.fiap.checkpoint.repository;

import br.com.fiap.checkpoint.model.Episodio;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EpisodioRepository extends JpaRepository <Episodio, Long> {
}
