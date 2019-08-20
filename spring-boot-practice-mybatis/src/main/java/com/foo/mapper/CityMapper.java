package com.foo.mapper;

import com.foo.model.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2019/8/20
 */
@Mapper
public interface CityMapper {

    @Select("SELECT * FROM CITY WHERE NAME = #{state}")
    City findByState(@Param("state") String state);

}