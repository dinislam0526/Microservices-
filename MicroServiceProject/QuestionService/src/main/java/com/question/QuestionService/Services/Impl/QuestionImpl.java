package com.question.QuestionService.Services.Impl;

import com.question.QuestionService.Services.QuestionService;
import com.question.QuestionService.entities.Question;
import com.question.QuestionService.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionImpl implements QuestionService {

    private QuestionRepository questionRepository;

    public QuestionImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question getById(Long id) {
        return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question not found"));
    }

    @Override
    public Question update(Long id, Question question) {
        return null;
    }

    @Override
    public String delete(Long id) {
        if (questionRepository.findById(id).isPresent()){
            questionRepository.deleteById(id);
            return "Question is deleted";
        }
        return "No such Question in the database";
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {
        return questionRepository.getByQuizId(quizId);
    }
}
