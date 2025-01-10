package com.notice.service;

import com.notice.dto.ArticleDTO;
import com.notice.dto.PageRequestDTO;
import com.notice.dto.PageResponseDTO;
import com.notice.entity.Article;
import com.notice.repository.ArticleRepository;
import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;
    public List<ArticleDTO> getArticles(){
        List<Article> articles= articleRepository.findAll();
        List<ArticleDTO> articleDTOs= modelMapper.map(articles, List.class);
        return articleDTOs;
    }

    public void insetArticle(ArticleDTO articleDTO) {
        Article articles = modelMapper.map(articleDTO, Article.class);
        articleRepository.save(articles);
    }

    public ArticleDTO getArticlebynumber(int number) {
        log.info("getArticlebynumber : " + number);
        Article article = articleRepository.findByNumber(number);
        ArticleDTO articleDTO = modelMapper.map(article, ArticleDTO.class);
        log.info("articleDTO : "+articleDTO);
        return articleDTO;
    }

    public void updateArticle(ArticleDTO articleDTO) {
        Article article = modelMapper.map(articleDTO, Article.class);
        articleRepository.save(article);
    }

    @Transactional
    public void deleteArticle(int articleId) {
        articleRepository.deleteByNumber(articleId);
    }

    public Page<Article> getArticlesAll(int page) {
        Pageable pageable = PageRequest.of(page,5);
        Page<Article> Articles = articleRepository.findAll(pageable);
        log.info("Articles : " + Articles.getTotalElements());
        return Articles;
    }
}
