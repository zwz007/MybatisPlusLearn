package mybatispluslearn.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mybatispluslearn.demo.pojo.User;
import mybatispluslearn.demo.pojo.UserWithClass;
import mybatispluslearn.demo.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.*;
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<UserVo> findAllUserWithClass(@Param("pageNum")long pageNum,@Param("pageSize")long pageSize);

    List<UserWithClass> findAllUserWithClass2();
}
