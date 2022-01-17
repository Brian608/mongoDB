package org.feather.mongo.repository;

import org.feather.mongo.bean.Resume;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @program: mongoDB_java
 * @description:
 * @author: 杜雪松(feather)
 * @since: 2022-01-17 20:46
 **/
public interface ResumeRepository extends MongoRepository<Resume,String> {

    List<Resume> findByNameEquals(String name);
}
