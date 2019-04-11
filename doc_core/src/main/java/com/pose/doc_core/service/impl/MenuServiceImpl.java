package com.pose.doc_core.service.impl;

import com.pose.doc_core.entity.Menu;
import com.pose.doc_core.repository.MenuRepository;
import com.pose.doc_core.service.MenuService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {


    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Boolean addMenu(Menu menu) {

        menuRepository.save(menu);
        return true;
    }

    @Override
    public Boolean delete(String id) {
        menuRepository.deleteById(id);
        return true;
    }

    @Override
    public Boolean update(Menu menu) {
        mongoTemplate.save(menu);
        return true;
    }

    @Override
    public List<Menu> listAllMenus() {

        List<Menu> menus = menuRepository.findAll(Sort.by("order"));

        List<Menu> parents = new ArrayList<>();
        for(Menu menu:menus){
            if(menu.getDirectory()){
                parents.add(menu);
            }
        }

        for(Menu parent:parents){
            parent.setSub(new ArrayList<>());
            for(Menu menu:menus){
                if(!menu.getDirectory() && menu.getParentId().equals(new ObjectId(parent.getId()))){
                    parent.getSub().add(menu);
                }
            }
        }
        return parents;
    }

    @Override
    public List<Menu> menusTree() {
        /**
         * 1.查询所有菜单
         * 2.抽取一级菜单
         * 3.为每个一级菜单生成子菜单
         */

        //所有菜单
        List<Menu> allMenus = menuRepository.findAll(Sort.by("order"));
        //一级菜单
        List<Menu> firstLevel = new ArrayList<>();
        for(Menu menu:allMenus){
            if(menu.getParentId()==null){
                firstLevel.add(menu);
            }
        }

        //调用递归方法生成子菜单
        for(Menu parent:firstLevel){
            parent.setSub(getChildren(parent.getId(),allMenus));
        }

        return firstLevel;
    }

    @Override
    public List<Menu> findDirectory() {
        return mongoTemplate.find(Query.query(Criteria.where("directory").is(true)),Menu.class,"menu");
    }

    @Override
    public Boolean addDirectory(Menu menu) {
        menu.setDirectory(true);
        menu.setCreateTime(new Date().getTime());
        menuRepository.save(menu);
        return true;
    }

    private List<Menu> getChildren(String parentId,List<Menu> allMenus){
        List<Menu> children = new ArrayList<>();

        for(Menu menu:allMenus){
            if(parentId.equals(menu.getParentId())){
                children.add(menu);
                menu.setSub(getChildren(menu.getId(),allMenus));
            }
        }

        return children;

    }

}
