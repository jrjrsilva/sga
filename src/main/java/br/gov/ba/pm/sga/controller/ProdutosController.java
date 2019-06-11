package br.gov.ba.pm.sga.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.gov.ba.pm.sga.model.Movimento;
import br.gov.ba.pm.sga.model.Produto;
import br.gov.ba.pm.sga.repository.Movimentos;
import br.gov.ba.pm.sga.repository.Produtos;
import br.gov.ba.pm.sga.service.GrupoService;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private Produtos produtos;
	
	@Autowired
	private GrupoService grupos;
	
	@Autowired
	private Movimentos movimentos;
	
		
	@DeleteMapping("/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
		produtos.delete(id);
		
		attributes.addFlashAttribute("mensagem", "Produto removido com sucesso!");
		
		return "redirect:/produtos";
	}
	
	
	@GetMapping
	public ModelAndView listar(Produto produto) {
		ModelAndView modelAndView = new ModelAndView("produtos/lista-produtos");
		modelAndView.addObject("produtos", produtos.findAll());
		
		return modelAndView;
	}
	
	@GetMapping("/porsaldopositivo")
	public ModelAndView porSaldoPositivo(Produto produto) {
		ModelAndView modelAndView = new ModelAndView("produtos/lista-produtos");
		modelAndView.addObject("produtos", produtos.porSaldoMaiorPositivo());
		
		return modelAndView;
	}
	
	@GetMapping("/porsaldonegativo")
	public ModelAndView porSaldoNegativo(Produto produto) {
		ModelAndView modelAndView = new ModelAndView("produtos/lista-produtos");
		modelAndView.addObject("produtos", produtos.porSaldoNegativo());
		
		return modelAndView;
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Produto produto) {
		ModelAndView modelAndView = new ModelAndView("produtos/cadastro-produto");
		modelAndView.addObject(produto);
		modelAndView.addObject("grupos", grupos.findAll());
		return modelAndView;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Produto produto, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(produto);
		}
		
		Produto p = new Produto();
		p = produtos.findOne(produto.getId());
		
		if((p.getQuantidade() > produto.getQuantidade()) || (p.getQuantidade() < produto.getQuantidade())) {
			Movimento mv = new Movimento();
			
			mv.setCodigo(p.getCodigo());
			mv.setDataCadastro(new Date());
			mv.setGrupo(p.getGrupo());
			mv.setNome(p.getNome());
			mv.setQuantidade(produto.getQuantidade());
			mv.setTipo("I");
			
			this.movimentos.save(mv);
		}
		
		this.produtos.save(produto);
		
		attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso!");
		
		return new ModelAndView("redirect:/produtos");
	}
	
	@PostMapping("/atualizar")
	public ModelAndView atualizar(@Valid Produto produto, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(produto);
		}
		
		produtos.save(produto);
		
		
		attributes.addFlashAttribute("mensagem", "Produto atualizado com sucesso!");
		
		return new ModelAndView("redirect:/produtos");
	}
	
	@PostMapping("/pesquisar")
	public ModelAndView busca(Produto produto) {
		
		ModelAndView modelAndView = new ModelAndView("produtos/lista-produtos");
		modelAndView.addObject("produtos", produtos.obterPorCodigo(produto.getCodigo()));
		
		return modelAndView;
				
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(produtos.findOne(id));
	}
	
	@GetMapping("/entrada/{id}")
	public ModelAndView entrada(@PathVariable Long id) {
		return novaEntrada(produtos.findOne(id));
	}
	
	@GetMapping("/entrada")
	public ModelAndView novaEntrada(Produto produto) {
		ModelAndView modelAndView = new ModelAndView("produtos/entrada-produto");
		produto.setQuantidade(0.0);
		modelAndView.addObject(produto);		
		
		return modelAndView;
	}
	
	@PostMapping("/entrada/novo")
	public ModelAndView salvarEntrada(@Valid Produto produto, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(produto);
		}
		
		Produto p = new Produto();
		p = produtos.findOne(produto.getId());
		p.setQuantidade(p.getQuantidade() + produto.getQuantidade());
		
		produtos.save(p);
		
		Movimento mv = new Movimento();
		
		mv.setCodigo(p.getCodigo());
		mv.setDataCadastro(new Date());
		mv.setGrupo(p.getGrupo());
		mv.setNome(p.getNome());
		mv.setQuantidade(produto.getQuantidade());
		mv.setTipo("E");
		
		this.movimentos.save(mv);
		
		attributes.addFlashAttribute("mensagem", "Entrada salva com sucesso!");
		
		return new ModelAndView("redirect:/produtos");
	}
}
