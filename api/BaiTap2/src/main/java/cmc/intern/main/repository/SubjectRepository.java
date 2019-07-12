package cmc.intern.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cmc.intern.main.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer>{

}
