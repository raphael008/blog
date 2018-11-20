package com.github.raphael008.service;

import java.util.List;

public interface BaseService<T> {
    int insert(T t);

    int insertSelective(T t);

    int updateByPrimaryKey(T t);

    int updateByPrimaryKeySelective(T t);

    T selectByPrimaryKey(Long id);

    List<T> selectList();

    int deleteByPrimaryKey(Long id);
}
