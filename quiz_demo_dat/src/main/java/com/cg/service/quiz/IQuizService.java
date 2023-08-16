package com.cg.service.quiz;

import com.cg.model.Quiz;
import com.cg.model.User;
import com.cg.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IQuizService extends IGeneralService<Quiz, Long> {
    List<Quiz> findAll();

//    List<Quiz> findQuizByIdQuiz(Long id);

    List<Quiz> findQuizDetailByQuizId(Long id);

}
