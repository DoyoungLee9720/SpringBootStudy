package com.notice.dto;

import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageRequestDTO {

    @Builder.Default
    private int no = 1;

    @Builder.Default
    private int pg = 1;

    @Builder.Default
    private int size = 5;

    public Pageable getPageable(String sort) {
        int pageSize = this.size;
        return PageRequest.of(this.pg - 1, pageSize, Sort.by(sort).descending());
    }

}
