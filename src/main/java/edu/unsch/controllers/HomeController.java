package edu.unsch.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class HomeController {

	@GetMapping("/home")
	public String index(HttpSession session, Model model) {

		return "views/admin/home/index";
	}
}
