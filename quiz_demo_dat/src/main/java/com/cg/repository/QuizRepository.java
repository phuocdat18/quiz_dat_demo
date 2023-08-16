package com.cg.repository;

import com.cg.model.Quiz;
import com.cg.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    @Query("SELECT NEW com.cg.model.Quiz(" +
            "b.id, " +
            "b.content, " +
            "b.questions, " +
            "b.quizzes) " +
            "FROM Quiz b " +
            "WHERE b.id = :id")
    List<Quiz> findQuizDetailByQuizId (Long id);

//    @Query("SELECT NEW com.cg.model.Quiz ( " +
//            "Quiz.id, " +
//            "Quiz.content, " +
//            "Quiz.questions, " +
//            "Quiz.quizzes" +
//            ") " +
//            "FROM Quiz " +
//            "JOIN Question AS que ON Quiz.id = que.quizQ.id " +
//            "JOIN Answer AS an ON que.id = an.question.id " +
//            "WHERE Quiz.id = :id "
//    )
//    List<Quiz> findQuizDetailByQuizId (Long id);
}
