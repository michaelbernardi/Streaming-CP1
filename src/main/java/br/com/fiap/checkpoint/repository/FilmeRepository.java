package br.com.fiap.checkpoint.repository;


import br.com.fiap.checkpoint.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FilmeRepository extends JpaRepository <Filme, Long>{

}
