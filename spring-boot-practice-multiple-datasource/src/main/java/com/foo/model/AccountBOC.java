package com.foo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/12/4
 */
@Setter
@Getter
@Entity
@Table(name = "account_boc")
public class AccountBOC implements Serializable {

    private static final long serialVersionUID = 1820150874495571704L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long customer;

    @Column
    private BigDecimal balance;
}
