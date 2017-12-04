package com.foo.service.impl;

import com.foo.model.Customer;
import com.foo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/12/1
 */
@Service("customerService")
@Transactional(rollbackFor = Exception.class)
public class CustomerServiceImpl implements CustomerService {

    private static final String INSERT_CUSTOMER = "INSERT INTO customer (nike_name,email,mobile,phone,address) VALUES (?,?,?,?,?);";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Customer customer) {
        jdbcTemplate.update(INSERT_CUSTOMER, customer.getNikeName(),
                customer.getEmail(), customer.getMobile(),
                customer.getPhone(), customer.getAddress());
        if("rollbackUser".equals(customer.getNikeName())){
            throw new RuntimeException("test rollback on runtimeException.");
        }
    }
}
