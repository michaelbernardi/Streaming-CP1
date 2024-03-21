package br.com.fiap.checkpoint.controller;

import br.com.fiap.checkpoint.controller.dto.FilmeDTO;
import br.com.fiap.checkpoint.model.Filme;
import br.com.fiap.checkpoint.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/filme")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    // Adicionar Filme
    @PostMapping
    public ResponseEntity<Filme> adicionarFilme(@RequestBody Filme filme) {
        Filme novoFilme = filmeService.adicionarFilme(filme);
        return ResponseEntity.ok(novoFilme);
    }

    // Atualiza Filme
    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable Long id, @RequestBody FilmeDTO filmeDTO) {
        Filme filmeAtualizado = filmeService.atualizarFilme(id, filmeDTO);
        return ResponseEntity.ok(filmeAtualizado);
    }

    // Lista Filme
    @GetMapping
    public ResponseEntity<List<Filme>> listarFilme() {
        List<Filme> filmes = filmeService.listarFilme();
        return ResponseEntity.ok(filmes);
    }

    //Mostra Filme
    @GetMapping("/{id}")
    public ResponseEntity<Void> buscarFilme(@PathVariable Long id) {
        filmeService.buscarFilme(id);
        return ResponseEntity.ok().build();
    }

    // Remove Filme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerFilme(@PathVariable Long id) {
        filmeService.removerFilme(id);
        return ResponseEntity.ok().build();
    }
}


