package cmc.intern.service;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import cmc.intern.main.entity.User;

@Service
@Transactional
public interface UserService {
	public ArrayList<User> getAllUser();

	public User getUserById(int id);

	public void updateUser(User user);

	public void insertUser(User user);
}
