package com.notice.controller;

import com.notice.dto.ArticleDTO;
import com.notice.entity.Article;
import com.notice.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@RequiredArgsConstructor
public class MainIndex {
    private final ArticleService articleService;
    //메인화면
    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "/index";
    }
    //글목록
    @GetMapping({"/article"})
    public String articles(Model model, @RequestParam(value="page",defaultValue = "0") int pg) {
        Page<Article> pageResponseDTO = articleService.getArticlesAll(pg);
//        List<ArticleDTO> ArticleDTOs = articleService.getArticles();
        model.addAttribute("ArticleDTOs", pageResponseDTO);
        return "/article";
    }
    //글쓰기
    @GetMapping({"/write"})
    public String write(Model model) {
        return "/write";
    }
    //글쓴뒤 데이터 전달
    @PostMapping("/write")
    public String write(ArticleDTO articleDTO) {
        articleService.insetArticle(articleDTO);
        return "redirect:/article";
    }
    //글수정
    @GetMapping("/rewrite/{number}")
    public String rewrite(@PathVariable String number,Model model) {
        int articleId = Integer.parseInt(number);
        ArticleDTO articleDTOinfo = articleService.getArticlebynumber(articleId);
        log.info("articleDTOinfo : " +articleDTOinfo);
        model.addAttribute("articleDTOinfo", articleDTOinfo);
        return "/rewrite";
    }
    //글수정후 데이터 전달
    @PostMapping("/rewrite/{number}")
    public String rewrite(ArticleDTO articleDTO) {
        articleService.updateArticle(articleDTO);
        return "redirect:/article";
    }
    //글삭제
    @GetMapping("/delete/{number}")
    public String delete(@PathVariable String number) {
        int articleId = Integer.parseInt(number);
        articleService.deleteArticle(articleId);
        return "redirect:/article";
    }
}
