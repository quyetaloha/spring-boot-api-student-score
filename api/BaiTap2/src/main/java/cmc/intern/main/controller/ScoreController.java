package cmc.intern.main.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cmc.intern.main.Input.model.InputUserAndScore;
import cmc.intern.main.entity.User;
import cmc.intern.main.entity.UserScoreRelate;
import cmc.intern.service.ScoreService;
import cmc.intern.service.SubjectService;
import cmc.intern.service.UserService;

@RestController
@CrossOrigin("*")
public class ScoreController {

	@Autowired
	private ScoreService scoreService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private UserService userService;	
	@PostMapping("/insert-score-user")
	public ResponseEntity<String> insertScoreUser(@RequestBody InputUserAndScore inputUserAndScore) {
		User user = new User();
		user.setHoTen(inputUserAndScore.getHoTen());
		user.setLop(inputUserAndScore.getLop());
		userService.insertUser(user);
		int id = user.getId();
		for (int i = 0; i < inputUserAndScore.getDiem().size(); i++) {
			ArrayList<Double> diems = inputUserAndScore.getDiem().get(i);
			UserScoreRelate userScoreRelate = new UserScoreRelate();
			userScoreRelate.setUser(userService.getUserById(id));
			userScoreRelate.setSubject(subjectService.getSubjectById(i + 1));
			userScoreRelate.setProcessScore(diems.get(0));
			userScoreRelate.setExamScore(diems.get(1));
			scoreService.insertScore(userScoreRelate);
		}
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
}
