package edu.unsch.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.unsch.dao.ModuloDao;

@Controller
@RequestMapping("/admin")
public class HomeController {
	@Autowired
	private ModuloDao moduloDao;

	@GetMapping("/home")
	public String index(HttpSession session, Model model) {

		model.addAttribute("modulos", moduloDao.findAll());
		return "views/admin/home/index";
	}
}
