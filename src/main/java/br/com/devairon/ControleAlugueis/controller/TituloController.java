package br.com.devairon.ControleAlugueis.controller;

import java.util.Arrays;
import java.util.List;

import br.com.devairon.ControleAlugueis.model.StatusTitulo;
import br.com.devairon.ControleAlugueis.model.Titulo;
import br.com.devairon.ControleAlugueis.repository.TitulosRepository;
import br.com.devairon.ControleAlugueis.service.CadastroTituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	private static final String CADASTRO_VIEW = "CadastroTitulo";
	
	@Autowired
	private TitulosRepository titulos;
	
	@Autowired
	private CadastroTituloService cadastroTituloService;
	
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Titulo());
		return mv;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes) {
		//TODO: salvar no banco de dados
		//verificando se existe algum erro de validação
		if(errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		//caso não exista nenhum erro de validação, será salvo na lista e enviando para o banco de dados
		try {
			cadastroTituloService.salvar(titulo);
			attributes.addFlashAttribute("mensagem", "Aluguel cadastrado com sucesso!");
			return "redirect:/titulos/novo";
		} catch (IllegalArgumentException e) {
			errors.reject("dataVencimento", null, e.getMessage());
			return CADASTRO_VIEW;
		}
	}
	
	
// metodo que pesquisa os dados no BD e mostra na tela de pesquisa	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Titulo> todosTitulos = titulos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", todosTitulos);
		
		return mv;
	}
	

/**
 * 
 * @param filtro
 * @return
 * 
 * este metodo está quebrando a aplicação, o uso da anotation ModelAttribute
 * provavelmente seja o defeito.
 * 
 * o objetivo deste metodo é mostrar na tela os dados e permitir a pesquisa de algo especifico
 */

//	@RequestMapping
//	public ModelAndView pesquisar(@ModelAttribute("filtro") TituloFilter filtro) {
//		List<Titulo> todosTitulos = cadastroTituloService.filtrar(filtro);
//		
//		ModelAndView mv = new ModelAndView("PesquisaTitulos");
//		mv.addObject("titulos", todosTitulos);
//		return mv;
//	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Long codigoTitulo) {
		Titulo titulo = titulos.getById(codigoTitulo);
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(titulo);
		
		return mv;
	}
	
	@RequestMapping(value ="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		cadastroTituloService.excluirTitulo(codigo);
		attributes.addFlashAttribute("mensagem", "Titulo excluido com sucesso!");
		return "redirect:/titulos";
	}

	@RequestMapping(value = "/{codigo}/receber", method = RequestMethod.PUT)
	public @ResponseBody String receber(@PathVariable Long codigo) {
		 return cadastroTituloService.receber(codigo);
		
	}
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}

}
