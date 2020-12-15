package com.zhbo.study.service.impl;

import com.zhbo.study.dao.UserDao;
import com.zhbo.study.domain.UserModel;
import com.zhbo.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhengbo
 * @date 2020/10/15 13:35
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<UserModel> getPage(int pageStart, int pageSize, String sort, String name, String sex) {
        return userDao.getPage(pageStart, pageSize, sort, name, sex);
    }

    @Override
    public int getPageTotal(String name, String sex) {
        return userDao.getPageTotal(name, sex);
    }

    @Override
    public List<UserModel> getAll() {
        return userDao.getAll();
    }

    @Override
    public UserModel getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public int add(UserModel model) {
        return userDao.add(model);
    }

    @Override
    public int update(UserModel model) {
        return userDao.update(model);
    }

    @Override
    public int deleteById(Long id) {
        return userDao.deleteById(id);
    }

    @Override
    public String testMethod(String name, Long age) {
        if (!StringUtils.isEmpty(name)) {
            System.out.println(name);
        }
        if (age != null) {
            System.out.println(age);
        }
        return "success";
    }
}
