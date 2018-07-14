package com.spring.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {
	private final static Logger logger = LoggerFactory.getLogger(ErrorController.class);

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String error403CTRL() {
		logger.debug("error403CTRL Enter");
		return "error/403page";
	}
}
