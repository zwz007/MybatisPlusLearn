package mybatispluslearn.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("class")
public class MyClass {
    @TableId
    private Long id;
    private String name;
}
