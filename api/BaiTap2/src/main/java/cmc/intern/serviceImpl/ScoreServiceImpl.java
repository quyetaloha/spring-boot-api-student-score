package cmc.intern.serviceImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cmc.intern.main.entity.UserScoreRelate;
import cmc.intern.main.repository.UserScoreRelateRepository;
import cmc.intern.service.ScoreService;

@Repository
@Transactional
public class ScoreServiceImpl implements ScoreService{

	@Autowired
	private UserScoreRelateRepository userScoreRelateRepository;

	@Override
	public ArrayList<UserScoreRelate> getAllScore() {
		// TODO Auto-generated method stub
		return (ArrayList<UserScoreRelate>) userScoreRelateRepository.findAll();
	}

	@Override
	public UserScoreRelate getScoreById(int id) {
		// TODO Auto-generated method stub
		return userScoreRelateRepository.getOne(id);
	}

	@Override
	public void updateScore(UserScoreRelate user) {
		userScoreRelateRepository.save(user);
		
	}

	@Override
	public void insertScore(UserScoreRelate user) {
		userScoreRelateRepository.save(user);
		
	}
	

}
