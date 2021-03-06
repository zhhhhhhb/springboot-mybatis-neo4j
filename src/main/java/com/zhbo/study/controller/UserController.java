package com.zhbo.study.controller;

import com.github.pagehelper.PageInfo;
import com.zhbo.study.domain.UserModel;
import com.zhbo.study.result.PageParam;
import com.zhbo.study.result.PageResult;
import com.zhbo.study.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 分页条件查询
     * 参数例：{"pageIndex":1,"pageSize":2,"sort":"u.sex desc","condition":"{'name':'','sex':'男'}"}
     *
     * @param pageParam
     * @return
     */
    @PostMapping("/getPage")
    public PageResult getPage(@RequestBody PageParam pageParam) throws JSONException {
        int pageStart = pageParam.getPageStart();
        int pageIndex = pageParam.getPageIndex();
        int pageSize = pageParam.getPageSize();
        String sort = pageParam.getSort();

        JSONObject jsonObject = new JSONObject(pageParam.getCondition());
        String name = ".*" + jsonObject.getString("name") + ".*"; //模糊查询
        String sex = jsonObject.getString("sex");

        List<UserModel> models = userService.getPage(pageStart, pageSize, sort, name, sex);
        int total = userService.getPageTotal(name, sex);
        PageResult pageResult = new PageResult(pageIndex, pageSize, total, models);

        return pageResult;
    }

    @GetMapping("/getAll")
    public List<UserModel> getAll() {
        return userService.getAll();
    }

    @GetMapping("/getPage")
    public PageInfo<UserModel> getPage(@RequestParam("pageNum") int pageNum,
                                       @RequestParam("pageSize") int pageSize) {
        return userService.getPage(pageNum, pageSize);
    }


    /**
     * 根据id查询（含节点关系）
     *
     * @param id
     * @return
     */
    @GetMapping("/getById/{id}")
    public UserModel getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping("/add")
    public int add(@RequestBody UserModel model) {
        return userService.add(model);
    }

    @PostMapping("/update")
    public int update(@RequestBody UserModel model) {
        return userService.update(model);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable Long id) {
        return userService.deleteById(id);
    }


    @GetMapping("/getByName")
    public String add(@RequestParam("name") Optional<String> name,
                      @RequestParam("age") Optional<Long> age) {
        return userService.testMethod(name.orElse(null),age.orElse(null));
    }

    @GetMapping("/getByNameAndAge")
    public UserModel getByNameAndAge(@RequestParam("name") String name,
                                     @RequestParam("age") Integer age) {
        return userService.getByNameAndAge(name,age);
    }

    @GetMapping("/getUserIpAddress")
    public String getRemoteIp(HttpServletRequest request) {
        return userService.getUserIpAddress(request);
    }
}
