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

    @Column(name = "product_sale")
    private Long productSale;

    @Column(name = "purchase_quantity")
    private Integer purchasequantity;

    @Column(name = "list_price")
    private BigDecimal listPrice;

    @Column(name = "sale_price")
    private BigDecimal salePrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (order != null ? !order.equals(orderItem.order) : orderItem.order != null) return false;
        return productSale != null ? productSale.equals(orderItem.productSale) : orderItem.productSale == null;
    }

    @Override
    public int hashCode() {
        int result = order != null ? order.hashCode() : 0;
        result = 31 * result + (productSale != null ? productSale.hashCode() : 0);
        return result;
    }
}
