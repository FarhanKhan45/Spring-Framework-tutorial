package in.springmvc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.springmvc.model.User;
import in.springmvc.repository.UserRepository;

@Service
public class UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	//Registration
	public User registerUser(User user) {
		return userRepository.save(user);
	}
	
	
	//Login
	public Optional<User> checkLogin(String email,String Password){
		
		Optional<User> userOptional=userRepository.findByEmail(email);
		
		if(userOptional.isEmpty()) {
			return Optional.empty();
		}
		
		User user=userOptional.get();
		
		if(!user.getPassword().equals(Password)){
			
		return Optional.empty();
		}
		
		return Optional.of(user);
	}
}