package cn.itbluebox.product.entity;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
/*
商品实体类
 */
@Data
@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    private Long id;
    private String productName;
    private Integer status;
    private BigDecimal price;//Java在java.math包中提供的API类BigDecimal，用来对超过16位有效位的数进行精确的运算
    private String productDesc;
    private String caption;
}

