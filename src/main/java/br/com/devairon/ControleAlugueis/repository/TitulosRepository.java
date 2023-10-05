package br.com.devairon.ControleAlugueis.repository;

import java.util.List;

import br.com.devairon.ControleAlugueis.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitulosRepository  extends JpaRepository<Titulo, Long>{
	
	public List<Titulo> findByDescricaoContaining(String descricao);

}
