package com.pose.doc_core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "menu")
public class Menu {

    @Id
    private String id;

    /**
     * 父菜单ID
     */
    private String parentId;

    /**
     * 子菜单
     */
    private List<Menu> sub;

    /**
     * 名称
     */
    private String name;

    /**
     * 是否是目录
     */
    private Boolean directory;

    /**
     * 文档ID
     */
    private String docId;

    /**
     * 排序
     */
    private Integer order;

    private Long createTime;

}
