package cmc.intern.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cmc.intern.main.entity.Subject;
import cmc.intern.service.SubjectService;


@RestController
@CrossOrigin("*")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/subjects-manager")
	public List<Subject> getAllUser() {
		return subjectService.getAllSubject();
	}
}
