package com.question.QuestionService.Services;

import com.question.QuestionService.entities.Question;

import java.util.List;

public interface QuestionService {

    Question add(Question question);

    List<Question> getAll();

    Question getById(Long id);

    Question update(Long id,Question question);

    String delete(Long id);

    List<Question> getQuestionsOfQuiz(Long quizId);
}
