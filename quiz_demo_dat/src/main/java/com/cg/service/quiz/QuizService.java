package com.cg.service.quiz;

import com.cg.model.Quiz;
import com.cg.model.UserQuiz;
import com.cg.repository.QuestionRepository;
import com.cg.repository.QuizRepository;
import com.cg.repository.UserQuizRepository;
import com.cg.service.request.UserQuizSaveRequest;
import com.cg.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService implements IQuizService  {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private UserQuizRepository userQuizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }

    @Override
    public Optional<Quiz> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Quiz> findQuizByIdQuiz(Long id) {
        return quizRepository.findQuizByIdQuiz(id);
    }

    @Override
    public List<Quiz> findQuizDetailByQuizId(Long id) {
        return quizRepository.findQuizDetailByQuizId(id);
    }

    @Override
    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public void delete(Quiz quiz) {

    }

    @Override
    public void deleteById(Long id) {

    }

    public void saveScore(UserQuizSaveRequest request) {
        UserQuiz newScore = AppUtils.mapper.map(request, UserQuiz.class);
        userQuizRepository.save(newScore);
    }
}
