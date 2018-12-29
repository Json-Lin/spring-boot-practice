package com.foo.dao.impl;

import com.foo.dao.OrderDao;
import com.foo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/12/1
 */
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao{

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void save(Order order) {
        hibernateTemplate.save(order);
    }
}
