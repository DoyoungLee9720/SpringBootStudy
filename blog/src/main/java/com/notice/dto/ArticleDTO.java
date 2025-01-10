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
    private int number;
    private String title;
    private String content;
    private String writer;
}
