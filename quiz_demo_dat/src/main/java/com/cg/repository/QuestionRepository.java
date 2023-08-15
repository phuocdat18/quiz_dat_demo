package com.cg.repository;

import com.cg.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuizQ_Id(Long quizQ_id);
}
