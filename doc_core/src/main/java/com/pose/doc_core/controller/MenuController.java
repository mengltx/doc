package com.pose.doc_core.controller;


import com.pose.doc_core.common.Result;
import com.pose.doc_core.entity.Menu;
import com.pose.doc_core.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/menus")
@RestController
public class MenuController {


    @Autowired
    private MenuService menuService;

    @PostMapping
    public Result addMenu(@RequestBody Menu menu){

        return Result.Query(menuService.addMenu(menu),null);

    }

    @PostMapping({"directory/add"})
    public Result addDirectory(@RequestBody Menu menu){

        return Result.Query(menuService.addDirectory(menu),null);

    }
    @DeleteMapping(value = "/{id}")
    public Result deleteMenu(@PathVariable String id){

        return Result.execute(menuService.delete(id),null);
    }

    @GetMapping
    public Result<List<Menu>> listMenuTree(){

        Result data = Result.Query(true,menuService.menusTree());
        return data;


    }

    @GetMapping(value = {"/directory"})
    public Result findDirectory(){
        return  Result.Query(true,menuService.findDirectory());
    }
}
