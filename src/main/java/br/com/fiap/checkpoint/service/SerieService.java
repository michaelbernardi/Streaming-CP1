package br.com.fiap.checkpoint.service;

import br.com.fiap.checkpoint.controller.dto.SerieDTO;
import br.com.fiap.checkpoint.model.Filme;
import br.com.fiap.checkpoint.model.Serie;
import br.com.fiap.checkpoint.repository.FilmeRepository;
import br.com.fiap.checkpoint.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService {
    @Autowired
    private SerieRepository serieRepository;

    //Adicionar nova Serie
    public Serie adicionarSerie(Serie serie) {
        return serieRepository.save(serie);
    }

    //Atualiza Serie
    public Serie atualizarSerie (Long id, SerieDTO serieDTO){
        Optional<Serie> serieExistente = serieRepository.findById(id);
        if (serieExistente.isPresent()) {
            Serie serieAtualizado = serieExistente.get();
            serieAtualizado.setGenero(serieDTO.getGenero());
            serieAtualizado.setAnoLancamento(serieDTO.getAnoLancamento());
            serieAtualizado.setEpisodios(serieDTO.getEpisodios());
            serieAtualizado.setDescricao(serieDTO.getDescricao());
            serieAtualizado.setTitulo(serieDTO.getTitulo());
            return serieRepository.save(serieAtualizado);
        }   else {
            throw new RuntimeException("Serie não encontrado com o ID: " + id);
        }
    }

    //Listar Series
    public List<Serie> listarSerie() {
        return serieRepository.findAll();
    }

    //Remover Serie
    public void removerSerie(Long id){
        if(serieRepository.existsById(id)){
            serieRepository.deleteById(id);
        } else {
            throw new RuntimeException("Serie não encontrado com o ID: " + id);
        }
    }

}


