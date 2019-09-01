package com.foo.model;


import lombok.Data;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2019/8/20
 */
@Data
public class Country {
    private Long id;
    private String name;

    public Country(String name) {
        this.name = name;
    }
    public Country() {
    }
}
