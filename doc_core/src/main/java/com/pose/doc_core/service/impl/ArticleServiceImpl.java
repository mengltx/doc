package com.pose.doc_core.service.impl;

import com.pose.doc_core.entity.Article;
import com.pose.doc_core.entity.Menu;
import com.pose.doc_core.service.ArticleService;
import com.pose.doc_core.vo.ArticleVo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public Article addArticle(ArticleVo articleVo) {

        //保存菜单
        Menu menu = new Menu();
        menu.setName(articleVo.getTitle());
        menu.setOrder(menu.getOrder());
        menu.setParentId(articleVo.getDirectory());
        mongoTemplate.insert(menu);

        Article article = new Article();
        article.setMenuId(menu.getId());
        article.setTitle(articleVo.getTitle());
        article.setContent(articleVo.getContent());
        article.setRender(articleVo.getRender());
        mongoTemplate.insert(article);

        menu.setDocId(article.getId());
        mongoTemplate.save(menu);
        return article;

    }

    @Override
    public Article editArticle(ArticleVo articleVo) {

        Article article = mongoTemplate.findById(articleVo.getId(),Article.class);
        article.setRender(articleVo.getRender());
        article.setContent(articleVo.getContent());
        article.setTitle(article.getTitle());
        mongoTemplate.save(article);
        return article;
    }

    @Override
    public Article findArticle(String id) {

        return mongoTemplate.findById(id,Article.class);
    }
}
