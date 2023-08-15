package com.cg.service.quiz;

import com.cg.model.Quiz;
import com.cg.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IQuizService extends IGeneralService<Quiz, Long> {
    List<Quiz> findAll();

    List<Quiz> findQuizByIdQuiz(Long id);

    List<Quiz> findQuizDetailByQuizId(Long id);
}
