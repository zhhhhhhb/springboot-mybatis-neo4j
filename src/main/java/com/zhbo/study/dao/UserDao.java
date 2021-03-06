package com.zhbo.study.dao;

import com.zhbo.study.domain.UserModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    List<UserModel> getPage(@Param("pageStart") int pageStart,
                            @Param("pageSize") int pageSize,
                            @Param("sort") String sort,
                            @Param("name") String name,
                            @Param("sex") String sex);

    int getPageTotal(@Param("name") String name,
                     @Param("sex") String sex);

    List<UserModel> getAll();

    UserModel getById(@Param("id") Long id);

    UserModel getByNameAndAge(@Param("name") String name,
                              @Param("age") Integer age);

    int add(@Param("model") UserModel model);

    int update(@Param("model") UserModel model);

    int deleteById(@Param("id") Long id);

}