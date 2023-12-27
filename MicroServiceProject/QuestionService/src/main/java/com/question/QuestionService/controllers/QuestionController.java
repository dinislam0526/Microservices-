package com.question.QuestionService.controllers;

import com.question.QuestionService.Services.QuestionService;
import com.question.QuestionService.entities.Question;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @PostMapping("/save")
    Question add(@RequestBody Question question){
        return questionService.add(question);
    }
    @GetMapping("/getAll")
    public List<Question> getAll(){
        return questionService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Question getById(@PathVariable Long id){
        return questionService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return questionService.delete(id);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId){
        return questionService.getQuestionsOfQuiz(quizId);
    }

}
