package com.example.demo;





import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



import java.util.List;



@Repository

public interface LoginRepository extends JpaRepository<Login, Integer> {

	

	Login findOne(int LoginId);



//    List<Login> findByTitleContainingOrContentContaining(String text, String textAgain);



}