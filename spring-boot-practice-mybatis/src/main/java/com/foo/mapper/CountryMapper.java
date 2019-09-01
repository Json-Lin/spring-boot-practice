package com.foo.mapper;

import com.foo.model.Country;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2019/8/20
 */
@Mapper
public interface CountryMapper {

    Country findById(Long id);

    Long create(Country country);
}
