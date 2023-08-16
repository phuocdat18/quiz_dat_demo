package com.cg.api;

import com.cg.model.dto.userQuiz.UserQuizDTO;
import com.cg.service.userQuiz.UserQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userQuiz")
public class UserQuizAPI {

    @Autowired
    private UserQuizService userQuizService;

    @PostMapping
    public ResponseEntity<String> addUserQuiz(@RequestBody UserQuizDTO userQuizDTO) {
        try {
            userQuizService.addUserQuiz(userQuizDTO);
            return ResponseEntity.ok("UserQuiz information added successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding UserQuiz information.");
        }
    }
}
