package com.github.raphael008.mapper;

import java.util.List;

public interface BaseMapper<T> {

    int insert(T t);

    int insertSelective(T t);

    int updateByPrimaryKey(T t);

    int updateByPrimaryKeySelective(T t);

    T selectByPrimaryKey(Long id);

    List<T> selectList();

    int deleteByPrimaryKey(Long id);
}
