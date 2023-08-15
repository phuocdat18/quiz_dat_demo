package com.cg.service.answer;

import com.cg.model.Answer;
import com.cg.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public List<Answer> findById(Long id) {
        return answerRepository.findByQuestionId(id);
    }
}
