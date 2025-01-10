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
@Entity                 // 엔티티 객체 정의
@Table(name = "article")
public class Article {
    @Id
    private int number;
    private String title;
    private String content;
    private String writer;
}
