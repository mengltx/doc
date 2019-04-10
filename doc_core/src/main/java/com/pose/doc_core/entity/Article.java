package com.pose.doc_core.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "article")
public class Article {

    @Id
    private String id;

    private String menuId;

    private String title;

    private String content;

    private String render;
}
