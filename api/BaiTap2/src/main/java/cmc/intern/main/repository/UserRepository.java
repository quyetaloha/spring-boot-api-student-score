package cmc.intern.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cmc.intern.main.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
