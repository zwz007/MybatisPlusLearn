package mybatispluslearn.demo.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String age;
    @TableField(value = "class_id")
    private Long ClassId;

    /*
    *
    * */
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @TableLogic(value = "0",delval = "1")
    private Integer isDelete;
}
