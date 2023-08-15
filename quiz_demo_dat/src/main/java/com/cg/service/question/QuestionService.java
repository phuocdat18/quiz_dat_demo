package com.cg.service.question;

import com.cg.model.Question;
import com.cg.repository.QuestionRepository;
import com.cg.repository.QuizRepository;
import com.cg.repository.UserQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Page<Question> findQuestionByQuiz(Long id, Pageable pageable) {
        List<Question> questions = questionRepository.findByQuizQ_Id(id);

        Collections.shuffle(questions);

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), questions.size());
        List<Question> pageQuestions = questions.subList(start, end);
        Page<Question> page = new PageImpl<>(pageQuestions, pageable, questions.size());

        return page;
    }
}
