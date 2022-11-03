package com.example.jpaExam.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends Item {
    private String director;
    private String actor;
}
