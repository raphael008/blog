package com.github.raphael008.service.Impl;

import com.github.raphael008.mapper.BaseMapper;
import com.github.raphael008.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    @Override
    public int insert(T t) {
        int count = baseMapper.insert(t);
        return count;
    }

    @Override
    public int insertSelective(T t) {
        int count = baseMapper.insertSelective(t);
        return count;
    }

    @Override
    public int updateByPrimaryKey(T t) {
        int count = baseMapper.updateByPrimaryKey(t);
        return count;
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        int count = baseMapper.updateByPrimaryKeySelective(t);
        return count;
    }

    @Override
    public T selectByPrimaryKey(Long id) {
        T t = baseMapper.selectByPrimaryKey(id);
        return t;
    }

    @Override
    public List<T> selectList() {
        List<T> list = baseMapper.selectList();
        return list;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        int count = baseMapper.deleteByPrimaryKey(id);
        return count;
    }
}
