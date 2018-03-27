package com.foo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/12/1
 */
@Getter
@Setter
@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable{
    private static final long serialVersionUID = 8272679709545182358L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "_order")
    private Order order;

    /**
     * 商品ID
     */
    @Column(name = "product_sale")
    private Long productSale;

    /**
     * 购买数量
     */
    @Column(name = "purchase_quantity")
    private Integer purchaseQuantity;

    /**
     * 码洋
     */
    @Column(name = "list_price")
    private BigDecimal listPrice;

    /**
     * 实洋
     */
    @Column(name = "sale_price")
    private BigDecimal salePrice;

}
