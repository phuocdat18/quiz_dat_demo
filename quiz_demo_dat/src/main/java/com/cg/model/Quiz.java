package com.cg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

//@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @OneToMany(mappedBy = "quizQ")
    private List<Question> questions;

    @OneToMany(mappedBy = "quiz")
    @JsonIgnore
    private List<UserQuiz> quizzes;

    public Quiz(Long id, String content, Collection<Question> questions, Collection<UserQuiz> quizzes) {
        this.id = id;
        this.content = content;
        this.questions = (List<Question>) questions;
        this.quizzes = (List<UserQuiz>) quizzes;
    }
}
