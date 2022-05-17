package mybatispluslearn.demo.util;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mybatispluslearn.demo.exception.MyParamInjectException;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MyPage {
    private long size=2;
    private long pageNum=1;
    private String order="asc";
    private String order_field;

    public MyPage(Map<String,String> params) {
        String pageNum = params.get("pageNum");
        String size = params.get("size");
        String order_field=params.get("order_field");
        String order = params.get("order");
        if(pageNum!=null){
            this.pageNum = Long.parseLong(params.get("pageNum"));
        }
        if(size!=null){
            this.size = Long.parseLong(params.get("size"));
        }
        if(order_field!=null){
            //order_field有sql注入风险，处理一下
            order_field = params.get("order_field");

            if(order!=null){
                order=params.get("order");
            }
        }
    }
    public <T> Page<T> getPage() throws Exception {
        Page<T> page = new Page<>();
        page.setSize(size);
        page.setCurrent(pageNum);
        if(order_field!=null){
            order_field=sqlInject(order_field);
            page.setOrders(Arrays.stream(order_field.split(",")).map(field->{
                return order.equals("asc")? OrderItem.asc(field):OrderItem.desc(field);
            }).collect(Collectors.toList()));
        }
        return page;
    }

    public static String sqlInject(String str) throws MyParamInjectException {
        if(StringUtils.isBlank(str)){
            return null;
        }
        //去掉'|"|;|\字符
        str = str.replace( "'", "");
        str = str.replace( "\"", "");
        str = str.replace( ";", "");
        str = str.replace( "\\", "");
        //转换成小写
        str = str.toLowerCase();
        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alter", "drop"};
        //判断是否包含非法字符
        for(String keyword : keywords){
            if(str.indexOf(keyword) != -1){
                throw new MyParamInjectException("包含非法字符");
            }
        }
        return str;
    }
}