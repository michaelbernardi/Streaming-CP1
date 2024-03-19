package br.com.fiap.checkpoint.controller.dto;

import br.com.fiap.checkpoint.model.Episodio;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class SerieDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private Integer anoLancamento;
    private String genero;
    @OneToMany
    private List<Episodio> listEpisodio = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Episodio> getListEpisodio() {
        return listEpisodio;
    }

    public void setListEpisodio(List<Episodio> listEpisodio) {
        this.listEpisodio = listEpisodio;
    }
}

