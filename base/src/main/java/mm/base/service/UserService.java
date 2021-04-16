package mm.base.service;

import mm.base.dao.UserDao;
import mm.base.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户业务类
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * 增加用户
     */
    public Integer addUser(User user) throws Exception{
        return userDao.insert(user);
    }
}
