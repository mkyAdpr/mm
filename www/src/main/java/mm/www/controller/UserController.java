package mm.www.controller;

import mm.base.entity.User;
import mm.base.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 用户控制层
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 注册用户
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public Object register(){

        try {
            User user = new User();
            user.setUid(UUID.randomUUID().toString());
            user.setUserName("test001");
            user.setPassword("123456");
            user.setNickName("test001");
            Integer i = userService.addUser(user);
            System.out.println("success:" + i);
            return null;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("error:" + e.getMessage());
            return null;
        }
    }
}
