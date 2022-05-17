package mybatispluslearn.demo.vo;

import lombok.Data;
import mybatispluslearn.demo.pojo.MyClass;
import java.util.*;
@Data
public class UserVo{
    private Long id;
    private String name;
    private String age;
    private Long C_Id;
    private Date updateTime;
    private Date createTime;
    private Integer isDelete;
    private List<MyClass> myClasses;
}
