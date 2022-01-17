package org.feather.mongo.dao.impl;

import org.feather.mongo.bean.Resume;
import org.feather.mongo.dao.ResumeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: mongoDB_java
 * @description:
 * @author: 杜雪松(feather)
 * @since: 2022-01-16 09:47
 **/
@Repository("resumeDao")
public class ResumeDaoImpl implements ResumeDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public void insertResume(Resume resume) {
        //mongoTemplate.insert(resume);
        mongoTemplate.insert(resume,"resume");
    }

    @Override
    public Resume findByName(String name) {
        Query  query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        List<Resume> datas = mongoTemplate.find(query,Resume.class,"resume");
        return  datas.isEmpty()?null:datas.get(0);
    }

    @Override
    public List<Resume> findList(String name) {
        Query  query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        List<Resume> datas = mongoTemplate.find(query,Resume.class,"resume");
        return  datas;
    }

    @Override
    public List<Resume> findListByNameAndExpectSalary(String name, double expectSalary) {
        Query  query = new Query();
        //query.addCriteria(Criteria.where("name").is(name).andOperator(Criteria.where("expectSalary").is(expectSalary)));
        query.addCriteria(Criteria.where("name").is(name).andOperator(Criteria.where("expectSalary").is(expectSalary)));
        return  mongoTemplate.find(query,Resume.class,"resume");
    }
}
