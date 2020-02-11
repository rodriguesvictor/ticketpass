package pp2.ifpe.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pp2.ifpe.model.Evento;
import pp2.ifpe.model.Usuario;
import pp2.ifpe.persistence.EventoDAO;
import pp2.ifpe.service.CategoriaService;
import pp2.ifpe.service.EventoService;


@Controller
public class IndexController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private EventoDAO eventoDAO;
		
	@GetMapping("index.html")
	public String index(Model model) {
		model.addAttribute("listaCat",categoriaService.listaCategoria());
		return "redirect:/home";
	}
	
	@GetMapping("/index")
	public String inicio(Model model) {
		return "index";
	}
	
	@GetMapping("/quemSomos")
	public String quemSomos(){	
	return "quemSomos";
		
	}
	
	@GetMapping("/quemsomos2")
	public String quemSomos2(){	
	return "quemSomos2";
		
	}
		
	@GetMapping("/trocarSenha")
	public String alterarSenha() {
		return "/trocarSenha";
	}
		
	@GetMapping("/confirmouConta")
    public String confirmou() {
		return "confirmouConta";
	}
	
	
	
	@GetMapping("/eventoCadastro")
    public String eventoCadastro() {
		return "/eventoCadastro";
	}
	
	@GetMapping("/esqueciSenha")
    public String esqueceuSenha() {
		return "esqueceuSenha";
	}
	
	
	@GetMapping("/redefinicaoSenha")
    public String redefinicao() {
		return "redefinirSenha";
	}
	

	
	@GetMapping("/eventoPago")
	public String eventoPago() {
		return "eventoPago";
	}
	
	
	@PostMapping("/pesquisar2")
	public ModelAndView pesquisar2(@RequestParam("nomePesquisa") String nomePesquisa) {
		ModelAndView modelAndView = new ModelAndView("redirect:/index");
		modelAndView.addObject("lista", eventoDAO.findEventoByNome(nomePesquisa));
	    modelAndView.addObject("eventoobj", new Evento());
	    return modelAndView;
    }

	@GetMapping("/listarCategoria")
	public String listarCat(Model model) {
		model.addAttribute("listaCat",categoriaService.listaCategoria());
		return "listarCategoria";
	}
	
	@GetMapping("/categoria")
	public String eventosCategoria(@RequestParam("id")Integer id, HttpSession session, Model model) throws Exception {
		model.addAttribute("listaCat",categoriaService.listaCategoria());
		model.addAttribute("lista", eventoService.listEventoCategoria(id));
		return "listarCategoria";
	}
}
