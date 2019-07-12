package cmc.intern.serviceImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cmc.intern.main.entity.Subject;
import cmc.intern.main.repository.SubjectRepository;
import cmc.intern.service.SubjectService;

@Repository
@Transactional
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	private SubjectRepository SubjectRepository;
	@Override
	public ArrayList<Subject> getAllSubject() {
		// TODO Auto-generated method stub
		return (ArrayList<Subject>) SubjectRepository.findAll();
	}

	@Override
	public Subject getSubjectById(int id) {
		// TODO Auto-generated method stub
		return SubjectRepository.getOne(id);
	}

	@Override
	public void updateSubject(Subject Subject) {
		SubjectRepository.save(Subject);
		
	}
	
	@Override
	public void insertSubject(Subject Subject) {
		SubjectRepository.save(Subject);
		
	}

}
