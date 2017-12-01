package com.foo.services.test;

import com.foo.model.Customer;
import com.foo.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}
