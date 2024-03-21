package br.com.fiap.checkpoint.controller;

import br.com.fiap.checkpoint.controller.dto.EpisodioDTO;
import br.com.fiap.checkpoint.model.Episodio;
import br.com.fiap.checkpoint.service.EpisodioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class EpisodioController {

    @Autowired
    private EpisodioService episodioService;

    // Adicionar Episodios
    @PostMapping
    public ResponseEntity<Episodio> adicionarEpisodio(@RequestBody Episodio episodio) {
        Episodio novoEpisodio = episodioService.adicionarEpisodio(episodio);
        return ResponseEntity.ok(novoEpisodio);
    }

    // Atualiza Episodios
    @PutMapping("/{id}")
    public ResponseEntity<Episodio> atualizarEpisodio(@PathVariable Long id, @RequestBody EpisodioDTO episodioDTO) {
        Episodio episodioAtualizado = episodioService.atualizarEpisodio(id, episodioDTO);
        return ResponseEntity.ok(episodioAtualizado);
    }

    // Lista Episodios
    @GetMapping
    public ResponseEntity<List<Episodio>> listarEpisodio() {
        List<Episodio> episodios = episodioService.listarEpisodio();
        return ResponseEntity.ok(episodios);
    }

    //Mostra Episodio
    @GetMapping("/{id}")
    public ResponseEntity<Void> buscarEpisodio(@PathVariable Long id) {
        episodioService.buscarEpisodio(id);
        return ResponseEntity.ok().build();
    }

    // Remove Filme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerEpisodio(@PathVariable Long id) {
        episodioService.removerEpisodio(id);
        return ResponseEntity.ok().build();
    }

}
