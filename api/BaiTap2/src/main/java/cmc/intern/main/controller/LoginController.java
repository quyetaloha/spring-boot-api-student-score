package cmc.intern.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cmc.intern.main.Input.model.InputLogin;
import cmc.intern.main.session.SessionManager;

@RestController
@CrossOrigin("*")
public class LoginController {
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody InputLogin inputLogin,HttpServletRequest httpServletRequest){
		if(inputLogin.getUsername().equals("quyet")&&inputLogin.getPassword().equals("admin")) {
			HttpSession session=httpServletRequest.getSession();
			session.setAttribute("username", "admin");
			System.out.println(session.getId());
			SessionManager.id=session.getId();
			return new ResponseEntity<String>(SessionManager.id,HttpStatus.OK);
		}
		else 
			return new ResponseEntity<String>("login fail! username or password incorrect",HttpStatus.UNAUTHORIZED);
	}
}
