package com.foo;

import com.foo.service.AccountBocService;
import com.foo.service.AccountCcbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/12/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountCcbService accountCcbService;

    @Autowired
    private AccountBocService accountBocService;

    @Test
    public void testTransferAccountCcbToBoc() {
        accountCcbService.transferAccountToBoc(10001L, new BigDecimal(-100));
    }

    @Test
    public void testTransferAccountCcbToBocOnException() {
        accountCcbService.transferAccountToBoc(10002L, new BigDecimal(100));
    }

    @Test
    public void testUpdateCcbBalance() {
        accountCcbService.updateBalance(10001L, new BigDecimal(100));
    }

    @Test
    public void testUpdateBocBalance() {
        accountBocService.updateBalance(10001L, new BigDecimal(100));
    }
}
