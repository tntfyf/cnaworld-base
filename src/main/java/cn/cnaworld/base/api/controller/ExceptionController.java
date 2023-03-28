package cn.cnaworld.base.api.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = Exception.class)
	public String defaultException(Exception e,Model model) {
		model.addAttribute("e", e);
		return "error";
	}
}
