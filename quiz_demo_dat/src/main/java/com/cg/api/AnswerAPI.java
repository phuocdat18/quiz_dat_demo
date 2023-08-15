package com.cg.api;

import com.cg.repository.AnswerRepository;
import com.cg.service.answer.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answer")
public class AnswerAPI {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private AnswerService answerService;
}
