package com.mysite.sbb.answer;

import java.time.LocalDateTime;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.user.SiteUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
   @Id  // 기본키, 각 데이터들을 구분하는 유효한 값(중복 불가능)
   @GeneratedValue(strategy = GenerationType.IDENTITY)  // 고유한 번호를 생성하는 방법
   private Integer id;
   
   // 열 이름 텍스트를 열 데이터로 넣을 수 있다. 글자수를 제한할 수 없는 경우에 사용
   @Column(columnDefinition ="TEXT")
   private String content;
   
   private LocalDateTime createDate;
   
   // Question을 참조해야 하기 위해
   @ManyToOne // 다대일 -> 하나의 질문에 답변은 여러개가 달릴수 있다. 따라서 답변은 Many가 되고 질문은 One이 된다. @ManyToOne을 통해서 N:1 관계를 나타낼 수 있다
   private Question question;  // 외래키
   
   @ManyToOne
   private SiteUser author;
   
   private LocalDateTime modifyDate;
}