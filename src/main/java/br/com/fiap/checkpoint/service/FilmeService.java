package br.com.fiap.checkpoint.service;

import br.com.fiap.checkpoint.model.Filme;
import br.com.fiap.checkpoint.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.controller.dto.FilmeDTO;
import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    //Adicionar novo filme
    public Filme adicionarFilme(Filme filme) {
        return filmeRepository.save(filme);
    }

    //Atualiza Filme
    public Filme atualizarFilme (Long id, FilmeDTO filmeDTO){
        Optional<Filme> filmeExistente = filmeRepository.findById(id);
        if (filmeExistente.isPresent()) {
            Filme filmeAtualizado = filmeExistente.get();
            filmeAtualizado.setGenero(filmeDTO.getGenero());
            filmeAtualizado.setAnoLancamento(filmeDTO.getAnoLancamento());
            filmeAtualizado.setDiretor(filmeDTO.getDiretor());
            filmeAtualizado.setDescricao(filmeDTO.getDescricao());
            filmeAtualizado.setTitulo(filmeDTO.getTitulo());
            return filmeRepository.save(filmeAtualizado);
        }   else {
            throw new RuntimeException("Filme não encontrado com o ID: " + id);
        }
    }

    //Listar Filmes
    public List<Filme> listarFilme() {
        return filmeRepository.findAll();
    }

    //Buscar Filme
    public void buscarFilme(Long id){
        if(filmeRepository.existsById(id)){
            filmeRepository.findById(id);
        } else {
            throw new RuntimeException("Filme não encontrado com o ID: " + id);
        }
    }

    //Remover Filmes
    public void removerFilme(Long id){
        if(filmeRepository.existsById(id)){
            filmeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Filme não encontrado com o ID: " + id);
        }
    }


}
