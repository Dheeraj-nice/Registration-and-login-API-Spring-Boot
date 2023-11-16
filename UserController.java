package com.regis_login.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping()
public class UserController {

	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
        // Hash the password before saving
        user.setPass(passwordEncoder.encode(user.getPass()));
        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
	}
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody User user) {
		User storeduser=userRepository.findByUsername(user.getUsername());
		if(storeduser!=null && passwordEncoder.matches(user.getPass(), storeduser.getPass())) {
			
			return new ResponseEntity<>("login success",HttpStatus.OK);
			}
		else {
				return new ResponseEntity<>("invalid",HttpStatus.UNAUTHORIZED);
			}
		}
}

