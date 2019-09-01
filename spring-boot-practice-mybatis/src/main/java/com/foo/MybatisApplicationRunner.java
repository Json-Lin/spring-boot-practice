package com.foo;

import com.foo.dao.CityDao;
import com.foo.mapper.CityMapper;
import com.foo.mapper.CountryMapper;
import com.foo.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2019/8/20
 */
@SpringBootApplication
public class MybatisApplicationRunner implements CommandLineRunner {

    private final CityMapper cityMapper;
    @Autowired
    private CityDao cityDao;
    @Autowired
    private CountryMapper countryMapper;

    public MybatisApplicationRunner(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplicationRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(this.cityMapper.findByState("成都市"));
//        System.out.println(cityDao.selectCityById(1L));
//        System.out.println(countryMapper.findById(20L));
        Country contry = new Country("大国");
        System.out.println(countryMapper.create(contry));
        System.out.println(contry.getId());
    }
}
