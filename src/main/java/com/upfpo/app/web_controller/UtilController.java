package com.upfpo.app.web_controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UtilController {
	

	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView goIndex() {
		ModelAndView mav = new ModelAndView();
	   mav.setViewName("index.def");
	
	return mav;
}
}