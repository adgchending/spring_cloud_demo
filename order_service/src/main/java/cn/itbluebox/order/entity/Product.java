package cn.itbluebox.order.entity;

import lombok.Data;

import java.math.BigDecimal;
/*
商品实体类
 */
@Data
public class Product {
    private Long id;
    private String productName;
    private Integer status;
    private BigDecimal price;//Java在java.math包中提供的API类BigDecimal，用来对超过16位有效位的数进行精确的运算
    private String productDesc;
    private String caption;
}

