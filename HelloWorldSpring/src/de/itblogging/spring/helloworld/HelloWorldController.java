package de.itblogging.spring.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController
{

	@RequestMapping("/helloWorld")
	public ModelAndView helloWorld()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("helloWorld");
		String message = "Geschafft! Ich bin dein erstes Spring MVC Erfolgserlebnis! :-) ";
		System.out.println(message);
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}