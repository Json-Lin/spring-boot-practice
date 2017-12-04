package com.foo.service.impl;

import com.foo.service.AccountBocService;
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
@Service("accountBocService")
@Transactional(rollbackFor = Exception.class)
public class AccountBocServiceImpl implements AccountBocService {

    private static final String UPDATE_BALANCE = "UPDATE account_boc SET balance = balance+? WHERE customer = ?;";

    private final Log log = LogFactory.getLog(getClass());

    @Autowired
    private JdbcTemplate bocJdbcTemplate;

    @Override
    public void updateBalance(Long customer, BigDecimal amount) {
        bocJdbcTemplate.update(UPDATE_BALANCE, amount, customer);
        if(customer.equals(10002L)){
            throw new RuntimeException("test rollbace on runtimeException.");
        }
        log.info(String.format("update balance ,[customer:%s,amount%s]", customer, amount));
    }
}
