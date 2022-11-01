package com.example.jpaExam.domain;

import com.example.jpaExam.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

        private String username;

    private String city;

    private String street;

    private String zipcode;

}
