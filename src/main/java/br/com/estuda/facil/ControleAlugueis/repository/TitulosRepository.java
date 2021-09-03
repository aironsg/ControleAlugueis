package br.com.estuda.facil.ControleAlugueis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estuda.facil.ControleAlugueis.model.Titulo;

public interface TitulosRepository  extends JpaRepository<Titulo, Long>{
	
	public List<Titulo> findByDescricaoContaining(String descricao);

}
