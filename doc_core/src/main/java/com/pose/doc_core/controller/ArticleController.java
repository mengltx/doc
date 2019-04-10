package com.pose.doc_core.controller;

import com.pose.doc_core.common.Result;
import com.pose.doc_core.service.ArticleService;
import com.pose.doc_core.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result add(@RequestBody ArticleVo articleVo){

        return Result.execute(true,articleService.addArticle(articleVo));
    }

    @PutMapping
    public Result edit(@RequestBody ArticleVo articleVo){

        return Result.execute(true,articleService.editArticle(articleVo));
    }

    @GetMapping({"/{id}"})
    public Result findArticle(@PathVariable  String id){
        return Result.Query(true,articleService.findArticle(id));

    }
}
