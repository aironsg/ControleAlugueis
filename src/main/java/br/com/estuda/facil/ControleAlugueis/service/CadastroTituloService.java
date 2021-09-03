package br.com.estuda.facil.ControleAlugueis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.estuda.facil.ControleAlugueis.model.StatusTitulo;
import br.com.estuda.facil.ControleAlugueis.model.Titulo;
import br.com.estuda.facil.ControleAlugueis.repository.TitulosRepository;
import br.com.estuda.facil.ControleAlugueis.repository.filter.TituloFilter;

@Service
public class CadastroTituloService {
	
	
	@Autowired
	private TitulosRepository titulos;
	
	public void salvar(Titulo titulo) {
		try {
			titulos.save(titulo);
			
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido!");
		}
		
	}
	
	public void excluirTitulo(Long codigo) {
		titulos.deleteById(codigo);
	}

	public String receber(Long codigo) {
		Titulo titulo = titulos.getById(codigo);
		titulo.setStatus(StatusTitulo.RECEBIDO);
		titulos.save(titulo);
		
		return StatusTitulo.RECEBIDO.getDescricao();
		
	}
	
	public List<Titulo> filtrar(TituloFilter filtro) {
		String descricao = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
		return titulos.findByDescricaoContaining(descricao);
	}
	

}
