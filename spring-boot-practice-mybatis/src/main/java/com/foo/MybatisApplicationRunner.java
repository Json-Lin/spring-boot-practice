package com.foo;

import com.foo.mapper.CityMapper;
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

    public MybatisApplicationRunner(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplicationRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.cityMapper.findByState("成都市"));
    }
}
