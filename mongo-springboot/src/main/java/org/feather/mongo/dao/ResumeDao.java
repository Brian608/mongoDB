package org.feather.mongo.dao;

import org.feather.mongo.bean.Resume;

import java.util.List;

/**
 * @program: mongoDB_java
 * @description:
 * @author: 杜雪松(feather)
 * @since: 2022-01-16 09:46
 **/
public interface ResumeDao {
    void  insertResume(Resume  resume);
    /** 根据name 获取Resume 对象 */
    Resume findByName(String  name);
    List<Resume> findList(String  name);
    /** 根据name  和  expectSalary 查询 */
    List<Resume>  findListByNameAndExpectSalary(String name,double expectSalary);
}
