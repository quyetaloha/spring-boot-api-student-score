package cmc.intern.serviceImpl;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cmc.intern.main.entity.User;
import cmc.intern.main.repository.UserRepository;
import cmc.intern.service.UserService;

@Repository
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public ArrayList<User> getAllUser() {
		// TODO Auto-generated method stub
		return (ArrayList<User>) userRepository.findAll();
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
		
	}

	@Override
	public void insertUser(User user) {
		userRepository.save(user);
		
	}

}
