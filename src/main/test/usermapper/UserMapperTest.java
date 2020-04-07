package usermapper;

import com.example.mistroe.mapper.UserMapper;
import com.example.mistroe.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zlin
 * @date 2020/4/7 9:38
 */
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    void test(){
        User user = userMapper.selectUserByName("123");
        System.out.println(user);
    }

    public static void main(String[] args) {
        UserMapperTest userMapperTest= new UserMapperTest();
        userMapperTest.test();
    }
}
