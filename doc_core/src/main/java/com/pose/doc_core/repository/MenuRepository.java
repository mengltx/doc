package com.pose.doc_core.repository;

import com.pose.doc_core.entity.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuRepository extends MongoRepository<Menu,String> {
}
