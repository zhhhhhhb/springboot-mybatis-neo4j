package com.zhbo.study.service;

import com.zhbo.study.domain.UserModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * @author zhengbo
 * @date 2020/10/15 13:35
 */
public interface UserService {
    List<UserModel> getPage(@Param("pageStart") int pageStart,
                            @Param("pageSize") int pageSize,
                            @Param("sort") String sort,
                            @Param("name") String name,
                            @Param("sex") String sex);

    int getPageTotal(@Param("name") String name,
                     @Param("sex") String sex);

    List<UserModel> getAll();

    UserModel getById(@Param("id") Long id);

    int add(@Param("model") UserModel model);

    int update(@Param("model") UserModel model);

    int deleteById(@Param("id") Long id);

    String testMethod(@RequestParam("name") String name,
                      @RequestParam("age") Long age);

    UserModel getByNameAndAge(@RequestParam("name") String name,
                              @RequestParam("age") Integer age);
}
