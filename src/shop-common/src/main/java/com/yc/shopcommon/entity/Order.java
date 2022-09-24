package com.yc.shopcommon.entity;

import lombok.Data;

@Data
public class Order {
     private Long oid;//订单id
    private Integer uid;//用户id
    private String username;//用户名
    private Integer pid;//商品id
    private String pname;//商品名称
    private Double pprice;//商品单价
    private Integer number;//购买数量
}