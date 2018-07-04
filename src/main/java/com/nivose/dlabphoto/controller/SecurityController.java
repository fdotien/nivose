package com.nivose.dlabphoto.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nivose.dlabphoto.repository.UserRepository;

@Controller
public class SecurityController {
	/**/
	 private static Logger logger = LoggerFactory.getLogger(SecurityController.class);
	 
	@Autowired
	private MessageSource messageSource;

	@Autowired
	UserRepository userRepository;
	
	  @GetMapping("/")
	    public String home1() {
	        return "/index";
	    }

	    @GetMapping("/home")
	    public String home() {
	        return "/home";
	    }

	    @GetMapping("/admin")
	    public String admin() {
	        return "/admin";
	    }

	    @GetMapping("/user")
	    public String user() {
	        return "/user";
	    }

	    @GetMapping("/about")
	    public String about() {
	        return "/about";
	    }

	    @GetMapping("/login")
	    public String login() {
	        return "login";
	    }

	    @GetMapping("/403")
	    public String error403() {
	        return "/error/403";
	    }
}