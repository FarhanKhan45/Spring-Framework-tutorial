
package com.example.springsecurity;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/h")
    public String hello() {
        return "hii";
    }

    @GetMapping("/hello")
    public String hii() {
        return "hello";
    }

    @PostMapping("/debit")
    public String debit() {
        return "money is debited";
    }

//    @GetMapping("/csrf")
//    public CsrfToken csrf(HttpServletRequest request) {
//        return (CsrfToken) request.getAttribute(
//                CsrfToken.class.getName());
//    }

    @PostMapping("/users")
    public ResponseEntity<String> saveUser(
            @RequestBody UserEntity user) {

        user.setPassword(
                passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User saved successfully");
    }
    

@PostMapping("/authenticate")
public String authenticate(@RequestBody AuthRequest authRequest) {

    Authentication authenticate =
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    authRequest.getUsername(),
                    authRequest.getPassword()
                )
            );

    if (authenticate.isAuthenticated()) {
        return jwtService.generateToken(authRequest.getUsername());
    }

    return null;
}


    
}
