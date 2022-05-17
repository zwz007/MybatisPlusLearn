package mybatispluslearn.demo.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UserWithClass{
    private Long id;
    private String name;
    private String age;
    private Long ClassId;
    private Date updateTime;
    private Date createTime;
    private Integer isDelete;
    private String ClassName;
}
