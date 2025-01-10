package com.notice.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ArticleDTO {
    private int number; //글번호
    private String title; //글제목
    private String content; //글내용
    private String writer; //작성자
}
