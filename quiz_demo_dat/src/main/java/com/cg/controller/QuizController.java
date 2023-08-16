package com.cg.controller;


import com.cg.exception.DataInputException;
import com.cg.model.*;
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

//    @GetMapping("/quiz_detail")
//    public String showQuizDetail(Model model, @RequestParam("id") long id) {
//        model.addAttribute("idQuiz", id);
//        return "listQuiz/allQuestion";
//    }

    @GetMapping("/quiz_detail")
    public String showQuizDetail(Model model, @RequestParam("id") long id) {
        String username = appUtils.getPrincipalUsername();
        Long idUser = appUtils.getPrincipalIdUser();

        Optional<User> userOptional = userService.findByUsername(username);
        Optional<User> user = userService.findById(idUser);

        if (!userOptional.isPresent() || !user.isPresent()) {
            throw new DataInputException("User not valid");
        }

        Role role = userOptional.get().getRole();
        String roleCode = role.getCode();

        model.addAttribute("username", username);
        model.addAttribute("idUser", idUser);
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
