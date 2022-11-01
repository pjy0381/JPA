package com.example.jpaExam.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book extends Item{
    private String author;
    private String isbn;
}
