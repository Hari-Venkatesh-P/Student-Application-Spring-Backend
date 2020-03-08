package com.example.demo.repo;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,String> {

	@Transactional
    @Modifying
    @Query(value = "delete from students where id = ?1",nativeQuery = true)
	void removeStudent(String id);
    
	
	@Transactional
    @Modifying
    @Query(value = "update students set passkey = ?2 where id = ?1",nativeQuery = true)
	void updateStudent(String id,String passkey);
}
