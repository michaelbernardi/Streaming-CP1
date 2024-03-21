package br.com.fiap.checkpoint.controller;

import br.com.fiap.checkpoint.controller.dto.SerieDTO;
import br.com.fiap.checkpoint.model.Filme;

import br.com.fiap.checkpoint.model.Serie;
import br.com.fiap.checkpoint.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class SerieController {

    @Autowired
    private SerieService serieService;

    // Adicionar Serie
    @PostMapping
    public ResponseEntity<Serie> adicionarSerie(@RequestBody Serie serie) {
        Serie novoSerie = serieService.adicionarSerie(serie);
        return ResponseEntity.ok(novoSerie);
    }

    // Atualiza Serie
    @PutMapping("/{id}")
    public ResponseEntity<Serie> atualizarSerie(@PathVariable Long id, @RequestBody SerieDTO serieDTO) {
        Serie serieAtualizado = serieService.atualizarSerie(id, serieDTO);
        return ResponseEntity.ok(serieAtualizado);
    }

    // Lista Serie
    @GetMapping
    public ResponseEntity<List<Serie>> listarSerie() {
        List<Serie> serie = serieService.listarSerie();
        return ResponseEntity.ok(serie);
    }

    // Mostra Serie
    @GetMapping("/{id}")
    public ResponseEntity<Void> buscarSerie(@PathVariable Long id) {
        serieService.buscarSerie(id);
        return ResponseEntity.ok().build();
    }

    // Remove Serie
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerSerie(@PathVariable Long id) {
        serieService.removerSerie(id);
        return ResponseEntity.ok().build();
    }

}
