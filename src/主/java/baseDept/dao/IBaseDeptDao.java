package com.qhit.baseDept.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

/**
* Created by GeneratorCode on 2018/10/22
*/

@Repository
public interface IBaseDeptDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List findByDeptName(Object deptName);

}