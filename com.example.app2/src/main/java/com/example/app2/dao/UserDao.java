package com.example.app2.dao;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.app2.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User>{

    User selectOneById(Long Id);


    int insertBatch(List<User> entitys);
}
