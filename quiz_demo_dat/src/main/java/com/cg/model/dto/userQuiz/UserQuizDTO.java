package com.cg.model.dto.userQuiz;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserQuizDTO {
    private Integer score;
    private LocalDate date;
    private Long userId;
    private Long quizId;
}
