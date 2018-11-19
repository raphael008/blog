package com.github.raphael008.mapper;

import com.github.raphael008.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> select();
}
