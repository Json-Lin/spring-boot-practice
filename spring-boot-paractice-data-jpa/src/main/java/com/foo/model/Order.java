package com.foo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/12/1
 */
@Getter
@Setter
@Entity
@Table(name = "_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1854996605034612378L;

    @Id
    private String id;

    @Column(name = "total_list_price")
    private BigDecimal totalListPrice;

    @Column(name = "total_sale_price")
    private BigDecimal totalSalePrice;

    @Column(name = "purchase_quantity")
    private Integer purchaseQuantity;

    /**
     * 品种数量
     */
    @Column(name = "purchase_kinds")
    private Integer purchaseKinds;

    @Column
    //正常情况下存储的是客户ID
    private String customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", targetEntity = OrderItem.class)
    private Set<OrderItem> itemList;
}
