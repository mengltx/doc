package com.pose.doc_core.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ArticleVo {

    private String id;

    private String title;

    private Integer order;

    private String content;

    private String render;

    private String directory;
}
