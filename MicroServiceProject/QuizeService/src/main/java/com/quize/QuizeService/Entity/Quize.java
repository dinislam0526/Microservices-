package com.quize.QuizeService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Quize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long quizId;
    private String title;
    transient private List<Question> questions;

}
