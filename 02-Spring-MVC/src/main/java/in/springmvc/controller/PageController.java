package in.springmvc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.springmvc.model.User;
import in.springmvc.service.UserService;


@Controller
public class PageController{
	
	@Autowired
	private UserService userService;
	
	//Show Registration Page
	@GetMapping("/register")
	public String RegisterPage() {
		
		 return "register";
	}
  //Register User data
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user, Model model ) {
		
		User savedUser=userService.registerUser(user);
		
		model.addAttribute("user",savedUser);
		
		return"registration-success";
	}
	
	//show Login Page
	@GetMapping("/login")
	public String loginUser() {
		return "login";
	}
	
	//check user is valid or not
	@PostMapping("/login")
	public String login(@RequestParam("email")String email,@RequestParam("password")String password,Model model) {
		
		Optional<User> userOptional=userService.checkLogin(email, password);
		
		if(userOptional.isEmpty()) {
			model.addAttribute("error","invalid user and password");
			return "login";
		}
		 model.addAttribute("user", userOptional.get());
		 return "login-success";
	
	}
}