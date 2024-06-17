package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;

import com.mysite.sbb.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)  // 번호를 차례로 생성한다
   private Integer id;

   @Column(length = 200)
   private String subject;

   @Column(columnDefinition = "TEXT")
   private String content;

   private LocalDateTime createDate;
   
   // 참조 엔티티의 속성을 쓰고, cascade는 질문이 삭제되면 답변도 같이 삭제 
   @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
   private List<Answer> answerList;  // question.getAnswerList()
}