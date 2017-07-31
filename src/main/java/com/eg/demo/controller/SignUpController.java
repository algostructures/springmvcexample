package com.eg.demo.controller;

import com.eg.demo.model.SignUpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.eg.demo.validator.SignUpValidator;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blah/addNew")
@SessionAttributes("SignUp")
public class SignUpController
{
	
	@Autowired
	SignUpValidator validator;
	
	@RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model) 
	{
		 SignUpVo signUpVo = new SignUpVo();
		 model.addAttribute("SignUp", signUpVo);
		 return "SignUp";
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public ModelAndView submitForm(@ModelAttribute("SignUp") SignUpVo signUpVo,
            				BindingResult result, SessionStatus status)
	{
		
		validator.validate(signUpVo, result);
		
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("SignUp");
			modelAndView.addObject(signUpVo);
			status.setComplete();
			return modelAndView;
		}

		//below statements added to just show how to add error messages from this method
		/*boolean invalid_login = true;
		if(invalid_login==true)
		{
			//"firstName", "error.firstName", "First name is required."
			result.rejectValue("firstName", "invalid.firstName");
			return "addStudent";
		}*/

		//Mark Session Complete
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("confirm");
		modelAndView.addObject("ref", signUpVo);
		//status.setComplete();
		return modelAndView;

    }
	
	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String success(Model model) 
	{
		 return "addSuccess";
    }


	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView handleRequest(@ModelAttribute("SignUp") SignUpVo signUpVo){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("SignUp");
		modelAndView.addObject("ref", signUpVo);
		return modelAndView;
	}
}