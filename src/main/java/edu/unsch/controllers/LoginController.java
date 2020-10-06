package edu.unsch.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.unsch.entities.Usuario;
import edu.unsch.services.ModuloService;
import edu.unsch.services.SubmoduloService;
import edu.unsch.services.UsuarioService;

@Controller
@RequestMapping
public class LoginController {

	@Autowired
	private UsuarioService usuarioServiceImpl;

	@Autowired
	private ModuloService moduloService;

	@Autowired
	private SubmoduloService submoduloService;

	@GetMapping({ "", "/login" })
	public String login(Model model) {
		model.addAttribute("title", "Log In");
		return "views/login/index";
	}

	@PostMapping("/login")
	public String login(HttpServletRequest request, HttpSession session, Model model) {
		model.addAttribute("user", new Usuario());

		Usuario user = this.usuarioServiceImpl.login(request.getParameter("username"),
				request.getParameter("password"));

		// Login del Admin
		Usuario useradmin = this.usuarioServiceImpl.loginAdmin(request.getParameter("username"),
				request.getParameter("password"));

		if (user == null) {
			model.addAttribute("error", "Cuenta Inválida");
			return "redirect:/login";
		} else if (useradmin != null) {
			session.setAttribute("usuario", useradmin.getUsuario());
			session.setAttribute("modulos", moduloService.listaModulos(useradmin.getUsuario()));
			session.setAttribute("submodulos", submoduloService.listaSubmodulos(useradmin.getUsuario()));

			return "redirect:/admin/home";
		} else {

			// Atributo guardado cuando el usuario a iniciado session
			session.setAttribute("usuario", user.getUsuario());

			return "redirect:/home";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("usuario");
		return "redirect:/login";
	}

	@PostMapping(value = "/")
	public String register(HttpServletRequest request, Model model) {

		usuarioServiceImpl.registrarComprador(request.getParameter("nombre"), request.getParameter("usuario"),
				request.getParameter("password"));

		return "redirect:/login";
	}
}
