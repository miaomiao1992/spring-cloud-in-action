package com.yunjia.gmall.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("user")
public class User implements Serializable {
    @TableId(type= IdType.AUTO) //解决新增数据自增id很大的问题
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
