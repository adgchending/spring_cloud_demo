package cn.itbluebox.product.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
/*
商品实体类
 */
@Data
@Table(name = "tb_product")
public class TbProduct {
    @Id
    private Integer id;
    private String productName;
    private Integer status;
    private Double price;//Java在java.math包中提供的API类BigDecimal，用来对超过16位有效位的数进行精确的运算
    private String productDesc;
    private String caption;
    private Integer inventory;
}

