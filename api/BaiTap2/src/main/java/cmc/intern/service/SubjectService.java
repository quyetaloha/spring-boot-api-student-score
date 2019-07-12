package cmc.intern.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import cmc.intern.main.entity.Subject;

@Service
@Transactional
public interface SubjectService {
	public ArrayList<Subject> getAllSubject();

	public Subject getSubjectById(int id);

	public void updateSubject(Subject user);

	public void insertSubject(Subject user);
}
