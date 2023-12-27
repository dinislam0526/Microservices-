package com.quize.QuizeService.Services.Impl;

import com.quize.QuizeService.Entity.Quize;
import com.quize.QuizeService.Repository.QuizeRepository;
import com.quize.QuizeService.Services.QuestionClient;
import com.quize.QuizeService.Services.QuizeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizeServiceImpl implements QuizeService {

    private QuizeRepository quizeRepository;

    private QuestionClient questionClient;

    public QuizeServiceImpl(QuizeRepository quizeRepository, QuestionClient questionClient) {
        this.quizeRepository = quizeRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quize add(Quize quize) {
        return quizeRepository.save(quize);
    }

    @Override
    public List<Quize> getAll() {
       List<Quize> quizes = quizeRepository.findAll();
       List<Quize> newQuizList = quizes.stream().map(quize -> {
           quize.setQuestions(questionClient.getQuestionOfQuiz(quize.getQuizId()));
           return quize;
       }).collect(Collectors.toList());

        return newQuizList;
    }

    @Override
    public Quize getById(Long id) {
       Quize quize = quizeRepository.findById(id).orElseThrow(()-> new RuntimeException("Quize not found"));
       quize.setQuestions(questionClient.getQuestionOfQuiz(quize.getQuizId()));
        return quize;
    }

    @Override
    public Quize update(Long id, Quize employee) {
        Optional<Quize> optional = quizeRepository.findById(id);

        if (optional.isPresent()) {
            Quize quize = optional.get();

            if (Objects.nonNull(employee.getTitle()) && !"".equalsIgnoreCase(employee.getTitle())) {
                quize.setTitle(employee.getTitle());
            }

            return quizeRepository.save(quize);
        }
        return null;
    }

    @Override
    public String delete(Long id) {
        if (quizeRepository.findById(id).isPresent()) {
            quizeRepository.deleteById(id);
            return "Quiz deleted successfully";
        }
        return "No such Quiz in the database";
    }

}
