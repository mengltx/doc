package com.pose.doc_core.service;

import com.pose.doc_core.entity.Menu;

import java.util.List;

public interface MenuService {

    Boolean addMenu(Menu menu);

    Boolean delete(String id);

    List<Menu> listAllMenus();

    List<Menu> menusTree();

    List<Menu> findDirectory();

    Boolean addDirectory(Menu menu);

}
