package com.foo.configura;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author JasonLin
 * @version V1.0
 * @date 2017/12/1
 */
@Configuration
public class Conf {

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.connection.release_mode", "after_transaction");
        properties.put("hibernate.cache.use_second_level_cache", false);
        properties.put("hibernate.cache.use_query_cache", false);
        sessionFactory.setHibernateProperties(properties);
        sessionFactory.setPackagesToScan("com.foo.model");
        return sessionFactory;
    }

    @Bean("transactionManager")
    HibernateTransactionManager getHibernateTransactionManager(@Qualifier("sessionFactory") SessionFactory sessionFactory){
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean("hibernateTemplate")
    HibernateTemplate getHibernateTemplate(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        HibernateTemplate hibernateTemplate = new HibernateTemplate();
        hibernateTemplate.setSessionFactory(sessionFactory);
        return hibernateTemplate;
    }
}
