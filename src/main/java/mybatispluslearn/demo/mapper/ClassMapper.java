package mybatispluslearn.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mybatispluslearn.demo.pojo.MyClass;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassMapper extends BaseMapper<MyClass> {
}
