package com.foo.dao;

import com.foo.model.City;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2019/8/20
 */
@Repository
public class CityDao {

    private final SqlSession sqlSession;

    public CityDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public City selectCityById(long id) {
        return this.sqlSession.selectOne("selectCityById", id);
    }

}
