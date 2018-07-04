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
public class MainController {
	/**/
	 private static Logger logger = LoggerFactory.getLogger(SecurityController.class);
	 
	@Autowired
	private MessageSource messageSource;
	 
	@GetMapping("/create/scratch")
	public String create() {
		return "client/create";
	}

}
