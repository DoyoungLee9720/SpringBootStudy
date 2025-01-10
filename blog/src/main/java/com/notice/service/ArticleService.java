package com.notice.service;

import com.notice.dto.ArticleDTO;
import com.notice.entity.Article;
import com.notice.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;
    //기본적인 모든 글 가지고 오기
    public List<ArticleDTO> getArticles(){
        List<Article> articles= articleRepository.findAll();
        List<ArticleDTO> articleDTOs= modelMapper.map(articles, List.class);
        return articleDTOs;
    }
    // 글 작성
    public void insetArticle(ArticleDTO articleDTO) {
        Article articles = modelMapper.map(articleDTO, Article.class);
        articleRepository.save(articles);
    }
    // 선택된 글 가지고 오기
    public ArticleDTO getArticlebynumber(int number) {
        log.info("getArticlebynumber : " + number);
        Article article = articleRepository.findByNumber(number);
        ArticleDTO articleDTO = modelMapper.map(article, ArticleDTO.class);
        log.info("articleDTO : "+articleDTO);
        return articleDTO;
    }
    // 선택된 글 수정
    public void updateArticle(ArticleDTO articleDTO) {
        Article article = modelMapper.map(articleDTO, Article.class);
        articleRepository.save(article);
    }
    // 선택된 글 삭제
    @Transactional
    public void deleteArticle(int articleId) {
        articleRepository.deleteByNumber(articleId);
    }
    
    //페이징 처리한 글 목록 가지고 오기
    public Page<Article> getArticlesAll(int page) {
        Pageable pageable = PageRequest.of(page,5);
        Page<Article> Articles = articleRepository.findAll(pageable);
        log.info("Articles : " + Articles.getTotalElements());
        return Articles;
    }
}
