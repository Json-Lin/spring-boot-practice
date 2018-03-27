package com.foo.services.impl;

import com.foo.dao.OrderDao;
import com.foo.model.Order;
import com.foo.model.OrderItem;
import com.foo.services.OrderService;
import com.google.common.base.Preconditions;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;


/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/12/1
 */
@Service("orderService")
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

    private static final Log LOG = LogFactory.getLog(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;

    @Override
    public void create(Order order) {
        checkOrder(order);
        initOrder(order);
        orderDao.save(order);
        LOG.info("create order successed,orderId:" + order.getId());
//        throw new RuntimeException("test exception");
    }

    private void checkOrder(Order order) {
        Preconditions.checkNotNull(order, "order is null.");
        Preconditions.checkArgument(!CollectionUtils.isEmpty(order.getItemList()), "OrderItem is empty.");
    }

    private void initOrder(Order order) {
        BigDecimal totalListPrice = BigDecimal.ZERO;
        BigDecimal totalSalePrice = BigDecimal.ZERO;
        Integer purchaseQuantity = 0;
        Integer purchaseKind = order.getItemList().size();
        for (OrderItem orderItem : order.getItemList()) {
            totalListPrice = totalListPrice.add(orderItem.getListPrice());
            totalSalePrice = totalSalePrice.add(orderItem.getSalePrice());
            purchaseQuantity += orderItem.getPurchaseQuantity();
        }
        order.setTotalListPrice(totalListPrice);
        order.setTotalSalePrice(totalSalePrice);
        order.setPurchaseKinds(purchaseKind);
        order.setPurchaseQuantity(purchaseQuantity);
    }
}
