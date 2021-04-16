package mm.base.dao;

import mm.base.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * 用户Dao类
 */
@Repository
public class UserDao extends BaseDao{

    /**
     * 增加用户
     */
    public Integer insert(User user) throws Exception{
        try {
            if(StringUtils.isEmpty(user.getUid())) {
                throw new RuntimeException("用户UUID生成无效!!!");
            }
            if(StringUtils.isEmpty(user.getUserName())){
                throw new RuntimeException("用户账号无效!!!");
            }
            if(StringUtils.isEmpty(user.getPassword())){
                throw new RuntimeException("用户密码无效!!!");
            }
            if(StringUtils.isEmpty(user.getNickName())){
                throw new RuntimeException("用户昵称无效!!!");
            }
            String sql = "insert into tb_user (UID, USERNAME, PASSWORD, NICKNAME) values (?, ?, ?, ?)";
            return template.update(sql, user.getUid(), user.getUserName(), user.getPassword(), user.getNickName());
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("新增用户失败!!!以下为具体错误信息：" + e.getMessage());
        }
    }
}
