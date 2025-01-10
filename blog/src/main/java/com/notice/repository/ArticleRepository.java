package com.notice.repository;

import com.notice.dto.ArticleDTO;
import com.notice.dto.PageRequestDTO;
import com.notice.entity.Article;
import com.querydsl.core.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Article findByNumber(Integer number);

    void deleteByNumber(Integer articleId);

    Page<Article> findAll(Pageable pageable);
}
