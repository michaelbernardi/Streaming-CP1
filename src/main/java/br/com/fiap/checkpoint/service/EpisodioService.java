package br.com.fiap.checkpoint.service;

import br.com.fiap.checkpoint.controller.dto.EpisodioDTO;
import br.com.fiap.checkpoint.model.Episodio;
import br.com.fiap.checkpoint.model.Filme;
import br.com.fiap.checkpoint.repository.EpisodioRepository;
import br.com.fiap.checkpoint.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class EpisodioService {

    @Autowired
    private EpisodioRepository episodioRepository;

    //Adicionar novo episodio
    public Episodio adicionarEpisodio(Episodio episodio) {
        return episodioRepository.save(episodio);
    }

    //Atualiza Episodios
    public Episodio atualizarEpisodio (Long id, EpisodioDTO episodioDTO){
        Optional<Episodio> episodioExistente = episodioRepository.findById(id);
        if (episodioExistente.isPresent()) {
            Episodio episodioAtualizado = episodioExistente.get();
            episodioAtualizado.setTitulo(episodioDTO.getTitulo());
            episodioAtualizado.setNumeroEpisodio(episodioDTO.getNumeroEpisodio());
            episodioAtualizado.setTemporada(episodioDTO.getTemporada());
            episodioAtualizado.setListSerie(episodioDTO.getListSerie());
            return episodioRepository.save(episodioAtualizado);
        }   else {
            throw new RuntimeException("Episódio não encontrado com o ID: " + id);
        }
    }

    //Listar Episodios
    public List<Episodio> listarEpisodio() {
        return episodioRepository.findAll();
    }

    //Remover Episodios
    public void removerEpisodio(Long id){
        if(episodioRepository.existsById(id)){
            episodioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Episodio não encontrado com o ID: " + id);
        }
    }

}
