package com.pose.doc_core.service;

import com.pose.doc_core.entity.Article;
import com.pose.doc_core.vo.ArticleVo;

public interface ArticleService {

    Article addArticle(ArticleVo articleVo);

    Article editArticle(ArticleVo articleVo);

    Article findArticle(String id);
}
