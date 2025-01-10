package com.notice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "article")
public class Article {
    @Id
    private int number; //글번호
    private String title; // 글제목
    private String content; //글내용
    private String writer; //작성자
}
