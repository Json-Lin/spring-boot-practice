package com.foo.dao;

import com.foo.model.Order;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/12/1
 */
public interface OrderDao {
    void save(Order order);
}
