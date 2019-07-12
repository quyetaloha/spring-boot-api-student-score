package cmc.intern.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import cmc.intern.main.entity.UserScoreRelate;

@Service
@Transactional
public interface ScoreService {
	public ArrayList<UserScoreRelate> getAllScore();
	public UserScoreRelate getScoreById(int id);
	public void updateScore(UserScoreRelate user);
	public void insertScore(UserScoreRelate user);
}
