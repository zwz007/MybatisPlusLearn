package mybatispluslearn.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mybatispluslearn.demo.mapper.UserMapper;
import mybatispluslearn.demo.pojo.User;
import mybatispluslearn.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

}
