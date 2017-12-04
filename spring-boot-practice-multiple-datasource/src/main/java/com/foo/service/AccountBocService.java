package com.foo.service;

import java.math.BigDecimal;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/12/4
 */
public interface AccountBocService {

    void updateBalance(Long customer, BigDecimal amount);
}
