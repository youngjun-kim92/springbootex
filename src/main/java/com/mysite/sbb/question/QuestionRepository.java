package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// CRUD함수를 JpaRepository가 들고 있음.
// @Repository라는 에너테이션이 없어도 IoC된다. 이유는 JpaRepository를 상속했기 때문.
// Question을 Integer라는 타입으로 받겠다(id(id가 Integer)를 기준으로 식별하겠다)
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	// findBy~ 생성
	// select * from question where subject =?
	Question findBySubject(String subject);  // Jpa Query methods
	Question findBySubjectAndContent(String subject, String content);
	List<Question> findBySubjectLike(String subject);
}