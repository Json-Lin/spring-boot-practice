package com.foo.services.test;

import com.foo.model.Order;
import com.foo.model.OrderItem;
import com.foo.services.OrderService;
import com.foo.utils.IdUtils;
import org.assertj.core.util.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Set;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/12/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOrderService {

    @Autowired
    private OrderService orderService;

    @Test
    public void testCreate(){
        Order order  = new Order();
        Set<OrderItem> orderItems = Sets.newHashSet();

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setListPrice(new BigDecimal("11.02"));
        orderItem1.setSalePrice(new BigDecimal("9.99"));
        orderItem1.setOrder(order);
        orderItem1.setProductSale(1222021L);
        orderItem1.setPurchasequantity(1);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setListPrice(new BigDecimal("8.5"));
        orderItem2.setSalePrice(new BigDecimal("8.0"));
        orderItem2.setOrder(order);
        orderItem2.setProductSale(1222056L);
        orderItem2.setPurchasequantity(2);

        orderItems.add(orderItem1);
        orderItems.add(orderItem2);

        order.setId(String.valueOf(IdUtils.next()));
        order.setCustomer("jasonLin");
        order.setItemList(orderItems);
        orderService.create(order);
    }

}
