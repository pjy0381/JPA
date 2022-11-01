package com.example.jpaExam.common;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {
    private String createBy;
    private LocalDateTime createDate;
    private String lastModifyBy;
    private LocalDateTime lastModifyDate;
}
