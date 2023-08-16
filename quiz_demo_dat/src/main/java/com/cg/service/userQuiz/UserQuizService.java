package com.cg.service.userQuiz;


import com.cg.exception.DataInputException;
import com.cg.model.Quiz;
import com.cg.model.User;
import com.cg.model.UserQuiz;
import com.cg.model.dto.userQuiz.UserQuizDTO;
import com.cg.repository.QuizRepository;
import com.cg.repository.UserQuizRepository;
import com.cg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserQuizService {
    private final UserQuizRepository userQuizRepository;
    private final UserRepository userRepository;
    private final QuizRepository quizRepository;

    @Autowired
    public UserQuizService(UserQuizRepository userQuizRepository, UserRepository userRepository, QuizRepository quizRepository) {
        this.userQuizRepository = userQuizRepository;
        this.userRepository = userRepository;
        this.quizRepository = quizRepository;
    }

    public void addUserQuiz(UserQuizDTO userQuizDTO) {
        UserQuiz userQuiz = new UserQuiz();
        userQuiz.setScore(userQuizDTO.getScore());
        userQuiz.setDate(userQuizDTO.getDate());

        User user = userRepository.findById(userQuizDTO.getUserId()).orElseThrow(() -> new DataInputException("User not found."));
        userQuiz.setUser(user);

        Quiz quiz = quizRepository.findById(userQuizDTO.getQuizId()).orElseThrow(() -> new DataInputException("Quiz not found."));
        userQuiz.setQuiz(quiz);

        userQuizRepository.save(userQuiz);
    }
}
