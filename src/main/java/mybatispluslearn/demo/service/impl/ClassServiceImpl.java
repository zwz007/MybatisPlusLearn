package mybatispluslearn.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mybatispluslearn.demo.mapper.ClassMapper;
import mybatispluslearn.demo.pojo.MyClass;
import mybatispluslearn.demo.service.ClassService;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, MyClass> implements ClassService {

}
