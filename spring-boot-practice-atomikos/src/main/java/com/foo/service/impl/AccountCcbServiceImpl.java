package com.foo.service.impl;

import com.foo.service.AccountBocService;
import com.foo.service.AccountCcbService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/12/4
 */
@Service("accountCcbService")
@Transactional(rollbackFor = Exception.class)
public class AccountCcbServiceImpl implements AccountCcbService {

    private static final String UPDATE_BALANCE = "UPDATE account_ccb SET balance = balance+? WHERE customer = ?;";

    private final Log log = LogFactory.getLog(getClass());

    @Autowired
    private JdbcTemplate ccbJdbcTemplate;

    @Autowired
    private AccountBocService accountBocService;

    @Override
    public void transferAccountToBoc(Long customer, BigDecimal amount) {
        updateBalance(customer, amount.multiply(new BigDecimal("-1")));
        accountBocService.updateBalance(customer, amount);
        log.info(String.format("transfer balance to boc  ,[customer:%s,amount:%s]", customer, amount));
    }

    @Override
    public void updateBalance(Long customer, BigDecimal amount) {
        ccbJdbcTemplate.update(UPDATE_BALANCE, amount, customer);
        log.info(String.format("update balance ,[customer:%s,amount:%s]", customer, amount));
    }
}
