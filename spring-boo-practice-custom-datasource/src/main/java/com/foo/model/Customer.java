package com.foo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/12/1
 */
@Setter
@Getter
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = -7896459795783095454L;

    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nike_name")
    private String nikeName;

    @Column
    private String email;

    @Column
    private String mobile;

    @Column
    private String phone;

    @Column
    private String address;
}
