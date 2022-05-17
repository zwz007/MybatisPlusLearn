package mybatispluslearn.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mybatispluslearn.demo.mapper.UserMapper;
import mybatispluslearn.demo.pojo.MyClass;
import mybatispluslearn.demo.pojo.User;
import mybatispluslearn.demo.service.ClassService;
import mybatispluslearn.demo.service.UserService;
import mybatispluslearn.demo.util.MyPage;
import mybatispluslearn.demo.vo.UserVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    UserService userService;

    @Autowired
    ClassService classService;
    /**
     * 测试MP的插入方法
     */
    @Test
    void testMPInsert(){
        User user = new User();
        user.setName("曾大帅");
        user.setAge("25");
        user.setClassId((long) 1);
        System.out.println(userService.save(user));
    }

    /**
     * 测试MP的删除方法
     */
    @Test
    void testMPDelete(){
        User user = new User();
        user.setId((long) 9);
        System.out.println(userService.remove(new QueryWrapper<>(user)));
    }

    /**
     * 测试MP的update方法
     */
    @Test
    void testMPUpdate(){
        User user = new User();
        user.setId((long) 10);
        user.setName("fff");
        System.out.println(userService.update(user,new UpdateWrapper<User>().eq("id",user.getId())));
    }

    /*
    * 测试MP的select方法
    * */
    @Test
    void testMPSelect(){
        User user = new User();
        user.setId((long) 9);
        user.setAge("25");
        User user2 = userService.getOne(new QueryWrapper<User>().eq("id", user.getId()));
        System.out.println(userService.list(new QueryWrapper<User>().eq("age",user.getAge())));
    }

    /**
     * 测试MP的page方法,但是前端一般传入的分页参数、排序参数是封装在map中，每次new Page，然后设置排序字段则太麻烦了！
     * @throws Exception
     */

    @Test
    void testMPSelect2() throws Exception {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("pageNum","1");
        params.put("pageSize","2");
        params.put("order_filed","age,name");
        params.put("order","desc");
        Page<User> page = new MyPage(params).<User>getPage();
        Page<User> res = userService.page(page);
        System.out.println(res.getRecords()+"\n"+res.getTotal());
    }

    /**
     * 测试嵌套查询：使用XML
     */
    @Test
    void testMPNestSelect(){
        System.out.println(((UserMapper)userService.getBaseMapper()).findAllUserWithClass(0,2));
    }

    /**
     * 测试嵌套查询：使用QueryMapper
     */
    @Test
    void testNestSelect2(){
        System.out.println(userService.list().stream().map(user -> {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user,userVo);
            userVo.setMyClasses(classService.list(new QueryWrapper<MyClass>().eq("id", user.getClassId())));
            return userVo;
        }).collect(Collectors.toList()));
    }

    /**
     *测试LeftJoin:使用XML
     */
    @Test
    void testLeftJoin(){
        BaseMapper<User> baseMapper = userService.getBaseMapper();
        System.out.println(((UserMapper) baseMapper).findAllUserWithClass2());
    }
}
