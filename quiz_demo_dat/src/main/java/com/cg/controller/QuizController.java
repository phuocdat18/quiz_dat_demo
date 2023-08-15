package com.cg.controller;


import com.cg.exception.DataInputException;
import com.cg.model.Question;
import com.cg.model.Quiz;
import com.cg.model.User;
import com.cg.model.UserQuiz;
import com.cg.repository.UserQuizRepository;
import com.cg.service.answer.AnswerService;
import com.cg.service.question.QuestionService;
import com.cg.service.quiz.QuizService;
import com.cg.service.request.UserQuizSaveRequest;
import com.cg.service.user.UserServiceImpl;
import com.cg.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/allquiz")
public class QuizController {
    @Autowired
    private AppUtils appUtils;

    @Autowired
    private QuizService quizService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public String show() {
        return "listQuiz/list_quiz";
    }

    @GetMapping("/quiz_detail")
    public String showQuiz(Model model, @RequestParam long id, Pageable pageable) {
        String username = appUtils.getPrincipalUsername();

        Optional<User> userOptional = userService.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new DataInputException("User not valid");
        }

        User user = userOptional.get();

        List<Quiz> quiz = quizService.findQuizByIdQuiz(id);
        if (quiz.isEmpty()) {
            throw new DataInputException("quiz not found");
        }
        model.addAttribute("quizById", quiz.get(0));

//        List<Quiz> quizList = quizService.findQuizDetailByQuizId(id);
//        model.addAttribute("quizDetail", quizList);

        String roleCode = user.getRole().getCode();
        model.addAttribute("username", username);
        model.addAttribute("user", user);
        model.addAttribute("roleCode", roleCode);
        model.addAttribute("idQuiz", id);


        return "listQuiz/allQuestion";
    }

    @PostMapping("/save-score")
    public ResponseEntity<?> saveScore(@RequestBody UserQuizSaveRequest scoreData) {
        quizService.saveScore(scoreData);
        return ResponseEntity.ok(scoreData);
    }
}
