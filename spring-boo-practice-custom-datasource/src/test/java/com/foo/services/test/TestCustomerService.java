package com.foo.services.test;

import com.foo.model.Customer;
import com.foo.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/12/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCustomerService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testCreateCustomer(){
        Customer customer = new Customer();
        customer.setAddress("四川成都");
        customer.setEmail("xxx@qq.com");
        customer.setMobile("15708111111");
        customer.setNikeName("JasonLin");
        customer.setPhone("028-125468");
        customerService.create(customer);
    }

    @Test
    public void testRollback(){
        Customer customer = new Customer();
        customer.setAddress("四川成都");
        customer.setEmail("xxx@qq.com");
        customer.setMobile("15708111111");
        customer.setNikeName("rollbackUser");
        customer.setPhone("028-125468");
        customerService.create(customer);
    }

    @Test
    public void testSearchCustomer() {
        String sql = "SELECT id FROM customer WHERE nike_name = 'JasonLin'";
        Assert.notEmpty(jdbcTemplate.queryForList(sql, Long.class));
    }
}
