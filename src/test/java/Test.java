import com.zhbo.study.App;
import com.zhbo.study.domain.UserModel;
import com.zhbo.study.service.UserService;
import com.zhbo.study.service.impl.UserServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author zhengbo
 * @date 2020/12/16 18:16
 */
@SpringBootTest(classes=App.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class Test {

    @Resource
    private UserService userService;

    @org.junit.Test
    public void getByNameAndAge() {
        UserModel userModel = userService.getByNameAndAge("ccc", 23);
        if (userModel == null) {
            System.out.println("没找到");
        } else {
            System.out.println(userModel.getName());
        }

    }
}
