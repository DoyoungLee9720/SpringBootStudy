package com.notice.repository;

import com.notice.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    // 번호로 선택된 글 가지고 오기
    Article findByNumber(Integer number);
    // 선택된 번호 글 삭제하기
    void deleteByNumber(Integer articleId);
    // 페이징 처리된 모든 글 가지고 오기
    Page<Article> findAll(Pageable pageable);
}
