package com.zhbo.study.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.zhbo.study.dao.UserDao;
import com.zhbo.study.domain.UserModel;
import com.zhbo.study.service.UserService;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

/**
 * @author zhengbo
 * @date 2020/10/15 13:35
 */
@Service
@Slf4j
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
    public PageInfo<UserModel> getPage(int pageNum, int pageSize) {
        PageMethod.startPage(pageNum, pageSize);
        List<UserModel> list = userDao.getAll();
        return new PageInfo<>(list);
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

    @Override
    public UserModel getByNameAndAge(String name, Integer age) {
        System.out.println("进来查询");
        return userDao.getByNameAndAge(name, age);
    }

    @Override
    public void getUserIpAddress(HttpServletRequest request) {
        String ip = null;

        //X-Forwarded-For：Squid 服务代理
        String ipAddresses = request.getHeader("X-Forwarded-For");
        System.out.println("====ipAddresses:"+ipAddresses);
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            //打印所有头信息
            String s = headerNames.nextElement();
            String header = request.getHeader(s);
            System.out.println(s+"::::"+header);
        }
//        System.out.println("headerNames:"+ JSONObject.toJSONString(headerNames));
        System.out.println("RemoteHost:"+request.getRemoteHost());
        System.out.println("RemoteAddr:"+request.getRemoteAddr());

        String unknown = "unknown";
        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //WL-Proxy-Client-IP：weblogic 服务代理
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //HTTP_CLIENT_IP：有些代理服务器
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //X-Real-IP：nginx服务代理
            ipAddresses = request.getHeader("X-Real-IP");
        }

        //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }

        //还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
         log.info(ip);
    }
}
